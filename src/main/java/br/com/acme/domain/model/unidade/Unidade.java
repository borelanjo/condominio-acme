/**
 * 
 */
package br.com.acme.domain.model.unidade;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.acme.domain.model.condominio.Condominio;
import br.com.acme.domain.model.multa.Multa;
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
@Table(name = "t_unidade")
public class Unidade extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_condominio")
    private Condominio condominio;

    private String numeroUnidade;

    private String blocoUnidade;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidade")
    private Set<Multa> multas;

}
