package com.softulp.tp4.login;

import static android.Manifest.permission.CALL_PHONE;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.tp4.Llamadas;

public class LoginMainActivity extends AppCompatActivity {
    private com.softulp.tp4.databinding.ActivityLoginMainBinding binding;
    private LoginViewModel mv;
    private Llamadas llamada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = com.softulp.tp4.databinding.ActivityLoginMainBinding.inflate(getLayoutInflater());

        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);
        setContentView(binding.getRoot());
        pedirPermiso();
        registraBroadCast();
        //creamos el observador y usamos toast para crear mensaje incorrecto

        mv.getMutableIncorrecto().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Toast.makeText(LoginMainActivity.this, "Usuario y/o Incorrecto", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = binding.etUsuario.getText().toString();
                String password = binding.etPassword.getText().toString();
                Log.d("entrada",usuario);
                Log.d("entrada",password);
                //llamo al metodo de validacion
                mv.getAutentificacion(usuario,password);
            }
        });

    }


    private void pedirPermiso(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{CALL_PHONE},1000);
        }
    }

    private void registraBroadCast(){
        this.llamada = new Llamadas();
        IntentFilter filter = new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE");
        registerReceiver(llamada, filter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(llamada);
    }
}