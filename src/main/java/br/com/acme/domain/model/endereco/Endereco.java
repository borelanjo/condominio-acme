/**
 * 
 */
package br.com.acme.domain.model.endereco;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.condominio.Condominio;
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
@Table(name = "tb_endereco")
public class Endereco extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String cidade;

    private String rua;

    private String cep;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_condominio")
    private Condominio condominioEndereco;
}
