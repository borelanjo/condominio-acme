package br.com.acme.domain.model.avisocondominio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.acme.domain.model.condominio.Condominio;
import br.com.acme.domain.shared.Aviso;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_aviso_condominio")
public class AvisoCondominio extends Aviso {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_condominio")
    private Condominio condominio;
}
