package com.softulp.tp4.ui.llamar;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LlamarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mError;

    public LlamarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String>getMsjError(){
        if(mError == null){
            mError = new MutableLiveData<>();
        }
        return mError;
    }

    public void llamar(String numero){
        if(numero == null || numero.trim().isEmpty()){
            mError.setValue("Ingrese un numero");
        }else{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+numero));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //iniciar una activity desde un lugar que no es una activity
            getApplication().startActivity(intent);
        }
    }

}