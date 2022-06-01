package com.example.yugenapp.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.example.yugenapp.models.ArrayAnime;
import com.example.yugenapp.models.ArrayAnime;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

    public interface animeService {

        @GET("/v3/search/anime?q=")
        Call<ArrayAnime> obtenerArrayAnime(@Query("q") String q);

        @GET("search/anime?q=&order_by=members&sort=desc&page=1&limit=48")
        Call<ArrayAnime> obtenerArray();


    }

