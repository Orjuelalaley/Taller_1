package com.example.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taller1.data.CountriesFromJson;
import com.example.taller1.databinding.ActivityListaPaisesBinding;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaPaisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        com.example.taller1.databinding.ActivityListaPaisesBinding binding = ActivityListaPaisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Lista de paises");

        try {
            CountriesFromJson archivo = new CountriesFromJson();
            archivo.loadCountriesByJson(getAssets().open(CountriesFromJson.COUNTRIES_FILE));
            List<String> paises = new ArrayList<>();

            for (int i = 0; i < archivo.getSize(); i++) {
                paises.add(archivo.getCountries().getJSONObject(i).getString("NativeName"));

            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paises);
            binding.listViewPaises.setAdapter(adapter);
            binding.listViewPaises.setOnItemClickListener((parent, view, position, id) -> {
                try {
                    JSONObject pais = archivo.getCountries().getJSONObject(position);
                    String nombreEnIngles = pais.optString("Name");
                    String codigoIso = pais.optString("Alpha2Code");
                    String Region = pais.optString("Region");
                    String FlagPng = pais.optString("FlagPng");
                    Intent intent = new Intent(this, InfoPaisesActivity.class);
                    intent.putExtra("nombre",nombreEnIngles);
                    intent.putExtra("Region",Region);
                    intent.putExtra("Codigo",codigoIso);
                    intent.putExtra("FlagPng",FlagPng);
                    startActivity(intent);
                } catch (Exception ex) {
                    System.err.println("error: " + ex.getMessage());
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
