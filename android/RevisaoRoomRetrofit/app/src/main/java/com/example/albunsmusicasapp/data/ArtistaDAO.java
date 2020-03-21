package com.example.albunsmusicasapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.albunsmusicasapp.model.Album;
import com.example.albunsmusicasapp.model.ArtistaResult;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ArtistaDAO {

    @Insert
    void insereListaBD(List<Album> listaAlbum);

    @Query("SELECT * FROM album")
    Flowable<ArtistaResult> recuperaAlbunsDoBD();

    @Delete
    void apagaTodosAlbuns();

}
