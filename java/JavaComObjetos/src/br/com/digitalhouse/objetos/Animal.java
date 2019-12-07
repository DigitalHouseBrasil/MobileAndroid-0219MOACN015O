package br.com.digitalhouse.objetos;

public abstract class Animal implements Saudavel, Informacoes {

    //Atributos
    private int idadeAnimal;
    private String nomeAnimal;
    private boolean patasAnimal;

    //Construtor padrão
    public Animal() {
        //Sempre que um objeto for criado a partir da utlização desse contrutor padrão receberá p valor de
        // 30 na idade e irá printar a frase que está no System
        idadeAnimal = 30;
        System.out.println("A idade do animal é " + idadeAnimal);
    }

    //Construtor especifico
    public Animal(int novaIdade) {
        this.idadeAnimal = novaIdade;
    }

    //Contrutor especifico
    public Animal(int idade, String nome) {
        this.idadeAnimal = idade;
        this.nomeAnimal = nome;
    }

    //Contrutor especifico
    public Animal(int idade, String nome, boolean patas) {
        this.idadeAnimal = idade;
        this.nomeAnimal = nome;
        this.patasAnimal = patas;
    }

    //Getters
    public int getIdadeAnimal() {
        return this.idadeAnimal;
    }

    public String getNomeAnimal() {
        return this.nomeAnimal;
    }

    public boolean getPatasAnimal() {
        return this.patasAnimal;
    }

    //Setters
    public void setIdadeAnimal(int idade) {
        this.idadeAnimal = idade;
    }

    public void setNomeAnimal(String nome) {
        this.nomeAnimal = nome;
    }

    public void setPatasAnimal(boolean patas) {
        this.patasAnimal = patas;
    }

    //Método que diz se o animal está brincando ou não
    public void estaBrincando(boolean estaBrincando) {
        System.out.println("O animal está brincando?" + estaBrincando);
    }

    public abstract int idadeDoAnimalFofo(int idade);


}
