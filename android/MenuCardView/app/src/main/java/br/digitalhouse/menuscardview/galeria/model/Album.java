package br.digitalhouse.menuscardview.galeria.model;

import androidx.fragment.app.Fragment;

public class Album {
    private int imagem;
    private String banda;
    private Fragment fragment;

    public Album(String banda, Fragment fragment) {
        this.banda = banda;
        this.fragment = fragment;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
