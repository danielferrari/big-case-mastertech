package br.com.mastertech.nfelogger.consumers;

import br.com.mastertech.nfe.models.NfeEmissao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class NfeLoggerConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger("analytics");

    @KafkaListener(topics = { "spec2-daniel-victor-1" }, groupId = "nfe-logger")
    public void getNfeEmissao(@Payload NfeEmissao nfeEmissao) {
        LOGGER.info("[EMISSÃO] {} acaba de realizar a emissão de uma NF no valor de {}",
                nfeEmissao.getIdentidade(),
                nfeEmissao.getValor());
    }

    @KafkaListener(topics = { "spec2-daniel-victor-2" }, groupId = "nfe-logger")
    public void getNfeConsulta(
            @Payload String identidade) {
        LOGGER.info("[CONSULTA] {} acaba de consultar os dados de suas notas fiscais", identidade);
    }

    @KafkaListener(topics = { "spec2-daniel-victor-3" }, groupId = "nfe-logger")
    public void getNfeEfetivacao( @Payload NfeEmissao nfeEmissao) {
        LOGGER.info(
                "[EFETIVAÇÃO] A nota fiscal de número {} foi efetivada com o valor final de {} após o cálculo de impostos",
                nfeEmissao.getId(),
                nfeEmissao.getNfe().getValorFinal());
    }
}
