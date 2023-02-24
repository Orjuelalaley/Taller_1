package com.example.taller1;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.webkit.WebViewClient;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.taller1.databinding.ActivityInfoPaisesBinding;

public class InfoPaisesActivity extends AppCompatActivity {

    ActivityInfoPaisesBinding binding;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_paises);
        String  nombre = getIntent().getExtras().getString("nombre");
        String namePais_internacional = getIntent().getExtras().getString("namePais_internacional");
        String region = getIntent().getExtras().getString("Region");
        String codigo = getIntent().getExtras().getString("Codigo");
        String IMG = getIntent().getExtras().getString("FlagPng");
        binding = ActivityInfoPaisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SetInfo(nombre,codigo,region,namePais_internacional,IMG);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Información del país");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.grey_200)));
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.grey_200));
    }
    public InfoPaisesActivity(){
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void SetInfo(String nombre, String codigo,String region,String namePais_internacional, String IMG){
        binding.namePais.setText(nombre);
        binding.namePaisInternacional.setText(namePais_internacional);
        binding.siglaInfo.setText(codigo);
        binding.regionInfo.setText(region);
        Glide.with(this).load(IMG).into(binding.Imageview);
    }

}
