package br.com.digitalhouse.objetos;

public class Cachorro extends Animal{


    @Override
    public void estaBrincando(boolean estaBrincando) {
        System.out.println("Estou sobrescrevendo este método");
        System.out.println("O animal se chama "+ super.getNomeAnimal());
    }

    @Override
    public int idadeDoAnimalFofo(int idade) {
        return 0;
    }
}
