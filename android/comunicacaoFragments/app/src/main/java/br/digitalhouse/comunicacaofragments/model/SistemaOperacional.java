package br.digitalhouse.comunicacaofragments.model;

import android.os.Parcel;
import android.os.Parcelable;

//Implementação da interface Parcelable para que seja possivél ser enviado um objeto
//através do método putParcelable do bundle, pois esse método espera um Parcelable como parametro
//sendo assim é necessário a implementação na sua classe modelo para que seja possivel o envio de um objeto
public class SistemaOperacional implements Parcelable {
    private String nomeSistema;
    private int imagem;

    public SistemaOperacional(String nomeSistema, int imagem) {
        this.nomeSistema = nomeSistema;
        this.imagem = imagem;
    }

    protected SistemaOperacional(Parcel in) {
        nomeSistema = in.readString();
        imagem = in.readInt();
    }

    public static final Creator<SistemaOperacional> CREATOR = new Creator<SistemaOperacional>() {
        @Override
        public SistemaOperacional createFromParcel(Parcel in) {
            return new SistemaOperacional(in);
        }

        @Override
        public SistemaOperacional[] newArray(int size) {
            return new SistemaOperacional[size];
        }
    };

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeSistema);
        dest.writeInt(imagem);
    }
}
