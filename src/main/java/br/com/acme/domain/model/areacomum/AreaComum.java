/**
 * 
 */
package br.com.acme.domain.model.areacomum;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "tb_area_comum")
public class AreaComum extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Integer codigo;

    private String descricao;
}
