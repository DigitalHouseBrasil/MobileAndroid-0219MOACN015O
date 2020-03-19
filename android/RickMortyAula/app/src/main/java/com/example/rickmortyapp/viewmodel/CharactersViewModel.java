package com.example.rickmortyapp.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.rickmortyapp.model.CharactersResponse;
import com.example.rickmortyapp.model.Result;
import com.example.rickmortyapp.repository.CharactersRespository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CharactersViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> listMutableLiveData = new MutableLiveData<>();
    public LiveData<List<Result>> listLiveData = listMutableLiveData;
    private CompositeDisposable disposable = new CompositeDisposable();
    private CharactersRespository respository = new CharactersRespository();

    public CharactersViewModel(@NonNull Application application) {
        super(application);
    }

    public void getListCharacters(){
        disposable.add(
                respository.charactersResponseObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(charactersResponse -> listMutableLiveData.setValue(charactersResponse.getResults()),
                        throwable -> Log.i("LOG", "MESSAGE -> " + throwable.getMessage()))
        );
    }
}
