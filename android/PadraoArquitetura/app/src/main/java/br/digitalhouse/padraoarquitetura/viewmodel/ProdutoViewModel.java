package br.digitalhouse.padraoarquitetura.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import br.digitalhouse.padraoarquitetura.model.Produto;
import br.digitalhouse.padraoarquitetura.repository.ProdutoRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ProdutoViewModel extends AndroidViewModel {
    private ProdutoRepository repository = new ProdutoRepository();
    private MutableLiveData<List<Produto>> mutableProduto = new MutableLiveData<>();
    public LiveData<List<Produto>> liveDataProduto = mutableProduto;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<String> errorMutable = new MutableLiveData<>();
    public LiveData<String> erro = errorMutable;

    public ProdutoViewModel(@NonNull Application application) {
        super(application);
    }

    public void getTodosProdutos(Context context) {
        disposable.add(
                repository.getAllProdutos(context)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(produto -> {
                                    mutableProduto.setValue(produto);
                                },
                                throwable -> {
                                    errorMutable.setValue(throwable.getMessage());
                                })
        );
    }

    public void insereProduto(Produto produto, Context context) {
        new Thread((() -> {
            if (produto != null) {
                repository.insereProduto(produto, context);
            }
        }
        )).start();
    }

    public void apagaProduto(String nome, Context context) {
        new Thread(() -> {
            if (!nome.isEmpty()) {
                Produto produto = repository.retornaProdutoPorNome(nome, context);
                if (produto != null) {
                    repository.apagaProduto(produto, context);
                }
            }
        }).start();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
