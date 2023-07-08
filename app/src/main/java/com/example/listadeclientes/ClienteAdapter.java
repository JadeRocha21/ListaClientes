package com.example.listadeclientes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> {
    private List<Cliente> listaClientes;
    private OnItemClickListener listener;


    public ClienteAdapter(List<Cliente> listaClientes, OnItemClickListener listener) {
        this.listaClientes = listaClientes;
        this.listener = listener;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onRemoverClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNome;
        private TextView txtCpf;
        private TextView txtDataNascimento;
        private TextView txtEndereco;
        private Button btnEditar;
        private Button btnRemover;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.etNome);
            txtCpf = itemView.findViewById(R.id.etCpf);
            txtDataNascimento = itemView.findViewById(R.id.etDataNascimento);
            txtEndereco = itemView.findViewById(R.id.etEndereco);
            btnEditar = itemView.findViewById(R.id.btnEditar);
            btnRemover = itemView.findViewById(R.id.btnRemover);

            // Define os cliques dos botões
            btnEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            btnRemover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onRemoverClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente, parent, false);
        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!listaClientes.isEmpty()) {
            Cliente cliente = listaClientes.get(position);
            holder.txtNome.setText(cliente.getNome());
            holder.txtCpf.setText("CPF: " + cliente.getCpf());
            holder.txtDataNascimento.setText("Data de Nascimento: " + cliente.getDataNascimento());
            holder.txtEndereco.setText("Endereço: " + cliente.getEndereco());
        }

    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }
}

