/**
 * 
 */
package br.com.acme.domain.model.condominio;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.acme.domain.model.avisocondominio.AvisoCondominio;
import br.com.acme.domain.model.unidade.Unidade;
import br.com.acme.domain.shared.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "t_condominio")
public class Condominio extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String nome;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "condominio")
    private Set<Unidade> unidades;

    @OneToMany(mappedBy = "condominio")
    private Set<AvisoCondominio> avisos;

}
