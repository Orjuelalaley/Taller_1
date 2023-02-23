package com.example.taller1;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taller1.databinding.ActivityInfoPaisesBinding;

public class InfoPaisesActivity extends AppCompatActivity {
    ActivityInfoPaisesBinding binding = ActivityInfoPaisesBinding.inflate(getLayoutInflater());

    private String nombrePais;
    private String Sigla;
    private String NombreInternacional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_paises);
        setContentView(binding.getRoot());
    }

}
