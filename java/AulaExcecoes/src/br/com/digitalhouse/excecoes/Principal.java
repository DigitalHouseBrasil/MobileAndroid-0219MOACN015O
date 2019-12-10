package br.com.digitalhouse.excecoes;

public class Principal {

    public static void main(String[] args) {

        String nome = "Jess";

        int idade = 18;

        System.out.println("Nome: "+nome);
        System.out.println("Idade: "+idade);

        System.out.println("Divisao "+idade/2);

        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Milena");


        try {
            pessoa.mostrarNome();

            //Tratamento de exceção usando a classe PessoaException criada
        } catch (PessoaException pessoaException) {
            pessoaException.printStackTrace();
            pessoaException.testeException();
            pessoaException.testarNumeros(2,3);


            //Trantando a exceção com a Exception
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
