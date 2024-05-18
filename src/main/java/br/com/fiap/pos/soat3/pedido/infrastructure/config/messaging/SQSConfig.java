package br.com.fiap.pos.soat3.pedido.infrastructure.config.messaging;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfig {
    
    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("${aws.accessKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.endpoint}")
    private String endpoint;
    
    @Bean
    public AmazonSQS amazonSQSClient() {
//        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        return AmazonSQSClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
//                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//                .withRegion(Regions.fromName(region))
                .build();
    }
}
