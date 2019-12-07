package br.com.digitalhouse.aula10.exercicio1;

import java.util.Objects;

public class Pessoa {

    private String nome;
    private int idade;
    private int rg;
    private String sobrenome;

    public Pessoa(String nome, int idade, int rg) {
        this.nome = nome;
        this.idade = idade;
        this.rg = rg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade &&
                rg == pessoa.rg &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(sobrenome, pessoa.sobrenome);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", rg=" + rg +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }
}
