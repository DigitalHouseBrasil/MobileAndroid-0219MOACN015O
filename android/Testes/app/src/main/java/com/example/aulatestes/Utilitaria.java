package com.example.aulatestes;

public class Utilitaria {

    public static boolean validaEmailSenhaJess(String email, String senha){
        String emailJess = "jess@gmail.com";
        String senhaJess = "123456";

        if (email.equals(emailJess) && senha.equals(senhaJess)){
            return true;
        }else{
            return false;
        }
    }
}
