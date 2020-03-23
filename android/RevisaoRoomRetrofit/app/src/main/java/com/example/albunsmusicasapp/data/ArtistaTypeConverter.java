package com.example.albunsmusicasapp.data;

import androidx.room.TypeConverter;

import com.example.albunsmusicasapp.model.Album;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ArtistaTypeConverter {

    @TypeConverter
    public Object fromObject(String value) {
        Type listType = (Type) new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromJsonObject(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    @TypeConverter
    public List<Album> fromListAlbum(String value) {
        Type listType = (Type) new TypeToken<List<Album>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromListAlbumObject(List<Album> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
