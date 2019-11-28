package com.example.projetoandroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tarefas);

        recyclerView = findViewById(R.id.recyclerView);
        final ArrayList<Tarefa> tarefas = new ArrayList<>();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.child("tarefas").getChildren()){
                    String titulo = ds.child("titulo").getValue(String.class);
                    String descricao = ds.child("descricao").getValue(String.class);
                    tarefas.add(new Tarefa(descricao, titulo));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerAdapter(tarefas);
        recyclerView.setAdapter(mAdapter);
    }
}
