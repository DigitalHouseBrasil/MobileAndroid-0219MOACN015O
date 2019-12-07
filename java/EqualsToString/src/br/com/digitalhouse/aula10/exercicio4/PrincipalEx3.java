package br.com.digitalhouse.aula10.exercicio4;

import java.util.ArrayList;
import java.util.List;

public class PrincipalEx3 {
    public static void main(String[] args) {

        Funcionario fun1 = new Funcionario("Joao", 23);
        Funcionario fun2 = new Funcionario("Milena", 24);
        Funcionario fun3 = new Funcionario("Luana", 25);
        Funcionario fun4 = new Funcionario("Roberto", 26);

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(fun1);
        funcionarios.add(fun2);
        funcionarios.add(fun3);
        funcionarios.add(fun4);

        if (funcionarios.contains(fun4)){
            System.out.println(fun4);
        }else{
            System.out.println("Não contém o "+fun4);
        }
    }
}
