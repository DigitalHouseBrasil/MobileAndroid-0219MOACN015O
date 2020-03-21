package com.example.albunsmusicasapp.repository;

import android.content.Context;

import com.example.albunsmusicasapp.data.ArtistaDataBase;
import com.example.albunsmusicasapp.model.ArtistaResult;
import com.example.albunsmusicasapp.network.ArtistaService;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class ArtistaRepository {

    public Observable<ArtistaResult> retornaAlbunsApi(String apiKey, String nomeBanda) {
        return ArtistaService.getApiService().retornaArtistaApi(apiKey, nomeBanda);
    }

    public Flowable<ArtistaResult> retornaAlbunsBD(Context context) {
        return ArtistaDataBase.getDatabase(context).artistaDAO().recuperaAlbunsDoBD();
    }
}
