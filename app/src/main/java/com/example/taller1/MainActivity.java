package com.example.taller1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import com.example.taller1.databinding.ActivityMainBinding;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SharedPreferences prefs;
    private int counter_juego = 0;
    private int counter_paises = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getPreferences(MODE_PRIVATE);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.grey)));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.grey));

        binding.btnEmpezarJuego.setOnClickListener(view -> {
            counter_juego++;
            actualizarInfoPulsado_juego();
            guardarFecha_juego();
            Intent intent = new Intent(this, JuegoActivity.class);
            startActivity(intent);
        });

        binding.btnMostrarPaises.setOnClickListener(view -> {
            counter_paises++;
            actualizarInfoPulsado_paises();
            guardarFecha_paises();
            Intent intent = new Intent(this, ListaPaisesActivity.class);
            startActivity(intent);
        });
    }

    @SuppressLint("SetTextI18n")
    private void actualizarInfoPulsado_paises() {
        if (counter_paises  == 1)
            binding.InfoPulsadoPaises.setText("El boton ha sido pulsado " + counter_paises + " vez.");
        else if (counter_paises > 1){
            binding.InfoPulsadoPaises.setText("El boton ha sido pulsado " + counter_paises + " veces.");
        }
    }

    private void guardarFecha_juego() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.getDefault());
        String fechaActual = dateFormat.format(new Date());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("fecha_ultimo_click", fechaActual);
        editor.apply();
        mostrarFecha_juego();
    }
    private void guardarFecha_paises() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.getDefault());
        String fechaActual = dateFormat.format(new Date());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("fecha_ultimo_click", fechaActual);
        editor.apply();
        mostrarFecha_paises();
    }

    @SuppressLint("SetTextI18n")
    private void mostrarFecha_paises() {
        String fechaGuardada = prefs.getString("fecha_ultimo_click", "Nunca");
        binding.infoUltimaVezPaises.setText("Usado por ultima ves el  " + fechaGuardada+".");
    }

    @SuppressLint("SetTextI18n")
    private void mostrarFecha_juego() {
        String fechaGuardada = prefs.getString("fecha_ultimo_click", "Nunca");
        binding.infoUltimaVezJuego.setText("Usado por ultima ves el  " + fechaGuardada+".");

    }

    @SuppressLint("SetTextI18n")
    private void actualizarInfoPulsado_juego() {
        if (counter_juego == 1)
            binding.InfoPulsadoJuego.setText("El boton ha sido pulsado " + counter_juego + " vez.");
        else if (counter_juego > 1){
            binding.InfoPulsadoJuego.setText("El boton ha sido pulsado " + counter_juego + " veces.");
        }
    }

}