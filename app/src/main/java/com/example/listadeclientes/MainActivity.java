package com.example.listadeclientes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnAdicionar;
    private Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnMostrar = findViewById(R.id.btnMostrar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaAdicionar();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaMostrar();
            }
        });
    }

    private void abrirTelaAdicionar() {
        Intent intent = new Intent(MainActivity.this, AdicionarActivity.class);
        startActivity(intent);
    }

    private void abrirTelaMostrar() {
        Intent intent = new Intent(MainActivity.this, ExibirActivity.class);
        startActivity(intent);
    }
}
