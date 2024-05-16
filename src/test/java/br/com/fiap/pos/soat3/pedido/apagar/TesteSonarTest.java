package br.com.fiap.pos.soat3.pedido.apagar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TesteSonarTest {

    @Autowired
    TesteSonar teste;
    @Test
    void contextLoads() {
        var inteiro = teste.retornaInteiro();
        Assertions.assertEquals(inteiro,1);

        var inteiro2 = teste.retornaSegundoInteiro();
        Assertions.assertEquals(inteiro2,2);
    }
}
