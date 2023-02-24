package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import androidx.appcompat.app.ActionBar;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taller1.databinding.ActivityJuegoBinding;
import com.example.taller1.databinding.ActivityListaPaisesBinding;
import com.example.taller1.utils.AlertUtils;

import java.util.Random;

public class JuegoActivity extends AppCompatActivity{
    ActivityJuegoBinding binding;
    private EditText numeroIngresado;
    private Button botonAdivinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_juego);
        binding = ActivityJuegoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("¡Adivina el número!");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.Cyan)));
        Random random = new Random();
        int numeroRandom = random.nextInt(50);
        binding.botonAdivinar.setOnClickListener(v -> {
            adivinar(numeroRandom);
        });
    }

    public void adivinar(int numeroRandom){
        String numerito = binding.numeroIngresado.getText().toString();
        try{
            int numeroIngresado = Integer.parseInt(numerito);
            if (numeroIngresado == numeroRandom){
                AlertUtils.shortToast(this, "¡Felicidades, adivinaste!");
                Intent intent = new Intent(this, SorpresaActivity.class);
                startActivity(intent);
            }else if (numeroIngresado > numeroRandom){
                AlertUtils.shortToast(this, "¡El numero ingresado es mayor !Owo!");
            } else if (numeroIngresado < numeroRandom) {
                AlertUtils.shortToast(this, "¡Lo siento, El numero ingresado es menor !OwO!");
            }
        }catch (NumberFormatException e){
            AlertUtils.shortToast(this, "Ingrese un número");
        }


    }
}
