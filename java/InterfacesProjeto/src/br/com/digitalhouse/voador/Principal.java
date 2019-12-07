package br.com.digitalhouse.voador;

public class Principal {

    public static void main(String[] args) {

        Pato pato = new Pato(5);
        Aviao aviao = new Aviao(10);
        SuperHomem superHomem = new SuperHomem(100);

        TorreControle torreControle = new TorreControle();

        torreControle.addVoador(pato);
        torreControle.addVoador(aviao);
        torreControle.addVoador(superHomem);

        torreControle.voemTodos();

    }
}
