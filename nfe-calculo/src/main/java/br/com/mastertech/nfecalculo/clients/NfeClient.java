package br.com.mastertech.nfecalculo.clients;

import br.com.mastertech.nfecalculo.dtos.NfeCalculo;
import br.com.mastertech.nfecalculo.security.OAuth2FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "nfe", configuration = OAuth2FeignConfiguration.class)
public interface NfeClient {

    @PutMapping("/efetivar/{id}")
    void updateById(@PathVariable Long id, @RequestBody NfeCalculo nfeCalculo);
}
