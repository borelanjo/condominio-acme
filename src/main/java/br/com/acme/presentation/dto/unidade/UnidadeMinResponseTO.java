package br.com.acme.presentation.dto.unidade;

import br.com.acme.presentation.dto.shared.HateosLinkTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeMinResponseTO extends HateosLinkTO {

    private String bloco;

    private String numero;

}