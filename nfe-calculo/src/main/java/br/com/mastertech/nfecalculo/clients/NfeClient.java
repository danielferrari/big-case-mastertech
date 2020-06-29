package br.com.mastertech.nfecalculo.clients;

import br.com.mastertech.nfecalculo.dtos.NfeCalculo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "nfe")
public interface NfeClient {

    @PutMapping("/atualizar/{id}")
    void updateById(@PathVariable Long id, @RequestBody NfeCalculo nfeCalculo);
}
