package com.example.yugenapp.interfaces;

import com.example.yugenapp.models.datosApi;

import java.util.ArrayList;

public interface  animeinicio {

    void mostrarAnime(ArrayList<datosApi> listaResultado);

    void fetchResultsDetails(String query);

    void resultado();

    void noresult();

    void mostrarpogress();




}

