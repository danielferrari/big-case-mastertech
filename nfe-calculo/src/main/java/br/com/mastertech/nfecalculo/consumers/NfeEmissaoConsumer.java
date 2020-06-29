package br.com.mastertech.nfecalculo.consumers;

import br.com.mastertech.nfe.models.NfeEmissao;
import br.com.mastertech.nfecalculo.clients.NfeClient;
import br.com.mastertech.nfecalculo.dtos.NfeCalculo;
import br.com.mastertech.nfecalculo.services.NfeCalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NfeEmissaoConsumer {
    @Autowired
    private NfeCalculoService  nfeCalculoService;

    @Autowired
    private NfeClient nfeClient;

    @KafkaListener(topics = "spec2-daniel-victor-1", groupId = "nfe-calculo")
    public void listen(@Payload NfeEmissao nfeEmissao) {
        NfeCalculo nfeCalculo = nfeCalculoService.calcular(nfeEmissao);
        nfeClient.updateById(nfeEmissao.getId(), nfeCalculo);
    }

}
