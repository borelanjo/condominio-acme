package br.com.acme.domain.shared;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Aviso extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Column(name="descricao_aviso")
    private String descricao;

}
