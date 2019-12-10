package br.com.digitalhouse.excecoes;

import java.util.ArrayList;
import java.util.List;

public class Principal2 {

    public static void main(String[] args) {


        //Bloco try - tudo que estiver dentro do try ele irá tentar fazer
        try{

            List<String> nomes = new ArrayList<>();
            nomes.add("Jess");
            nomes.add("Milena");
            nomes.add("Karol");

            System.out.println(nomes.get(3));

            //Bloco catch - o catch irá capturar a exceção e trata-la
            //Tratando a exceção
        }catch (Exception ex){
            System.out.println(ex.getMessage());

            //Tudo que estiver no finally irá ser executado independente de ter lançado exceção ou não
        }finally {
            System.out.println("Estou no bloco finally");
        }

    }
}
