package br.com.digitalhouse.aula10.exercicio4;

import java.util.Objects;

public class Funcionario {
    private String nome;
    private Integer numeroRegistro;

    public Funcionario(String nome, Integer numeroRegistro) {
        this.nome = nome;
        this.numeroRegistro = numeroRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return  Objects.equals(numeroRegistro, that.numeroRegistro);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", numeroRegistro=" + numeroRegistro +
                '}';
    }
}
