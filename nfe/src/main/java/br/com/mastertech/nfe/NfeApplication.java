package br.com.mastertech.nfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class NfeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfeApplication.class, args);
	}

}
