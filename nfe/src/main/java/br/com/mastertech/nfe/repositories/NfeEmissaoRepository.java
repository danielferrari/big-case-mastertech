package br.com.mastertech.nfe.repositories;

import br.com.mastertech.nfe.models.NfeEmissao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NfeEmissaoRepository extends CrudRepository<NfeEmissao, Long> {
    List<NfeEmissao> findAllByIdentidade(String identidade);
}
