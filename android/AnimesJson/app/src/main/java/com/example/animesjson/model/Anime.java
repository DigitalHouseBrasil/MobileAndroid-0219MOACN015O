
package com.example.animesjson.model;

import com.google.gson.annotations.Expose;

public class Anime {

    @Expose
    private String descricao;
    @Expose
    private String estudio;
    @Expose
    private String ilustrador;
    @Expose
    private String titulo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getIlustrador() {
        return ilustrador;
    }

    public void setIlustrador(String ilustrador) {
        this.ilustrador = ilustrador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
