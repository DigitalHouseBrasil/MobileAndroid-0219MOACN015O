package com.example.animesjson.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.animesjson.model.Anime;
import com.example.animesjson.repository.AnimesRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AnimesListViewModel extends AndroidViewModel {

    private MutableLiveData<List<Anime>> listaAnime = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private AnimesRepository repository = new AnimesRepository();
    private CompositeDisposable disposable = new CompositeDisposable();


    public AnimesListViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Anime>> retornaAnimeMutable() {
        return this.listaAnime;
    }

    public LiveData<Boolean> retornaValorLoading() {
        return this.loading;
    }

    public void renderizaAnimes() {
        disposable.add(
                repository.animesResponseSingle(
                        getApplication().getApplicationContext())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> loading.setValue(true))
                .doAfterTerminate(() -> loading.setValue(false))
                .subscribe(animesResponse -> listaAnime.setValue(animesResponse.getAnimes()),
                        throwable -> Log.i("LOG", "Falha ao redenrizar Animes" + throwable.getMessage()))
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
