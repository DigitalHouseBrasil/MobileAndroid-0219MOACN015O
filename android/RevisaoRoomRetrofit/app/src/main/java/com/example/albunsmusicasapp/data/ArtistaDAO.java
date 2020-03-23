package com.example.albunsmusicasapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.albunsmusicasapp.model.Album;
import com.example.albunsmusicasapp.model.ArtistaResult;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ArtistaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insereListaBD(List<Album> listaAlbum);

    @Query("SELECT * FROM artista")
    Flowable<ArtistaResult> recuperaAlbunsDoBD();

    @Delete
    void apagaDadosBd(ArtistaResult artistaResult);
}
