package br.com.fiap.pos.soat3.pedido.application.infrastructure.infrastructure.integration;


import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;
import br.com.fiap.pos.soat3.pedido.infrastructure.integration.PagamentoStatusMessage;
import br.com.fiap.pos.soat3.pedido.infrastructure.integration.UpdatePagamentoStatusConsumer;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.postgresql.hostchooser.HostRequirement.any;

@ExtendWith(MockitoExtension.class)
public class UpdatePagamentoStatusConsumerTest {

    @Mock
    private AmazonSQS amazonSQSClient;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase;
    
    @InjectMocks
    private UpdatePagamentoStatusConsumer consumer;

    @Test
    void consumeMessages_shouldUpdatePagamentoStatusSuccessful() throws JsonProcessingException {
        GetQueueUrlResult queue = new GetQueueUrlResult();
        queue.setQueueUrl("www.google.com");
        when(amazonSQSClient.getQueueUrl(anyString())).thenReturn(queue);
        when(amazonSQSClient.receiveMessage(anyString())).thenReturn(new ReceiveMessageResult());
        when(objectMapper.readValue("", PagamentoStatusMessage.class)).thenReturn(new PagamentoStatusMessage(
                "1", "status"
        ));
        when(atualizaStatusPedidoUseCase.atualizaStatusPedido(1l, "status")). thenReturn(
                new Pedido()
        );
        when(amazonSQSClient.deleteMessage(anyString(), anyString())).thenReturn(new DeleteMessageResult());

        consumer.consumeMessages();
    }
}
