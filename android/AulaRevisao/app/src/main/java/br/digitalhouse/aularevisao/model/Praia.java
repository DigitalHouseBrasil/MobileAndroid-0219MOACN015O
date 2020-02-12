package br.digitalhouse.aularevisao.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Praia implements Parcelable {
    private int imagem;
    private String nomePraia;

    public Praia(int imagem, String nomePraia) {
        this.imagem = imagem;
        this.nomePraia = nomePraia;
    }

    protected Praia(Parcel in) {
        imagem = in.readInt();
        nomePraia = in.readString();
    }

    public static final Creator<Praia> CREATOR = new Creator<Praia>() {
        @Override
        public Praia createFromParcel(Parcel in) {
            return new Praia(in);
        }

        @Override
        public Praia[] newArray(int size) {
            return new Praia[size];
        }
    };

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNomePraia() {
        return nomePraia;
    }

    public void setNomePraia(String nomePraia) {
        this.nomePraia = nomePraia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nomePraia);
    }
}
