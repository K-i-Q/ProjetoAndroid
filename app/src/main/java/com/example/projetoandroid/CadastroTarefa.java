package com.example.projetoandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

public class CadastroTarefa extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int PIC_CROP = 2;
    private static final String TAG = "CadastroTarefa";
    private static DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference();
    private static StorageReference strgReference = FirebaseStorage.getInstance().getReference();
    private ImageView fotoTarefa;
    private Uri fotoTarefaUri = null;
    private Bitmap fotoTarefaBitmap = null;


    Button btnTirarFoto;
    Button btnCadastrarTarefa;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST  && resultCode == RESULT_OK){
            fotoTarefaBitmap  = (Bitmap) data.getExtras().get("data");
            fotoTarefa.setImageBitmap(fotoTarefaBitmap);
            fotoTarefaUri = data.getData();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_tarefa);

        btnCadastrarTarefa = findViewById(R.id.btnCadastrarTarefa);

        btnTirarFoto = findViewById(R.id.btnTirarFoto);
        fotoTarefa = findViewById(R.id.imgFoto);

        btnTirarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, CAMERA_REQUEST);
            }

        });
    }
    public void abrirCamera(View view){
        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, CAMERA_REQUEST);
    }

    public void cadastrarTarefa(View view){

                Tarefa tarefa = new Tarefa();

                TextView txtTitulo = findViewById(R.id.txtTitulo);
                TextView txtDescricao = findViewById(R.id.txtDescricao);

                tarefa.setTitulo(txtTitulo.getText().toString());
                tarefa.setDescricao(txtDescricao.getText().toString());


        if (fotoTarefaBitmap != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            fotoTarefaBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] data = baos.toByteArray();

            String encodedfile = Base64.encodeToString(data, Base64.DEFAULT);
            tarefa.foto = encodedfile;
        }
        dbReference.child("tarefas").child(dbReference.child("tarefas").push().getKey()).setValue(tarefa);
        Intent i = new Intent(CadastroTarefa.this,ListaTarefas.class);
        startActivity(i);

    }





}
