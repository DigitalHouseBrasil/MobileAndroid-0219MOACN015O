package br.com.digitalhouse.objetos;

public class Principal {

    public static void main(String[] args){

        //Criação dos objetos utilizando os contrutores declarados na classe Animal
        Animal animalMamifero = new Animal(20);
        Animal animalDomestico = new Animal();
        Animal animalSelvagem = new Animal(23, "Bidu");
        Animal animal = new Animal(23, "Teste", true);

        //Modificação do valor da idade do animal para 100
        animalDomestico.setIdadeAnimal(100);

        //Print da idade do animal a partir do método get
        System.out.println("Animal domestico "+ animalDomestico.getIdadeAnimal());

        //Utilização do método estaBrincando
        animalSelvagem.estaBrincando(true);
        animal.estaBrincando(false);

        //Criação do objeto
        Animal cachorroBidu = new Animal();
        //Alteração do valor do nome do objeto cachorroBidu para Bidu Santos
        cachorroBidu.setNomeAnimal("Bidu Santos");

        //Criação do objeto do tipo pessoa
        Pessoa joao = new Pessoa();

        //Atribuindo o cachorroBidu para o objeto João
        joao.setAnimalDomestico(cachorroBidu);

        //Mostrando o nome do cachorro a partir do objeto joao
        System.out.println(joao.getAnimalDomestico().getNomeAnimal());


    }
}
