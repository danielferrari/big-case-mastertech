package br.com.mastertech.nfe.producers;

import br.com.mastertech.nfe.models.Nfe;
import br.com.mastertech.nfe.models.NfeEmissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NfeProducer {

    @Autowired
    private KafkaTemplate<String, Object> producer;

    public void emitir(NfeEmissao nfeEmissao) {
        producer.send("spec2-daniel-victor-1", nfeEmissao);
    }

    public void consultar(String identidade) {
        producer.send("spec2-daniel-victor-2", identidade);
    }

    public void efetivar(NfeEmissao nfeEmissao) {
        producer.send("spec2-daniel-victor-3", nfeEmissao);
    }
}
