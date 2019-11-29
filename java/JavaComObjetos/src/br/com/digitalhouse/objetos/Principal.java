package br.com.digitalhouse.objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Principal {

    public static void main(String[] args){

        //Criação dos objetos utilizando os contrutores declarados na classe Animal
        Animal animalMamifero = new Cachorro();
        Animal animalDomestico = new Cachorro();
        Animal animalSelvagem = new Golden();
        Animal animal = new Golden();

        Cachorro cachorro = new Cachorro();

        animalMamifero.getIdadeAnimal();
        cachorro.getIdadeAnimal();

        //Modificação do valor da idade do animal para 100
        animalDomestico.setIdadeAnimal(100);

        //Print da idade do animal a partir do método get
        System.out.println("Animal domestico "+ animalDomestico.getIdadeAnimal());

        //Utilização do método estaBrincando
        animalSelvagem.estaBrincando(true);
        animal.estaBrincando(false);

        //Criação do objeto
        Animal cachorroBidu = new Cachorro();
        //Alteração do valor do nome do objeto cachorroBidu para Bidu Santos
        try {
            cachorroBidu.setNomeAnimal("Bidu Santos"+new SimpleDateFormat( "yyyyMMdd" ).parse( "20100520" )
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Criação do objeto do tipo pessoa
        Pessoa joao = new Pessoa();

        //Atribuindo o cachorroBidu para o objeto João
        joao.setAnimalDomestico(cachorroBidu);

        //Mostrando o nome do cachorro a partir do objeto joao
        System.out.println(joao.getAnimalDomestico().getNomeAnimal());

        Cachorro cachorrinho = new Cachorro();

        cachorrinho.estaBrincando(true);
    }
}
