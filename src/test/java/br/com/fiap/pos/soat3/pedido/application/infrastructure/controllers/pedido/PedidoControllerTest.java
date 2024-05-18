package br.com.fiap.pos.soat3.pedido.application.infrastructure.controllers.pedido;


import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.*;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.StatusPedido;
import br.com.fiap.pos.soat3.pedido.infrastructure.controllers.pedido.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PedidoControllerTest {
    @Mock
    private ListaPedidosInteractor listaPedidosUseCase;

    @Mock
    private ListaPedidosProducaoInteractor listaPedidosProducaoUseCase;

    @Mock
    private AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase;

    @Mock
    private ConsultaStatusPedidoInteractor consultaStatusPedidoUseCase;

    @Mock
    private CadastraPedidoInteractor cadastraPedidoUseCase;

    @Mock
    private PedidoDTOMapper pedidoDTOMapper;

    @InjectMocks
    PedidoController pedidoController;

    @Test
    public void testListaPedidosProducao() {
        List<Pedido> pedidos = Collections.emptyList();
        List<PedidoResponse> pedidoResponses = Collections.emptyList();
        when(listaPedidosProducaoUseCase.listaPedidosProducao()).thenReturn(pedidos);
        when(pedidoDTOMapper.toPedidoResponseList(pedidos)).thenReturn(pedidoResponses);

        ResponseEntity<List<PedidoResponse>> response = pedidoController.listaPedidosProducao();

        assertEquals("", HttpStatus.OK, response.getStatusCode());
        assertEquals("", pedidoResponses, response.getBody());
    }

    @Test
    public void givenPedidoController_testListaPedidos() {
        List<Pedido> pedidos = Collections.emptyList();
        List<PedidoResponse> pedidoResponses = Collections.emptyList();
        when(listaPedidosUseCase.listaPedidos()).thenReturn(pedidos);
        when(pedidoDTOMapper.toPedidoResponseList(pedidos)).thenReturn(pedidoResponses);

        ResponseEntity<List<PedidoResponse>> response = pedidoController.listaPedidos();

        // Assert
        assertEquals("", HttpStatus.OK, response.getStatusCode());
        assertEquals("", pedidoResponses, response.getBody());
    }

    @Test
    public void givenPedidoController_testConsultaStatusPedido() {
        Long pedidoId = 1L;
        StatusPedidoResponse statusPedidoResponse = new StatusPedidoResponse(
                "Gerado"
        );
        when(consultaStatusPedidoUseCase.consultaStatusPedido(pedidoId)).thenReturn(
                StatusPedido.GERADO.getStatus()
        );
        when(pedidoDTOMapper.toStatusPedidoResponse(StatusPedido.GERADO.getStatus())).thenReturn(statusPedidoResponse);

        ResponseEntity<StatusPedidoResponse> response = pedidoController.consultaStatusPedido(pedidoId);

        assertEquals("", HttpStatus.OK, response.getStatusCode());
        assertEquals("", statusPedidoResponse, response.getBody());
    }

    @Test
    public void givenPedidoController_testAtualizaStatusPedido() {
        Long pedidoId = 1L;
        String status = "novo status";
        Pedido pedido = new Pedido();
        PedidoResponse pedidoResponse = new PedidoResponse(
              pedidoId,
              20l,
              new ArrayList<>(),
              "20",
              StatusPedido.GERADO
        );
        when(atualizaStatusPedidoUseCase.atualizaStatusPedido(pedidoId, status)).thenReturn(pedido);
        when(pedidoDTOMapper.toPedidoResponse(pedido)).thenReturn(pedidoResponse);

        ResponseEntity<PedidoResponse> response = pedidoController.atualizaStatusPedido(pedidoId, status);

        assertEquals("", HttpStatus.OK, response.getStatusCode());
        assertEquals("", pedidoResponse, response.getBody());
    }

    @Test
    public void givenPedidoController_testCadastraPedido() {
        PedidoRequest pedidoRequest = new PedidoRequest(
                20l,
                new ArrayList<>()
        );

        Pedido pedido = new Pedido();
        PedidoResponse pedidoResponse =  new PedidoResponse(
                1l,
                20l,
                new ArrayList<>(),
                "20",
                StatusPedido.GERADO
        );
        when(pedidoDTOMapper.toPedido(pedidoRequest)).thenReturn(pedido);
        when(cadastraPedidoUseCase.cadastraPedido(pedido)).thenReturn(pedido);
        when(pedidoDTOMapper.toPedidoResponse(pedido)).thenReturn(pedidoResponse);

        ResponseEntity<PedidoResponse> response = pedidoController.cadastraPedido(pedidoRequest);

        assertEquals("", HttpStatus.OK, response.getStatusCode());
        assertEquals("", pedidoResponse, response.getBody());
    }
}
