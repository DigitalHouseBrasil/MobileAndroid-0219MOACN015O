package br.com.digitalhouse.revisao.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {


        IntegerSet conjunto = new IntegerSet();

        List<Integer> conjuntoNovo = new ArrayList<>();

        conjuntoNovo.add(1);
        conjuntoNovo.add(45);
        conjuntoNovo.add(0);
        conjuntoNovo.add(2);

        conjunto.inserir(24);
        conjunto.inserir(4);
        conjunto.inserir(45);
        conjunto.inserir(1);

        System.out.println("UNIAO------");
        conjunto.uniao(conjuntoNovo);

        System.out.println("DIFERNEÇA------");
        conjunto.diferenca(conjuntoNovo);

        System.out.println("INTERCEÇÃO ------");
        conjunto.intercecao(conjuntoNovo);

        System.out.println("REMOÇÃO------");
        conjunto.remover(1);


    }
}
