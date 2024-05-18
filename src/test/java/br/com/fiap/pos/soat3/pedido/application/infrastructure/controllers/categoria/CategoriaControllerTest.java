package br.com.fiap.pos.soat3.pedido.application.infrastructure.controllers.categoria;

import br.com.fiap.pos.soat3.pedido.application.usecases.categoria.CadastraCategoriaInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.categoria.CategoriaController;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.categoria.CategoriaDTOMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.categoria.CategoriaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
class CategoriaControllerTest {

    private MockMvc mvc;
    
    @Mock
    private CadastraCategoriaInteractor cadastraCategoriaUseCase;
    @Mock
    private CategoriaDTOMapper categoriaDTOMapper;

    @InjectMocks
    private CategoriaController categoriaController;

    private JacksonTester<CategoriaRequest> jsonCategoriaRequest;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(categoriaController)
                .build();
    }

    @Test
    void givenCategoriaRequestWhenCallShouldReturnSuccess() throws Exception {
        // given
        Categoria categoria = new Categoria(1L, "Nova Categoria");
        given(cadastraCategoriaUseCase.cadastraCategoria(any()))
                .willReturn(categoria);

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonCategoriaRequest.write(new CategoriaRequest("Nova Categoria")).getJson()
                        )).andReturn().getResponse();


        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
