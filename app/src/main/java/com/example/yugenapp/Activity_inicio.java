package com.example.yugenapp;

import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.example.yugenapp.Bases.BaseActivity;
import com.example.yugenapp.interactors.interactor;
import com.example.yugenapp.interfaces.animeinicio;
import com.example.yugenapp.models.ListaAnimeAdapter;
import com.example.yugenapp.models.datosApi;
import com.example.yugenapp.presenters.presenter;
import java.util.ArrayList;

public class Activity_inicio extends BaseActivity<presenter> implements animeinicio{

    RecyclerView recicler;
    ListaAnimeAdapter listaAnimeAdapter;
    LottieAnimationView nored;
    TextView nowifi;

    @NonNull
    @Override
    protected presenter createPresenter(@NonNull Context context) {
        return new presenter(this, new interactor());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        mPresenter.inicio(this);

        nored = findViewById(R.id.mafuenojado);
        nowifi = findViewById(R.id.nored);
    }

    @Override
    public void mostrarAnime(ArrayList<datosApi> listaResultado) {

        listaAnimeAdapter = new ListaAnimeAdapter(listaResultado, Activity_inicio.this);
        recicler = findViewById(R.id.recivler_inicio);
        recicler.setHasFixedSize(true);
        recicler.setLayoutManager(new LinearLayoutManager(Activity_inicio.this));
        recicler.setAdapter(listaAnimeAdapter);
        recicler.setHasFixedSize(true);
        recicler.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recicler.setLayoutManager(layoutManager);
    }

    @Override
    public void fetchResultsDetails(String Query) {
        mPresenter.nombre(Query);
    }
    @Override
    public void resultado() {
            recicler.setVisibility(View.VISIBLE);
    }

    @Override
    public void noresult() {

    }

    @Override
    public void mostrarpogress() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        MenuItem buscador = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(buscador);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchResultsDetails(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                listaAnimeAdapter.filter(newText);
                return false;
            }

        });
        return super.onCreateOptionsMenu(menu);
    }

}

