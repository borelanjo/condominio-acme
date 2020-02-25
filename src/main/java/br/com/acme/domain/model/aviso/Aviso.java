/**
 * 
 */
package br.com.acme.domain.model.aviso;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.condominio.Condominio;
import br.com.acme.domain.shared.BaseEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "tb_avisos")
public class Aviso extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String descricaoAviso;

    @ManyToOne
    @JoinColumn(name = "id_condominio")
    private Condominio condominoAvisos;
}
