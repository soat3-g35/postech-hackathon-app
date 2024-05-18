package br.com.fiap.pos.soat3.pedido.application.infrastructure.infrastructure.integration;

import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.pedido.infrastructure.integration.PagamentoStatusMessage;
import br.com.fiap.pos.soat3.pedido.infrastructure.integration.UpdatePagamentoStatusConsumer;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

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

    @Captor
    private ArgumentCaptor<Long> pedidoIdCaptor;

    @Captor
    private ArgumentCaptor<String> statusCaptor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(consumer, "queueName", "test-queue");
    }

    @Disabled
    @Test
    public void givenMessageInQueue_whenConsumeMessages_thenProcessMessage() throws Exception {
        // Arrange
        GetQueueUrlResult queue = new GetQueueUrlResult();
        String queueUrl = "test-queue-url";
        queue.setQueueUrl(queueUrl);
        String messageBody = "{\"pedidoId\": \"123\", \"status\": \"CONFIRMADO\"}";
        Message message = new Message();
        message.setBody(messageBody);
        message.setReceiptHandle("receipt-handle");

        ReceiveMessageResult receiveMessageResult = new ReceiveMessageResult();
        receiveMessageResult.setMessages(Collections.singletonList(message));

        PagamentoStatusMessage statusMessage = new PagamentoStatusMessage("123", "CONFIRMADO");
        statusMessage.setPedidoId("123");
        statusMessage.setStatus("CONFIRMADO");

        when(amazonSQSClient.getQueueUrl("test-queue")).thenReturn(queue);
        when(amazonSQSClient.receiveMessage(queueUrl)).thenReturn(receiveMessageResult);
        when(objectMapper.readValue(messageBody, PagamentoStatusMessage.class)).thenReturn(statusMessage);

        // Act
        consumer.consumeMessages();

        // Assert
        verify(atualizaStatusPedidoUseCase).atualizaStatusPedido(pedidoIdCaptor.capture(), statusCaptor.capture());
        verify(amazonSQSClient).deleteMessage(queueUrl, "receipt-handle");

        assertEquals("", 123L, pedidoIdCaptor.getValue());
        assertEquals("", "CONFIRMADO", statusCaptor.getValue());
    }

    @Test
    public void givenEmptyQueue_whenConsumeMessages_thenDoNothing() {
        // Arrange
        GetQueueUrlResult queue = new GetQueueUrlResult();
        String queueUrl = "test-queue-url";
        queue.setQueueUrl(queueUrl);
        ReceiveMessageResult receiveMessageResult = new ReceiveMessageResult();
        receiveMessageResult.setMessages(Collections.emptyList());

        // Act
        consumer.consumeMessages();

        // Assert
        verify(atualizaStatusPedidoUseCase, never()).atualizaStatusPedido(anyLong(), anyString());
        verify(amazonSQSClient, never()).deleteMessage(anyString(), anyString());
    }

    @Test
    public void givenException_whenConsumeMessages_thenLogError() throws Exception {
        // Arrange
        GetQueueUrlResult queue = new GetQueueUrlResult();
        String queueUrl = "test-queue-url";
        queue.setQueueUrl(queueUrl);
        String messageBody = "{\"pedidoId\": \"123\", \"status\": \"CONFIRMADO\"}";
        Message message = new Message();
        message.setBody(messageBody);
        message.setReceiptHandle("receipt-handle");

        ReceiveMessageResult receiveMessageResult = new ReceiveMessageResult();
        receiveMessageResult.setMessages(Collections.singletonList(message));

        // Act
        consumer.consumeMessages();

        // Assert
        verify(atualizaStatusPedidoUseCase, never()).atualizaStatusPedido(anyLong(), anyString());
        verify(amazonSQSClient, never()).deleteMessage(anyString(), anyString());
    }
}