package br.com.mastertech.nfe.services;

import br.com.mastertech.nfe.exceptions.InvalidIdentityException;
import br.com.mastertech.nfe.exceptions.NfeNotFoundException;
import br.com.mastertech.nfe.helpers.ValidaIdentidadeHelper;
import br.com.mastertech.nfe.models.NfeEmissao;
import br.com.mastertech.nfe.models.Nfe;
import br.com.mastertech.nfe.producers.NfeEmissaoProducer;
import br.com.mastertech.nfe.repositories.NfeEmissaoRepository;
import br.com.mastertech.nfe.repositories.NfeOperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NfeService {
    @Autowired
    private NfeEmissaoRepository nfeEmissaoRepository;

    @Autowired
    private NfeOperacaoRepository nfeOperacaoRepository;

    @Autowired
    private NfeEmissaoProducer nfeEmissaoProducer;

    public NfeEmissao create(NfeEmissao nfeEmissao) {
        if (!ValidaIdentidadeHelper.isValid(nfeEmissao.getIdentidade())) {
            throw new InvalidIdentityException();
        }

        nfeEmissao.setStatus("pending");

        return nfeEmissaoRepository.save(nfeEmissao);
    }

    public void update(Long id, Nfe nfe) {
        Optional<NfeEmissao> nfeEmissaoOptional = nfeEmissaoRepository.findById(id);


        if (!nfeEmissaoOptional.isPresent()) {
            throw new NfeNotFoundException();
        }

        Nfe nfeSaved = nfeOperacaoRepository.save(nfe);

        NfeEmissao nfeEmissao = nfeEmissaoOptional.get();
        nfeEmissao.setNfe(nfeSaved);
        nfeEmissaoRepository.save(nfeEmissao);
    }

    public List<NfeEmissao> getAll(String identidade) {
        return nfeEmissaoRepository.findAllByIdentidade(identidade);
    }
}
