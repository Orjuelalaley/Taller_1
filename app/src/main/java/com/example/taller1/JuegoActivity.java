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

import java.util.Random;

public class JuegoActivity extends AppCompatActivity{
    private int numero;
    private EditText numeroIngresado;
    private Button botonAdivinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("¡Adivina el número!");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.Cyan)));

        numeroIngresado = findViewById(R.id.numero_ingresado);
        botonAdivinar = findViewById(R.id.boton_adivinar);
        botonAdivinar.setOnClickListener(v -> {
            adivinar(v);
        });

    }

    public void adivinar(View view){
        int numeroIng = Integer.parseInt(numeroIngresado.getText().toString());
        numeroIngresado.setText("");

        if(numeroIng == numero){
            Toast.makeText(getApplicationContext(), "¡Adivino el numero! 🎉", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SorpresaActivity.class);
            intent.putExtra("res", numero);
            numero = new Random().nextInt(100);
            startActivity(intent);

        } else {
            if(numeroIng < numero)
                Toast.makeText(getApplicationContext(), "El numero es mayor ⬆️", Toast.LENGTH_SHORT).show();
            else if(numeroIng > numero)
                Toast.makeText(getApplicationContext(), "El numero es menor ⬇️️", Toast.LENGTH_SHORT).show();
        }
    }
}
