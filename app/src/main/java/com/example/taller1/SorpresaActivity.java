package com.example.taller1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.webkit.WebViewClient;

import com.example.taller1.databinding.ActivitySorpresaBinding;

public class SorpresaActivity extends AppCompatActivity {


    private ActivitySorpresaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySorpresaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Fuiste Rickroleado");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.Cyan)));

        binding.webViewContainer.setWebViewClient(new WebViewClient());
        binding.webViewContainer.getSettings().setJavaScriptEnabled(true);
        binding.botonSorpresa.setOnClickListener(view -> binding.webViewContainer.loadUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley"));
    }
}
