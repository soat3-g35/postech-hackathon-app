package br.com.fiap.pos.soat3.lanchonete;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.ProdutoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@EnableFeignClients
class LanchoneteApplicationTests {

	@Autowired
	private ProdutoController produtoController;
	@Test
	void contextLoads() {
		assertThat(produtoController).isNotNull();
	}

}
