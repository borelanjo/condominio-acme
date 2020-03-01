package br.com.acme.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.acme.domain.model.avisounidade.AvisoUnidade;
import br.com.acme.domain.model.multa.Multa;
import br.com.acme.domain.model.unidade.Unidade;
import br.com.acme.domain.service.UnidadeService;
import br.com.acme.infrastructure.persistance.hibernate.repository.BaseRepository;
import br.com.acme.infrastructure.persistance.hibernate.repository.UnidadeRepository;

@Service
public class UnidadeServiceImpl extends BaseServiceImpl<Unidade> implements UnidadeService {

    @Autowired
    private UnidadeRepository repository;

    @Override
    protected BaseRepository<Unidade> getRepository() {
        return repository;
    }

    @Override
    public Unidade sendPenalty(Long id, Multa multa) {
        Unidade unidade = findById(id);
        multa.setUnidade(unidade);
        unidade.addMulta(multa);
        return update(id, unidade);
    }

    @Override
    public Page<Unidade> findAll(boolean hasMulta, Pageable pageable) {

        return hasMulta ? repository.findByMultasNotNull(pageable) : repository.findByMultasNull(pageable);
    }

    @Override
    public Unidade sendWarning(Long id, AvisoUnidade aviso) {
        Unidade unidade = findById(id);
        aviso.setUnidade(unidade);
        unidade.addAviso(aviso);
        return update(id, unidade);
    }

}
