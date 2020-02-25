/**
 * 
 */
package br.com.acme.domain.model.multa;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.condominio.Condominio;
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
@Table(name = "tb_multas")
public class Multa extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String descricaoMulta;

    private LocalDate dataMulta;

    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidadeMulta;

    @ManyToOne
    @JoinColumn(name = "id_condominio")
    private Condominio condominoMulta;

    private BigDecimal valorMulta;
}
