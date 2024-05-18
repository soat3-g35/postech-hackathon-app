package br.com.fiap.pos.soat3.pedido.infrastructure.integration;

import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UpdatePagamentoStatusConsumer {

    private final Logger log = LoggerFactory.getLogger(UpdatePagamentoStatusConsumer.class);

    @Value("${aws.queueName}")
    private String queueName;

    private final AmazonSQS amazonSQSClient;

    private final ObjectMapper objectMapper;

    private final AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase;


    public UpdatePagamentoStatusConsumer(AmazonSQS amazonSQSClient, ObjectMapper objectMapper, AtualizaStatusPedidoInteractor atualizaStatusPedidoUseCase) {
        this.amazonSQSClient = amazonSQSClient;
        this.objectMapper = objectMapper;
        this.atualizaStatusPedidoUseCase = atualizaStatusPedidoUseCase;
    }

    @Scheduled(fixedDelay = 5000) // It runs every 5 seconds.
    public void consumeMessages() {
        try {
            String queueUrl = amazonSQSClient.getQueueUrl(queueName).getQueueUrl();

            ReceiveMessageResult receiveMessageResult = amazonSQSClient.receiveMessage(queueUrl);

            if (!receiveMessageResult.getMessages().isEmpty()) {
                com.amazonaws.services.sqs.model.Message message = receiveMessageResult.getMessages().get(0);
                log.info("Read Message from queue: {}", message.getBody());
                PagamentoStatusMessage statusMessage = objectMapper.readValue(message.getBody(), PagamentoStatusMessage.class);
                atualizaStatusPedidoUseCase.atualizaStatusPedido(Long.parseLong(statusMessage.getPedidoId()), statusMessage.getStatus());
                amazonSQSClient.deleteMessage(queueUrl, message.getReceiptHandle());
            }

        } catch (Exception e) {
            log.error("Queue Exception Message: {}", e.getMessage());
        }
    }
}
