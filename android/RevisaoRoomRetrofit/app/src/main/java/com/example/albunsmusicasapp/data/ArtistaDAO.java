package com.example.albunsmusicasapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.albunsmusicasapp.model.Album;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ArtistaDAO {

    @Insert
    void insereListaBD(Album album);

    @Query("SELECT * FROM album")
    Flowable<List<Album>> recuperaAlbunsDoBD();

}
