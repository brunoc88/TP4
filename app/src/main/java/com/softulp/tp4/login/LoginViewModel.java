package com.softulp.tp4.login;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.softulp.tp4.MainActivity;

import java.util.Collections;
import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean>mutableIncorreto;
    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> getMutableIncorrecto(){
        if(mutableIncorreto == null){
            mutableIncorreto = new MutableLiveData<>();
        }
        return mutableIncorreto;
    }

    public void getAutentificacion(String usuario, String password){
        Log.d("salida","Ingreso al metodo");
        Log.d("salida",usuario);
        Log.d("salida",password);
        String user = "bruno";
        String pass = "123";
        if(usuario.equals(user)&& password.equals(pass)){
            Log.d("salida","Correcto");
            Intent intent = new Intent(getApplication(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        }else{
            mutableIncorreto.setValue(false);
        }
    }
}
