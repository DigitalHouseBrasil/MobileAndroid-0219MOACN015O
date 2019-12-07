package br.com.digitalhouse.aula10.exercicio2;

public class PrincipalEx2 {
    public static void main(String[] args) {

        Coca fanta = new Coca(2, 4.50);
        Coca pesi = new Coca(2, 4.50);

        if (fanta.equals(pesi)){
            System.out.println("São iguais");
        }else{
            System.out.println("São diferentes");
        }
    }
}