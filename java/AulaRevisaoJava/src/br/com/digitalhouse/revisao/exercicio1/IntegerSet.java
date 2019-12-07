package br.com.digitalhouse.revisao.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {

    List<Integer> conjuntos = new ArrayList<>();

    public List<Integer> uniao(List<Integer> conjuntoNovo) {
        List<Integer> novoConjuntoCompleto = new ArrayList<>();

        novoConjuntoCompleto.addAll(conjuntos);
        novoConjuntoCompleto.addAll(conjuntoNovo);

        converteConjunto(novoConjuntoCompleto);
        return novoConjuntoCompleto;
    }

    public List<Integer> intercecao(List<Integer> novoConjunto) {
        List<Integer> conjuntoComNumerosIguais = new ArrayList<>();

        for (Integer numeroNovoConjunto : novoConjunto) {

            for (Integer numeroConjuntoClasse : this.conjuntos) {

                if (numeroNovoConjunto.equals(numeroConjuntoClasse)) {
                    conjuntoComNumerosIguais.add(numeroNovoConjunto);
                }
            }
        }

        converteConjunto(conjuntoComNumerosIguais);
        return conjuntoComNumerosIguais;
    }

    public List<Integer> diferenca(List<Integer> novoConjunto) {
        List<Integer> conjuntoComNumerosDiferentes = new ArrayList<>();

        for (Integer integer : novoConjunto) {



        }

        for (Integer conjunto : this.conjuntos) {

        }

        converteConjunto(conjuntoComNumerosDiferentes);
        return conjuntoComNumerosDiferentes;
    }

    public void inserir(Integer numero) {

        if (numero <= 50 && numero >= 0) {

            this.conjuntos.add(numero);
            converteConjunto(this.conjuntos);

        } else {

            System.out.println("Numero não permitido!");
        }
    }

    public void remover(Integer numero) {
        this.conjuntos.remove(numero);
        converteConjunto(this.conjuntos);
    }

    public void converteConjunto(List<Integer> novoConjunto) {

        for (Integer numeroNovoConjunto : novoConjunto) {

            String numero = Integer.toString(numeroNovoConjunto);
            System.out.println(numero);
        }
    }
}
