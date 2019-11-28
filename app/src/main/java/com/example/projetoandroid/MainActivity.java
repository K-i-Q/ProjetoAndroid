package com.example.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnListar = findViewById(R.id.btnLista);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ListaTarefas.class);
                startActivity(i);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CadastroTarefa.class);
                startActivity(i);
            }
        });


    }


}
