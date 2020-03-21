package com.example.albunsmusicasapp.data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.albunsmusicasapp.model.Album;
import com.example.albunsmusicasapp.model.ArtistaResult;

@Database(entities = {Album.class, ArtistaResult.class}, version = 1, exportSchema = false)
public abstract class ArtistaDataBase extends RoomDatabase {

    private static volatile ArtistaDataBase INSTANCE;

    public abstract ArtistaDAO artistaDAO();

    public static ArtistaDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (ArtistaDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ArtistaDataBase.class, "musicas_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
