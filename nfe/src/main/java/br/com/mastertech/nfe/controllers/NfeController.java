package br.com.mastertech.nfe.controllers;

import br.com.mastertech.nfe.dtos.NfeSolicitacaoRequest;
import br.com.mastertech.nfe.dtos.NfeEmissaoResponse;
import br.com.mastertech.nfe.dtos.NfeStatusResponse;
import br.com.mastertech.nfe.mappers.NfeMapper;
import br.com.mastertech.nfe.models.NfeEmissao;
import br.com.mastertech.nfe.models.Nfe;
import br.com.mastertech.nfe.producers.NfeProducer;
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
    private NfeProducer nfeProducer;

    @PostMapping("/emitir")
    @ResponseStatus(HttpStatus.CREATED)
    public NfeStatusResponse create(@RequestBody NfeSolicitacaoRequest nfeSolicitacaoRequest) {
        NfeEmissao nfeEmissao = nfeMapper.fromNfeEmissaoRequest(nfeSolicitacaoRequest);
        NfeEmissao nfeEmissaoResult = nfeService.create(nfeEmissao);

        nfeProducer.emitir(nfeEmissaoResult);

        return nfeMapper.fromNfeEmissao(nfeEmissaoResult);
    }

    @GetMapping("/consultar/{identidade}")
    public List<NfeEmissaoResponse> getAll(@PathVariable String identidade) {
        nfeProducer.consultar(identidade);
        return nfeMapper.fromNfeEmissaoList(nfeService.getAll(identidade));
    }

    @PutMapping("/efetivar/{id}")
    public NfeStatusResponse atualizar(@PathVariable Long id, @RequestBody Nfe nfe) {
        NfeEmissao nfeEmissao = nfeService.update(id, nfe);
        nfeProducer.efetivar(nfeEmissao);
        return nfeMapper.fromNfeEmissao(nfeEmissao);
    }
}
