package com.example.albunsmusicasapp.network;

import com.example.albunsmusicasapp.model.ArtistaResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ArtistaAPI {

    @GET("{APIKEY}/searchalbum.php")
    Observable<ArtistaResult> retornaArtistaApi(
            @Path("APIKEY") String apiKey,
            @Query("s") String nomeBanda);
}
