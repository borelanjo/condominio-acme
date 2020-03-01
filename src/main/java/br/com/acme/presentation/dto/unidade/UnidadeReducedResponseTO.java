package br.com.acme.presentation.dto.unidade;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.acme.presentation.dto.shared.HateosLinkTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeReducedResponseTO extends HateosLinkTO{
    
    @JsonProperty(value = "condominio")
    private String condominioNome;
    
    private String bloco;
    
    private String numero;

}
