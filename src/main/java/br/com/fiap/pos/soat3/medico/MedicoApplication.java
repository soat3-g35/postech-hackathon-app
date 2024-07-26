package br.com.fiap.pos.soat3.medico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class MedicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicoApplication.class, args);
    }

}
