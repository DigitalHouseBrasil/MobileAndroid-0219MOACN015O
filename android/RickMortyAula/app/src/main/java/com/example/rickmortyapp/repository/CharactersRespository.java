package com.example.rickmortyapp.repository;

import com.example.rickmortyapp.model.CharactersResponse;

import io.reactivex.Observable;

import static com.example.rickmortyapp.network.ServiceRetrofit.getApiService;

public class CharactersRespository {

    public Observable<CharactersResponse> charactersResponseObservable(){
        return getApiService().getCharactersResponse();
    }

}
