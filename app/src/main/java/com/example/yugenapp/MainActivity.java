package com.example.yugenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        Animation animacion3 = AnimationUtils.loadAnimation(this, R.anim.desvanecer);

        TextView yugen = findViewById(R.id.yugen_splash);
        TextView yugenjapones = findViewById(R.id.yugenjapones_splash);
        TextView duvan = findViewById(R.id.duvan);
        TextView power = findViewById(R.id.power);
        LottieAnimationView mafufeliz = findViewById(R.id.mafufeliz);

        yugen.setAnimation(animacion1);
        yugenjapones.setAnimation(animacion2);
        duvan.setAnimation(animacion1);
        power.setAnimation(animacion1);
        mafufeliz.setAnimation(animacion3);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Activity_inicio.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
}