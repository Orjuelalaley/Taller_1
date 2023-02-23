package com.example.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taller1.data.CountriesFromJson;
import com.example.taller1.databinding.ActivityListaPaisesBinding;
import com.example.taller1.utils.AlertUtils;

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
                    AlertUtils.shortToast(this, pais.getString("Region")+ " " + pais.getString("NativeName"));
                    String nombreEnIngles = pais.optString("Name");
                    String codigoIso = pais.optString("Alpha2Code");
                    String Region = pais.optString("Region");
                    Intent intent = new Intent(this, InfoPaisesActivity.class);
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
