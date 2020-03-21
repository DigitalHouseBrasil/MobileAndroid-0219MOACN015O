package com.example.albunsmusicasapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.albunsmusicasapp.model.Album;
import com.example.albunsmusicasapp.repository.ArtistaRepository;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

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

    public void recuperaOsDadosApi(String apiKey, String nomeBanda) {
        disposable.add(
                repository.retornaAlbunsApi(apiKey, nomeBanda)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> mutableLiveDataLoading.setValue(true))
                        .doOnTerminate(() -> mutableLiveDataLoading.setValue(false))
                        .subscribe(artistaResult ->
                                        mutableLiveDataAlbum.setValue(artistaResult.getAlbum()),
                                throwable -> {
                                    mutableLiveDataErro.setValue(throwable.getMessage());
                                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
