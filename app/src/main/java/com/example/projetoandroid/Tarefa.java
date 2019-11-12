package com.example.projetoandroid;

import android.widget.ImageView;

import java.util.Date;

public class Tarefa {
    Integer id;
    String descricao;
    String titulo;
    ImageView foto;
    Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
       this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
