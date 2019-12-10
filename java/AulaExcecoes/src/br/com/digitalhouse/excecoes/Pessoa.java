package br.com.digitalhouse.excecoes;

public class Pessoa {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Método que lança uma exceção do tipo checked ou seja quem for usar o método deve tratar a exceção
    public void mostrarNome() throws Exception{
        System.out.println(getNome());
    }
}
