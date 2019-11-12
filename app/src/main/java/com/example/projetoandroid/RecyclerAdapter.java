package com.example.projetoandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<Tarefa> tarefas;

    public RecyclerAdapter(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tarefa tarefa = tarefas.get(position);

        holder.titulo.setText(tarefa.getTitulo());
        holder.descricao.setText(tarefa.getDescricao());
        holder.usuario.setText(tarefa.getUsuario().getNome());
     //   holder.foto.setImageView(tarefa.getFoto());


    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        TextView titulo = itemView.findViewById(R.id.txtTitulo);
        TextView descricao = itemView.findViewById(R.id.txtDescricao);
        TextView usuario = itemView.findViewById(R.id.txtUsuario);
        ImageView foto = itemView.findViewById(R.id.imageView);




    }
}
