package com.example.animesjson.repository;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.animesjson.model.AnimesResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.reactivex.Single;

public class AnimesRepository {

    public Single<AnimesResponse> animesResponseSingle(Context context) {

        try {
            //Cria um stream para ler o arquivo JSON
            AssetManager manager = context.getAssets();

            //Abre o arquivo JSON criado
            InputStream inputStream = manager.open("animes.json");

            //Pega o ponto de referencia(inputStream) do arquivo JSON e cria um array de Bites
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            //Inicio da utilização do GSON
            Gson gson = new Gson();

            /*Conversão do aqruivo JSON para objetos em Java, o parametro do método
            gson.fromJson espera o bufferedReader que é o array em bites do JSON, e a
            classe que deve representar esse dado.
             */
            AnimesResponse animesResponse = gson.fromJson(reader, AnimesResponse.class);

            //Retorno do método
            //O Observable.just irá retornar apenas um dado que nesse caso é um objeto do tipo NoticiaResposta
            return Single.just(animesResponse);

        } catch (IOException ex) {
            ex.printStackTrace();
            return Single.error(ex.getCause());
        }

    }
}
