package com.example.aulatestes;

import android.app.Application;
import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class LoginActivityTest {

    private String email = "jessica@gmail.com";
    private String senha = "123456";

    @Mock
    private Utilitaria utilitaria;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        utilitaria = Mockito.mock(Utilitaria.class);
    }

    @Test
    public void testVerificaEmail() {
        assertEquals("jessica@gmail.com", email);
    }

    @Test
    public void testVerificaSenha() {
        assertEquals("123456", senha);
    }

    @Test
    public void verificaEmailSenhaJessFalse() {
        boolean resposta = utilitaria.validaEmailSenhaJess(email, senha);
        assertFalse(resposta);
    }
}