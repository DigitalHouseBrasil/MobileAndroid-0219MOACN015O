package com.example.albunsmusicasapp.repository;

import android.content.Context;

import com.example.albunsmusicasapp.data.ArtistaDataBase;
import com.example.albunsmusicasapp.model.Album;
import com.example.albunsmusicasapp.model.ArtistaResult;
import com.example.albunsmusicasapp.network.ArtistaService;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public class ArtistaRepository {

    public Observable<ArtistaResult> retornaAlbunsApi(String nomeBanda) {
        return ArtistaService.getApiService().retornaArtistaApi("1", nomeBanda);
    }

    public Flowable<ArtistaResult> retornaAlbunsBD(Context context) {
        return ArtistaDataBase.getDatabase(context).artistaDAO().recuperaAlbunsDoBD();
    }

    public void insereArtistaResultBd(List<Album> albumList, Context context){
        ArtistaDataBase.getDatabase(context).artistaDAO().insereListaBD(albumList);
    }

    public void apagaOsDadosBD(ArtistaResult artistaResult, Context context){
        ArtistaDataBase.getDatabase(context).artistaDAO().apagaDadosBd(artistaResult);
    }
}
