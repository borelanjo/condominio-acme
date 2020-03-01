package br.com.acme.domain.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.acme.domain.model.avisounidade.AvisoUnidade;
import br.com.acme.domain.model.multa.Multa;
import br.com.acme.domain.model.unidade.Unidade;

public interface UnidadeService extends BaseService<Unidade> {
    
    public Unidade sendPenalty(Long id, Multa multa);
    
    public Unidade sendWarning(Long id, AvisoUnidade aviso);
    
    public Page<Unidade> findAll(boolean hasMulta, Pageable pageable);

}
