package br.com.fiap.pos.soat3.pedido.infrastructure.config.messaging;

import br.com.fiap.pos.soat3.pedido.infrastructure.integration.UpdatePagamentoStatusConsumer;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfig {

    private final Logger log = LoggerFactory.getLogger(SQSConfig.class);
    
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

        log.info("Checking keys endpoint {}, secretKey{}", endpoint);

        return AmazonSQSClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
//                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//                .withRegion(Regions.fromName(region))
                .build();
//        log.info("Checking keys accessKey {}, secretKey{}", accessKey, secretKey);        

//        return AmazonSQSAsyncClientBuilder.standard()
//                .withRegion(Regions.US_EAST_1)
//                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
//                .build();


//        AWSSecurityTokenService stsClient
//                = AWSSecurityTokenServiceClientBuilder.defaultClient();
//
//        STSAssumeRoleSessionCredentialsProvider assumedRoleCredentialsProvider
//                = new STSAssumeRoleSessionCredentialsProvider.Builder(ROLE_ARN, SESSION_ID)
//                .withStsClient(stsClient)
//                .build();

//        AmazonSQS sqsClient
//                = AmazonSQSClientBuilder.standard()
//                .withCredentials(assumedRoleCredentialsProvider)
//                .build();
    }
}
