  package com.example.yugenapp.presenters;

import com.example.yugenapp.Activity_inicio;
import com.example.yugenapp.Bases.BasePresenter;
import com.example.yugenapp.interactors.interactor;
import com.example.yugenapp.interfaces.animeinicio;
import com.example.yugenapp.models.datosApi;

import java.util.ArrayList;

public class presenter extends BasePresenter implements interactor.onDataDetailsFetched{

    private animeinicio inicio;
    private interactor interactor;

    public presenter(animeinicio inicio, interactor interactor) {
        this.inicio = inicio;
        this.interactor = interactor;
    }

    public void nombre(String palabra){
        interactor.obtenerDatos(this, palabra);
    }

    @Override
    public void onSucess(ArrayList<datosApi> ferResultData) {
        inicio.mostrarAnime(ferResultData);
        inicio.resultado();
    }

    @Override
    public void onFailure() {
        inicio.noresult();
        inicio.mostrarpogress();
    }

    public void inicio(Activity_inicio Activity_inicio) {
        interactor.obtenerArray(this);
    }
}
