package br.com.acme.domain.shared;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Aviso extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Column(name="descricao_aviso")
    private String descricao;

}
