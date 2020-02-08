package br.digitalhouse.comunicacaofragments.interfaces;

import br.digitalhouse.comunicacaofragments.model.SistemaOperacional;

public interface Comunicador {

    //Método usado para o envio recebendo um objeto do tipo SistemaOperacional
    void envioDadosSistemaOperacional(SistemaOperacional so);
}
