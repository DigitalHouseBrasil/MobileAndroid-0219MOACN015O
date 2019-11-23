package br.com.digitalhouse.objetos;

public class Pessoa {

    //Atributo do tipo Animal
    private Animal animalDomestico;

    //Get
    public Animal getAnimalDomestico(){
        return this.animalDomestico;
    }

    //Set
    public void setAnimalDomestico(Animal novoAnimal){
        this.animalDomestico = novoAnimal;
    }
}
