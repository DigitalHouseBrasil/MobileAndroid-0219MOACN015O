package br.com.digitalhouse.aula10.exercicio3;

public class Alunos {
    private String nome;
    private Integer numeroDeAlunos;

    public Alunos(String nome, Integer numeroDeAlunos) {
        this.nome = nome;
        this.numeroDeAlunos = numeroDeAlunos;
    }

    @Override
    public String toString() {
        return "Nome: "+this.nome;
    }
}
