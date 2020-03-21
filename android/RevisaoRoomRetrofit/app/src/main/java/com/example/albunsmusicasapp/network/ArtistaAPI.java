package com.example.albunsmusicasapp.network;

import com.example.albunsmusicasapp.model.ArtistaResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArtistaAPI {

    @GET("searchalbum.php")
    Observable<ArtistaResult> retornaArtistaApi(String nomeBanda);

}
