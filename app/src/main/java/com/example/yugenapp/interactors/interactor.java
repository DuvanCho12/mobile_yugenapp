package com.example.yugenapp.interactors;

import com.example.yugenapp.interfaces.animeService;
import com.example.yugenapp.models.ArrayAnime;
import com.example.yugenapp.models.datosApi;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class interactor {

    //instancia con la retrofit
    private Retrofit retrofit;

    public interface onDataDetailsFetched {

        void onSucess(ArrayList<datosApi> ferResultData);
        void onFailure();

    }

    //Aquí obtengo los atos de la consulta
    public void obtenerDatos(onDataDetailsFetched listenner, String palabra) {

        //construyo los objetos necesarios de retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jikan.moe")
                .addConverterFactory(GsonConverterFactory.create())   //convierto el archivo json
                .build();

        animeService service = retrofit.create(animeService.class);

        Call<ArrayAnime> respuesta = service.obtenerArrayAnime(palabra);

        respuesta.enqueue(new Callback<ArrayAnime>() {
            @Override
            public void onResponse(Call<ArrayAnime> call, Response<ArrayAnime> response) {
                if (!response.isSuccessful()) {
                    listenner.onFailure();
                    return;
                }
                ArrayAnime arrayanime = response.body();
                ArrayList<datosApi> anime = arrayanime.getResults();
                listenner.onSucess(anime);
            }

            @Override
            public void onFailure(Call<ArrayAnime> call, Throwable t) {

            }
        });
    }

    //Aquí obtengo el Array completo
    public void obtenerArray(onDataDetailsFetched lista) {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jikan.moe/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        animeService servicio = retrofit.create(animeService.class);

        Call<ArrayAnime> respues = servicio.obtenerArray();
        respues.enqueue(new Callback<ArrayAnime>() {
            @Override
            public void onResponse(Call<ArrayAnime> call, Response<ArrayAnime> response) {
                if (!response.isSuccessful()) {
                    lista.onFailure();
                    return;
                }
                ArrayAnime array = response.body();
                ArrayList<datosApi> datos = array.getResults();
                lista.onSucess(datos);

            }

            @Override
            public void onFailure(Call<ArrayAnime> call, Throwable t) {

            }
        });

    }
}
