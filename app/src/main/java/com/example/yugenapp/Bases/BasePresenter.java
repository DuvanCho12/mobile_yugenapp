package com.example.yugenapp.Bases;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;


//esta clase contiene el ciclo de vida de un activity e inyecta al presenter con el ciclo de vida
public class BasePresenter {

    public BasePresenter(){

    }
    //llama a la superclase e implementa los métodos allá
    @CallSuper
    void onCreate(@Nullable final Bundle onSaveInstanceState){

    }
    @CallSuper
    void onResume(){

    }
    @CallSuper
    void onPause(){

    }
    @CallSuper
    void onSaveInstanceState(@Nullable final Bundle outState){

    }
    @CallSuper()
    void onDestroy(){

    }
    @CallSuper
    void onActivityResult(int requestCode, int ResultCode, @Nullable final Intent data){

    }

    @CallSuper
    void onRequestPermissionResult(final int requestCode, @Nullable final String[] permissions,
                          @Nullable final int []grantResults){

    }
}
