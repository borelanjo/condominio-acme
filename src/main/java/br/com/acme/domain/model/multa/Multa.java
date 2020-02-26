/**
 * 
 */
package br.com.acme.domain.model.multa;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.unidade.Unidade;
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
@Table(name = "t_multa")
public class Multa extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name="descricao_multa")
    private String descricao;

    @Column(name="data_multa")
    private LocalDate dataMulta;

    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;

    @Column(name="valor_multa")
    private BigDecimal valor;
}
