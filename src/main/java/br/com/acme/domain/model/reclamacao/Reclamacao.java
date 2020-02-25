/**
 * 
 */
package br.com.acme.domain.model.reclamacao;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "tb_reclamacao")
public class Reclamacao extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String descricaoReclamacao;

    private LocalDate dataReclamacao;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Responsavel responsavelReclamacao;
}
