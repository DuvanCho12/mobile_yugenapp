package com.example.yugenapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import jp.wasabeef.blurry.Blurry;

public class animeselect extends AppCompatActivity {

    private ImageView fondo, fondo1;
    private TextView titulo, sinop, episodios, puntos, typo, clas, enlace;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_animeselect);

        fondo = findViewById(R.id.fondo);
        titulo = findViewById(R.id.titulo);
        sinop = findViewById(R.id.synopsis);
        episodios = findViewById(R.id.episodios);
        puntos = findViewById(R.id.puntuacion);
        typo = findViewById(R.id.tipo);
        clas = findViewById(R.id.clasificacion);
        enlace = findViewById(R.id.url);

        fondo1 = findViewById(R.id.fondo1);

        rootView = (View) findViewById(R.id.linearLayout2);
        String imagen = getIntent().getStringExtra("img");
        Glide.with(this)
                .load(imagen)
                .into(fondo);
        Glide.with(this)
                .load(imagen)
                .into(fondo1);

        rootView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Blurry.with(getApplicationContext()).radius(25).sampling(2).onto((ViewGroup) rootView);

            }
        },0500);


        String title = getIntent().getStringExtra("titulo");
        titulo.setText(title);

        String sinopsis = getIntent().getStringExtra("sinop");
        sinop.setText(sinopsis);

        String capitulos = getIntent().getStringExtra("episode");
        episodios.setText(capitulos);

        String puntuacion = getIntent().getStringExtra("punt");
        puntos.setText(puntuacion);

        String clasificacion = getIntent().getStringExtra("rated");
        clas.setText(clasificacion);

        String tipo = getIntent().getStringExtra("tipo");
        typo.setText(tipo);

        String url = getIntent().getStringExtra("link");
        enlace.setText(url);




    }
}