package com.example.taller1;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taller1.databinding.ActivityInfoPaisesBinding;
import com.example.taller1.utils.AlertUtils;

import java.util.Set;

public class InfoPaisesActivity extends AppCompatActivity {

    ActivityInfoPaisesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_paises);
        String  nombre = getIntent().getExtras().getString("nombre");
        String region = getIntent().getExtras().getString("Region");
        String codigo = getIntent().getExtras().getString("Codigo");
        String IMG = getIntent().getExtras().getString("FlagPng");
        binding = ActivityInfoPaisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SetInfo(nombre,region,codigo,IMG);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Información del país");
    }
    public InfoPaisesActivity(){
    }

    public void SetInfo(String nombre, String region, String codigo,String IMG){
        binding.namePais.setText(nombre);
        binding.regionPais.setText(region);
        binding.code.setText(codigo);
        binding.flagUrl.setText(IMG);
    }

}
