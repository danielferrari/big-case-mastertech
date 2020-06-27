package br.com.mastertech.nfe.repositories;

import br.com.mastertech.nfe.models.Nfe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NfeOperacaoRepository extends CrudRepository<Nfe, Long> {
}
