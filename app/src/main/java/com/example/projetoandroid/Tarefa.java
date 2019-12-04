package com.example.projetoandroid;

import android.widget.ImageView;

import java.util.Date;

public class Tarefa {
    Integer id;
    String descricao;
    String titulo;
    String foto;
    Usuario usuario;

    public Tarefa(String descricao, String titulo) {
        this.descricao = descricao;
        this.titulo = titulo;
    }

    public Tarefa() {

    }

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
       this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
