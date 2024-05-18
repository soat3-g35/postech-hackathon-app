package br.com.fiap.pos.soat3.pedido.application.infrastructure.controllers.cliente;

import br.com.fiap.pos.soat3.pedido.application.usecases.cliente.CadastraClienteInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.Cliente;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.cliente.ClienteController;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.cliente.ClienteDTOMapper;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.cliente.ClienteRequest;
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
class ClienteControllerTest {

    private MockMvc mvc;

    @Mock
    private CadastraClienteInteractor cadastraClienteUseCase;
    @Mock
    private ClienteDTOMapper clienteDTOMapper;

    @InjectMocks
    private ClienteController clienteController;
    

    private JacksonTester<ClienteRequest> jsonClienteRequest;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(clienteController)
                .build();
    }

    @Test
    void givenCategoriaRequestWhenCallShouldReturnSuccess() throws Exception {
        // given
        Cliente cliente = new Cliente("Nome", "Email", "CPF");
        given(cadastraClienteUseCase.cadastraCliente(any()))
                .willReturn(cliente);

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonClienteRequest.write(new ClienteRequest(1L, "Nome", "Email", "CPF")).getJson()
                        )).andReturn().getResponse();


        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
