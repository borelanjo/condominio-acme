/**
 * 
 */
package br.com.acme.domain.model.multa;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.unidade.Unidade;
import br.com.acme.domain.shared.BaseEntity;
import br.com.acme.infrastructure.persistance.hibernate.listener.MultaListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "t_multa")
@EntityListeners(MultaListener.class)
@NoArgsConstructor
public class Multa extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name="descricao_multa")
    private String descricao;

    @Column(name="data_multa")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;

    @Column(name="valor_multa")
    private BigDecimal valor;
}
