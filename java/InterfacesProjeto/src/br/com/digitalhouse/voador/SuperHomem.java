package br.com.digitalhouse.voador;

public class SuperHomem implements Voador {

    private int experiencia;

    public SuperHomem(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public void voar() {
        int experienciaAtualizada = this.experiencia + 3;
        System.out.println("Estou voando como um campeão! Experiência: "+experienciaAtualizada);
    }

}