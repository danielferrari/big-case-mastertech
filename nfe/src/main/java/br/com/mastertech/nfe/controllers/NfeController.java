package br.com.mastertech.nfe.controllers;

import br.com.mastertech.nfe.dtos.NfeSolicitacaoRequest;
import br.com.mastertech.nfe.dtos.NfeEmissaoResponse;
import br.com.mastertech.nfe.dtos.NfeStatusResponse;
import br.com.mastertech.nfe.mappers.NfeMapper;
import br.com.mastertech.nfe.models.NfeEmissao;
import br.com.mastertech.nfe.models.Nfe;
import br.com.mastertech.nfe.producers.NfeEmissaoProducer;
import br.com.mastertech.nfe.services.NfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NfeController {
    @Autowired
    private NfeService nfeService;

    @Autowired
    private NfeMapper nfeMapper;

    @Autowired
    private NfeEmissaoProducer nfeEmissaoProducer;

    @PostMapping("/emitir")
    @ResponseStatus(HttpStatus.CREATED)
    public NfeStatusResponse create(@RequestBody NfeSolicitacaoRequest nfeSolicitacaoRequest) {
        NfeEmissao nfeEmissao = nfeMapper.fromNfeEmissaoRequest(nfeSolicitacaoRequest);
        NfeEmissao nfeEmissaoResult = nfeService.create(nfeEmissao);

        nfeEmissaoProducer.sentToKafka(nfeEmissaoResult);

        return nfeMapper.fromNfeEmissao(nfeEmissaoResult);
    }

    @GetMapping("/consultar/{identidade}")
    public List<NfeEmissaoResponse> getAll(@PathVariable String identidade) {
        return nfeMapper.fromNfeEmissaoList(nfeService.getAll(identidade));
    }

    @PutMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody Nfe nfe) {
        nfeService.update(id, nfe);
    }
}
