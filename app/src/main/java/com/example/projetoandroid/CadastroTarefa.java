package com.example.projetoandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

public class CadastroTarefa extends AppCompatActivity {

    Button btnTirarFoto;
    final Integer CODIGO_CAMERA = 1;
    ImageView foto;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODIGO_CAMERA && resultCode == RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            foto.setImageBitmap(photo);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_tarefa);

        btnTirarFoto = findViewById(R.id.btnTirarFoto);
        foto = findViewById(R.id.imgFoto);

        btnTirarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(i, CODIGO_CAMERA);
            }

        });
    }

    public void abrirCamera(View view){
        Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(i, CODIGO_CAMERA);
    }
}
