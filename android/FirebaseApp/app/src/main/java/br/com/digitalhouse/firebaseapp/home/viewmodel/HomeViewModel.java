package br.com.digitalhouse.firebaseapp.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import br.com.digitalhouse.firebaseapp.model.Result;
import br.com.digitalhouse.firebaseapp.util.AppUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.firebaseapp.network.RetrofitService.API_KEY;
import static br.com.digitalhouse.firebaseapp.network.RetrofitService.getApiService;

public class HomeViewModel extends AndroidViewModel {
    public MutableLiveData<List<Result>> filmesLiveData = new MutableLiveData<>();
    public MutableLiveData<Result> favoriteAdded = new MutableLiveData<>();
    public MutableLiveData<Throwable> resultLiveDataError = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void buscarFilmes() {
        disposable.add(
                getApiService().buscarFilmes(API_KEY, "PT-BR")
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe((Disposable disposable) -> isLoading.setValue(true))
                        .doOnTerminate(() -> isLoading.setValue(false))
                        .subscribe(movieResponse ->
                                {
                                    filmesLiveData.setValue(movieResponse.getResults());
                                }
                                , throwable -> {
                                    //Se deu algum erro na requisição mostramos a mensagem de erro e carregamos o dados da base de dados
                                    resultLiveDataError.setValue(throwable);
                                })
        );
    }


    public void salvarFavorito(Result result) {
        // Pegamos a instancia do firebase, objeto necessario para salvar no banco de dados
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // pegamos a referencia para onde no firebase queremos salvar nossos dados
        DatabaseReference reference = database.getReference(AppUtil.getIdUsuario(getApplication()) + "/favorites");

        //Verifica no firebase se já existe o objeto como id
        reference.orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Variável de controle
                boolean existe = false;

                // Quando retornar algo do firebase percorremos os dados e validamos
                for (DataSnapshot resultSnapshot : dataSnapshot.getChildren()) {
                    Result firebaseResult = resultSnapshot.getValue(Result.class);

                    //Verifica se o dado já existe
                    if (firebaseResult != null &&
                            firebaseResult.getId() != null &&
                            firebaseResult.getId().equals(result.getId())) {
                        existe = true;
                    }
                }

                // Se existe no firebase mostramos a mensagem de já existente
                if (existe) {
                    resultLiveDataError.setValue(new Throwable(result.getTitle() + ": Já existe no Firebase"));
                } else {
                    salvarFavoritoVerificado(reference, result);
                }
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    // Registra o usuário na base de dados do Firebase
    private void salvarFavoritoVerificado(DatabaseReference reference, Result result) {
        // criamos uma chave unica para o item, assim não haverá conflitos
        String key = reference.push().getKey();

        // setamos o item no caminho da chave criada ex: favorites/kfdhsifyadfhidf/filme
        reference.child(key).setValue(result);

        // Adicionnamos um listener pra sabermos se o item foi salvo no firebase
        reference.child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Result result1 = dataSnapshot.getValue(Result.class);

                // mostamos qe foi salvo nos favoritos
                favoriteAdded.setValue(result1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
