package br.com.digitalhouse.voador;

public class Pato implements Voador {

    private int energia;

    public Pato(int energia) {
        this.energia = energia;
    }

    @Override
    public void voar() {
        int energiaAtualizada = this.energia - 5;
        System.out.println("Estou voando como um pato! Energia: "+ energiaAtualizada);
    }
}
