package br.com.mastertech.nfecalculo.services;

import br.com.mastertech.nfe.models.NfeEmissao;
import br.com.mastertech.nfecalculo.builders.NfeCalculoBuilder;
import br.com.mastertech.nfecalculo.clients.CnpjClient;
import br.com.mastertech.nfecalculo.dtos.CnpjResponseDto;
import br.com.mastertech.nfecalculo.dtos.NfeCalculo;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NfeCalculoService {
    @Autowired
    private CnpjClient cnpjClient;

    public NfeCalculo calcular(NfeEmissao nfeEmissao) {
        CnpjResponseDto cnpjResponseDto = cnpjClient.getCnpj(nfeEmissao.getIdentidade());

        if (cnpjResponseDto.getStatus().equals("ERROR")) {
            return calcularPF(nfeEmissao.getValor());
        }

        if (Double.parseDouble(cnpjResponseDto.getCapitalSocial()) > 1000000.00) {
            return calculaPJ(nfeEmissao.getValor());
        }

        return calcularPJSimplesNacional(nfeEmissao.getValor());
    }

    private NfeCalculo calcularPF(double valor) {
        return new NfeCalculoBuilder(valor).build();
    }

    private NfeCalculo calculaPJ(double valor) {
        return new NfeCalculoBuilder(valor)
                .adicionaIRRF()
                .adicionaCSLL()
                .adicionaPISCOFINS()
                .build();
    }

    private NfeCalculo calcularPJSimplesNacional(double valor) {
        return new NfeCalculoBuilder(valor)
                .adicionaIRRF()
                .build();
    }
}
