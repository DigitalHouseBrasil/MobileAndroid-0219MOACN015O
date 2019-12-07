package br.com.digitalhouse.aula10.exercicio2;

import br.com.digitalhouse.aula10.exercicio1.Pessoa;

public class Coca {

    private Integer tamanho;
    private Double preco;

    public Coca(Integer tamanho, Double preco) {
        this.tamanho = tamanho;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Coca)) {
            return false;
        }

        Coca coca = (Coca) obj;

        return this.tamanho == coca.tamanho;
    }
}
