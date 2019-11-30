package br.com.digitalhouse.objetos;

import java.util.Scanner;

public class MasterPrincipal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nomeRecebido = scanner.next();

        System.out.println("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("O nome recebido é: "+nomeRecebido+ "e sua idade é: "+idade);


    }

}
