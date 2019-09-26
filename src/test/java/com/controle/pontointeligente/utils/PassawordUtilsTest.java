package com.controle.pontointeligente.utils;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PassawordUtilsTest {

    private final String SENHA = "123456";
    private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

    //verifico se a senha e nula
    @Test
    public void testSenhaNula() throws Exception {
        assertNull(PasswordUtils.gerarBCrypt(null));
    }

    //verifico se a senha mais o hash retorna true
    @Test
    public void testGerarHashSenha() throws Exception{
        String hash = PasswordUtils.gerarBCrypt(SENHA);
        assertTrue(bCryptEncoder.matches(SENHA, hash));
    }


}
