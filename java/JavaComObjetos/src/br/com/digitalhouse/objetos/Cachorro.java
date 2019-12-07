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


    @Override
    public void estaRespirando(boolean status) {

    }

    @Override
    public String possuiDoencas(boolean status) {
        return null;
    }

    @Override
    public boolean animalSaudavel(String diagnostico) {
        return false;
    }
}
