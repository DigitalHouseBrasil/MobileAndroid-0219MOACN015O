package br.digitalhouse.padraoarquitetura.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.digitalhouse.padraoarquitetura.model.Produto;
import br.digitalhouse.padraoarquitetura.repository.ProdutoRepository;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ProdutoViewModel extends AndroidViewModel {
    private ProdutoRepository repository = new ProdutoRepository();
    private MutableLiveData<List<Produto>> mutableProduto = new MutableLiveData<>();
    public LiveData<List<Produto>> liveDataProduto = mutableProduto;
    private CompositeDisposable disposable = new CompositeDisposable();

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
                                    Log.i("Error", throwable.getMessage());
                                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
