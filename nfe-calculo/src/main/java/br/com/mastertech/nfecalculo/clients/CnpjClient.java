package br.com.mastertech.nfecalculo.clients;

import br.com.mastertech.nfecalculo.dtos.CnpjDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cnpj", url = "https://www.receitaws.com.br/v1/cnpj")
public interface CnpjClient {

    @GetMapping("/{cnpj}")
    CnpjDto getCnpj(@PathVariable String cnpj);
}
