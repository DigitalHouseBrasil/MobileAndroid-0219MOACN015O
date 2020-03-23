package com.example.albunsmusicasapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.albunsmusicasapp.model.Album;
import com.example.albunsmusicasapp.model.ArtistaResult;
import com.example.albunsmusicasapp.repository.ArtistaRepository;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.albunsmusicasapp.util.AppUtil.verificaConexaoComInternet;

public class ArtistaViewModel extends AndroidViewModel {

    private ArtistaRepository repository = new ArtistaRepository();
    private CompositeDisposable disposable = new CompositeDisposable();

    private MutableLiveData<List<Album>> mutableLiveDataAlbum = new MutableLiveData<>();
    public LiveData<List<Album>> liveDataAlbum = mutableLiveDataAlbum;

    private MutableLiveData<String> mutableLiveDataErro = new MutableLiveData<>();
    public LiveData<String> liveDataErro = mutableLiveDataErro;

    private MutableLiveData<Boolean> mutableLiveDataLoading = new MutableLiveData<>();
    public LiveData<Boolean> liveDataLoading = mutableLiveDataLoading;

    public ArtistaViewModel(@NonNull Application application) {
        super(application);
    }

    public void getAlbuns(String nomeBanda) {
        if (verificaConexaoComInternet(getApplication())) {
            recuperaOsDadosApi(nomeBanda);
        } else {
            carregaDadosBD();
        }
    }

    private void recuperaOsDadosApi(String nomeBanda) {
        disposable.add(
                repository.retornaAlbunsApi(nomeBanda)
                        .map(this::insereDadosBd)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> mutableLiveDataLoading.setValue(true))
                        .doOnTerminate(() -> mutableLiveDataLoading.setValue(false))
                        .subscribe(artistaResult ->
                                        mutableLiveDataAlbum.setValue(artistaResult.getAlbum()),
                                throwable -> {
                                    mutableLiveDataErro.setValue(throwable.getMessage());
                                    carregaDadosBD();
                                })
        );
    }

    private void carregaDadosBD() {
        disposable.add(
                repository.retornaAlbunsBD(getApplication())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> mutableLiveDataLoading.setValue(true))
                        .doAfterTerminate(() -> mutableLiveDataLoading.setValue(false))
                        .subscribe(albumList ->
                                        mutableLiveDataAlbum.setValue(albumList),
                                throwable ->
                                        mutableLiveDataErro.setValue(throwable.getMessage() + "problema banco de dados"))
        );
    }

    private ArtistaResult insereDadosBd(ArtistaResult artistaResult) {
        repository.insereArtistaResultBd(artistaResult.getAlbum(), getApplication());
        return artistaResult;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
