package com.example.projetoandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

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
        layoutManager = new LinearLayoutManager(this);


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ImageView imgViewFotoTarefa = findViewById(R.id.imgFotoTarefa);
                Tarefa tarefa;
                if(dataSnapshot.exists()){
                    for (DataSnapshot ds : dataSnapshot.getChildren()){
                        for(DataSnapshot d : ds.getChildren()){
                            tarefa = ds.getValue(Tarefa.class);
                            tarefa.titulo = d.child("titulo").getValue(String.class);
                            tarefa.descricao = d.child("descricao").getValue(String.class);
                            //tarefa.foto = d.child("foto").getValue(String.class);
                            //byte[] decodedString = Base64.decode(tarefa.foto, Base64.DEFAULT);
                            //Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                            //imgViewFotoTarefa.setImageBitmap(decodedByte);
                            tarefas.add(new Tarefa(tarefa.descricao,tarefa.titulo));
                            recyclerView.setLayoutManager(layoutManager);
                            mAdapter = new RecyclerAdapter(tarefas);
                            recyclerView.setAdapter(mAdapter);
                        }
                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
