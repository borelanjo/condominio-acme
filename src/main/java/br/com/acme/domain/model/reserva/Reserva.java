/**
 * 
 */
package br.com.acme.domain.model.reserva;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.areacomum.AreaComum;
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
@Table(name = "tb_reserva")
public class Reserva extends BaseEntity {

    private static final long serialVersionUID = -1405428905200765872L;

    private LocalDate dataReserva;

    private LocalDateTime inicioReserva;

    private LocalDateTime fimReserva;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Responsavel responsavelReserva;

    @ManyToOne
    @JoinColumn(name = "id_area_comum")
    private AreaComum areaComumReservada;
}
