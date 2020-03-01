package br.com.acme.presentation.dto.unidade;

import java.util.Set;

import br.com.acme.presentation.dto.condominio.CondominioMinResponseTO;
import br.com.acme.presentation.dto.shared.HateosLinkTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeResponseTO extends HateosLinkTO{
    
    private CondominioMinResponseTO condominio;
    
    private String bloco;
    
    private String numero;
    
    private Set<MultaResponseTO> multas;
    
    private Set<AvisoResponseTO> avisos;

}