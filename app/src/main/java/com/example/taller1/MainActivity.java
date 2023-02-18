package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.taller1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BtnJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++; // Aumentar el contador
                actualizarTextoBoton(); // Actualizar el texto del botón
            }
        });
    }
    private void actualizarTextoBoton() {
        binding.Info.setText("Presionado " + contador + " veces");
    }
}