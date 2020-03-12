package br.digitalhouse.padraoarquitetura.repository.data;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import br.digitalhouse.padraoarquitetura.model.Produto;

public class ProdutoConverter {

    /// Type converter para uma lista
    @TypeConverter
    public List<Produto> fromString(String value) {
        Type listType = (Type) new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<Produto> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

}
