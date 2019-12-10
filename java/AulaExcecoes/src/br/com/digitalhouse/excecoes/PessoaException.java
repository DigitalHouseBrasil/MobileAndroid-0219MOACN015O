package br.com.digitalhouse.excecoes;

//Classe criada que herda de uma classe unchecked
public class PessoaException extends RuntimeException {


  public PessoaException(){
      super();
  }

  public PessoaException(String mensagem){
      super(mensagem);
  }

  public void testeException(){
      super.getCause();
  }

  public void testarNumeros(int n1, int n2){
      System.out.println("verificado com sucesso!");
  }

}
