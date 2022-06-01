package com.example.yugenapp.Bases;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//BaseActivity es la superclase que inyecta el presenter con los métodos que estan en BasePresenter (en este caso es el ciclo de vida)
public abstract class BaseActivity<Presenter extends BasePresenter> extends AppCompatActivity {       //BaseActivivity extiende a base presenter

    protected Presenter mPresenter;

    @NonNull
    protected abstract Presenter createPresenter(@NonNull final Context context);

    @Override
    public void onCreate(@Nullable Bundle sabedInstanceState) {
        super.onCreate(sabedInstanceState);
        mPresenter=createPresenter(this);
        mPresenter.onCreate(sabedInstanceState);
    }
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistableBundle){
        super.onSaveInstanceState(outState, outPersistableBundle);
        mPresenter.onSaveInstanceState(outState);
    }
    public void onPause(){
        super.onPause();
        mPresenter.onPause();
    }
    public void onResume(){
        super.onResume();
        mPresenter.onResume();
    }
    public void onDestroy(){
        super.onDestroy();
        mPresenter.onDestroy();
    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }
    public void  onRequestPermissionsResult(int requestCode, @Nullable String[] permissions, @Nullable int []grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mPresenter.onRequestPermissionResult(requestCode, permissions, grantResults);
    }
}
