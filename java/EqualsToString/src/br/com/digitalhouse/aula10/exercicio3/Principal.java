package br.com.digitalhouse.aula10.exercicio3;


import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Alunos aluno1 = new Alunos("José", 01);
        Alunos aluno2 = new Alunos("Maria", 02);
        Alunos aluno3 = new Alunos("Jess", 03);
        Alunos aluno4 = new Alunos("João", 04);

        List<Alunos> listaAlunos = new ArrayList<>();
        listaAlunos.add(aluno1);
        listaAlunos.add(aluno2);
        listaAlunos.add(aluno3);


        if (listaAlunos.contains(aluno4)) {
            System.out.println(aluno4);
        } else {
            System.out.println("Não está na lista " + aluno4);
        }

    }
}
