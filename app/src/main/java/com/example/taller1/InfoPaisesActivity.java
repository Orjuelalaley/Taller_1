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

    public InfoPaisesActivity(String nombrePais, String sigla, String nombreInternacional) {
        this.nombrePais = nombrePais;
        this.Sigla = sigla;
        this.NombreInternacional = nombreInternacional;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String sigla) {
        Sigla = sigla;
    }

    public String getNombreInternacional() {
        return NombreInternacional;
    }

    public void setNombreInternacional(String nombreInternacional) {
        NombreInternacional = nombreInternacional;
    }
}
