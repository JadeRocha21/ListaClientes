package com.example.listadeclientes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditarActivity extends AppCompatActivity {
    private EditText etNome;
    private EditText etCpf;
    private EditText etDataNascimento;
    private EditText etEndereco;
    private Button btnSalvar;

    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        etNome = findViewById(R.id.etNome);
        etCpf = findViewById(R.id.etCpf);
        etDataNascimento = findViewById(R.id.etDataNascimento);
        etEndereco = findViewById(R.id.etEndereco);
        btnSalvar = findViewById(R.id.btnSalvar);

        Intent intent = getIntent();
        if (intent.hasExtra("cliente")) {
            cliente = intent.getParcelableExtra("cliente");
            preencherCampos();
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarAlteracoes();
            }
        });
    }

    private void preencherCampos() {
        etNome.setText(cliente.getNome());
        etCpf.setText(cliente.getCpf());
        etDataNascimento.setText(cliente.getDataNascimento());
        etEndereco.setText(cliente.getEndereco());
    }

    private void salvarAlteracoes() {
        String nome = etNome.getText().toString();
        String cpf = etCpf.getText().toString();
        String dataNascimento = etDataNascimento.getText().toString();
        String endereco = etEndereco.getText().toString();

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setDataNascimento(dataNascimento);
        cliente.setEndereco(endereco);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("cliente", (CharSequence) cliente);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
