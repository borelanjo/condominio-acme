package br.com.acme.application.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.application.service.exception.InformationNotFoundException;
import br.com.acme.domain.service.BaseService;
import br.com.acme.domain.shared.BaseEntity;
import br.com.acme.infrastructure.persistance.hibernate.repository.BaseRepository;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Transactional(readOnly = true)
    @Override
    public T findById(Long id) {
        Optional<T> entityOpt = getRepository().findById(id);

        return entityOpt.orElseThrow(() -> new InformationNotFoundException());
    }

    @Transactional(readOnly = true)
    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return getRepository().findAll(specification, pageable);
    }

    @Transactional
    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Transactional
    @Override
    public T update(Long id, T entity) {
        T savedEntity = findById(id);
        BeanUtils.copyProperties(entity, savedEntity);

        return getRepository().save(savedEntity);
    }

    @Transactional
    @Override
    public void delete(Long id) {

        getRepository().deleteById(id);
    }

    protected abstract BaseRepository<T> getRepository();

}