package br.com.digitalhouse.voador;

public class Aviao implements Voador {

    private double horas;

    public Aviao(double horas){
        this.horas = horas;
    }

    @Override
    public void voar() {
        double horasAtualizada = this.horas + 13;
        System.out.println("Estou voando como um avião! Horas: "+horasAtualizada);
    }
}
