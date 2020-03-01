package br.com.acme.infrastructure.persistance.hibernate.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.acme.domain.model.unidade.Unidade;

public interface UnidadeRepository extends BaseRepository<Unidade> {
    
    Page<Unidade> findByMultasNotNull(Pageable pageable);
    
    Page<Unidade> findByMultasNull(Pageable pageable);

}
