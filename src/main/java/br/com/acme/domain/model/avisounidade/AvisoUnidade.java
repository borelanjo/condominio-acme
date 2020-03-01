package br.com.acme.domain.model.avisounidade;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.unidade.Unidade;
import br.com.acme.domain.shared.Aviso;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "t_aviso_unidade")
@NoArgsConstructor
public class AvisoUnidade extends Aviso {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;
}
