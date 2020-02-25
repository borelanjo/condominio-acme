/**
 * 
 */
package br.com.acme.domain.model.responsavel;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.acme.domain.model.reclamacao.Reclamacao;
import br.com.acme.domain.model.reserva.Reserva;
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
@Table(name = "tb_responsavel")
public class Responsavel extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String nome;

    private String email;

    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsavelReserva")
    private Set<Reserva> reservas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsavelReclamacao")
    private Set<Reclamacao> reclamacoes;
}
