package br.com.digitalhouse.aula10.exercicio1;

import java.util.Objects;

public class Principal {

    public static void main(String[] args) {

        Pessoa joao = new Pessoa("Jess", 18, 000001);
        Pessoa jess = new Pessoa("Jess", 18, 000001);

        String nome1 = "jess";
        String nome2 = "jess";

        if (nome1.equals(nome2)){
            System.out.println("Objetos iguais");
        }else{
            System.out.println("Objetos diferentes");

            Objects.equals(nome1, nome2);
        }

        System.out.println(joao.toString());

    }

}
