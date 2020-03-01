package br.com.acme.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acme.domain.model.condominio.Condominio;
import br.com.acme.domain.service.BaseService;
import br.com.acme.infrastructure.persistance.hibernate.repository.BaseRepository;
import br.com.acme.infrastructure.persistance.hibernate.repository.CondominioRepository;

@Service
public class CondominioServiceImpl extends BaseServiceImpl<Condominio> implements BaseService<Condominio> {

    @Autowired
    private CondominioRepository repository;

    @Override
    protected BaseRepository<Condominio> getRepository() {
        return repository;
    }

}
