package br.com.acme.infrastructure.persistance.hibernate.listener;

import java.time.LocalDate;

import javax.persistence.PrePersist;

import br.com.acme.domain.model.multa.Multa;

public class MultaListener {
    
    @PrePersist
    protected void onCreate(Multa entity) {
      entity.setData(LocalDate.now());
    }


}
