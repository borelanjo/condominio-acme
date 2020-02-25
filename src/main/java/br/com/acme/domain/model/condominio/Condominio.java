/**
 * 
 */
package br.com.acme.domain.model.condominio;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.acme.domain.model.aviso.Aviso;
import br.com.acme.domain.model.multa.Multa;
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
@Table(name = "tb_condominio")
public class Condominio extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String nome;

    private String email;

    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condominoMulta")
    private Set<Multa> multasAplicadas;

    @OneToMany
    private Set<Aviso> avisos;

}
