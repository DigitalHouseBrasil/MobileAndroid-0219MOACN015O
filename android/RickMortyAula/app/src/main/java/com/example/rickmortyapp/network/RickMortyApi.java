package com.example.rickmortyapp.network;

import com.example.rickmortyapp.model.CharactersResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface RickMortyApi {

    @GET("character")
    Observable<CharactersResponse> getCharactersResponse();
}
