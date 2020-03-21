package com.example.albunsmusicasapp.network;

public class ArtistaService {

    private static final String BASE_URL = "https://theaudiodb.com/api/v1/json/";
    private static final String API_KEY= "195003/";
    private static Retrofit retrofit;

    private static Retrofit getRetrofit() {

        // Se a variavém retrofite estiver nula inicializamos
        if (retrofit == null) {

            // Configuração de parametros de conexão
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30, TimeUnit.SECONDS);

            // Se estivermos em modo DEBUG habilitamos os logs
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(httpLoggingInterceptor);
                httpClient.addNetworkInterceptor(new StethoInterceptor());
            }

            // inicializamos o retrofit com as configurações
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL+API_KEY)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    // Retornamos a api criada com o retrofit
    public static API getApiService() {
        return getRetrofit().create(API.class);
    }
}
