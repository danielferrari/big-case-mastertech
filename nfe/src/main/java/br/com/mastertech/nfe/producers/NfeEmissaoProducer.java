package br.com.mastertech.nfe.producers;

import br.com.mastertech.nfe.models.NfeEmissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NfeEmissaoProducer {

    @Autowired
    private KafkaTemplate<String, NfeEmissao> producer;

    public void sentToKafka(NfeEmissao nfeEmissao) {
        producer.send("spec2-daniel-victor-1", nfeEmissao);
    }
}
