package com.example.listadeclientes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExibirActivity extends AppCompatActivity {
    private List<Cliente> listaClientes;
    private ClienteAdapter clienteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);

        listaClientes = obterListaClientes();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clienteAdapter = new ClienteAdapter(listaClientes, new ClienteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Cliente clienteSelecionado = listaClientes.get(position);
                Toast.makeText(ExibirActivity.this, "Cliente selecionado: " + clienteSelecionado.getNome(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRemoverClick(int position) {
                listaClientes.remove(position);
                clienteAdapter.notifyItemRemoved(position);
                Toast.makeText(ExibirActivity.this, "Cliente removido", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(clienteAdapter);

        Button btnEditar = findViewById(R.id.btnEditar);
        Button btnRemover = findViewById(R.id.btnRemover);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private List<Cliente> obterListaClientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("João", "12345678901", "01/01/1990", "Rua A, 123"));
        clientes.add(new Cliente("Maria", "98765432101", "10/05/1985", "Rua B, 456"));
        clientes.add(new Cliente("José", "56789012345", "25/12/1978", "Rua C, 789"));
        return clientes;
    }
}
