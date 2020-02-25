/**
 * 
 */
package br.com.acme.domain.model.unidade;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.multa.Multa;
import br.com.acme.domain.model.responsavel.Responsavel;
import br.com.acme.domain.shared.BaseEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosfilho
 *
 */
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "tb_unidade")
public class Unidade extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_responsavel")
    private Responsavel responsavelUnidade;

    private String numeroUnidade;

    private String blocoUnidade;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeMulta")
    private Set<Multa> multasUnidade;

}
