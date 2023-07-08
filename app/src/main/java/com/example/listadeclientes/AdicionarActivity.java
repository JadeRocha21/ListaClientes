package com.example.listadeclientes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdicionarActivity extends AppCompatActivity {
    private EditText etNome;
    private EditText etDataNascimento;
    private EditText etCpf;
    private EditText etEndereco;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);


        etNome = findViewById(R.id.etNome);
        etDataNascimento = findViewById(R.id.etDataNascimento);
        etCpf = findViewById(R.id.etCpf);
        etEndereco = findViewById(R.id.etEndereco);
        btnSalvar = findViewById(R.id.btnSalvar);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarCliente();
            }
        });

    }
    private void salvarCliente() {
        String nome = etNome.getText().toString();
        String dataNascimento = etDataNascimento.getText().toString();
        String cpf = etCpf.getText().toString();
        String endereco = etEndereco.getText().toString();

        if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty() || endereco.isEmpty()) {
            Toast.makeText(AdicionarActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Cliente novoCliente = new Cliente(nome, cpf, dataNascimento, endereco);

        Toast.makeText(this, "Cliente salvo com sucesso!", Toast.LENGTH_SHORT).show();

        finish();
    }

}
