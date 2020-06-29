package br.com.mastertech.nfecalculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NfeCalculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfeCalculoApplication.class, args);
	}

}
