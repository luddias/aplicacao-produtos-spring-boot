package br.ifes.dw.helloworld.repository;

import br.ifes.dw.helloworld.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface DBRepository extends GenericRepositoryBD<Produto, Long> {
}