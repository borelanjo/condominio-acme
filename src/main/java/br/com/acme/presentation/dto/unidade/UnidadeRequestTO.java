package br.com.acme.presentation.dto.unidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeRequestTO {
    
    private Long condominio;
    
    private String bloco;
    
    private String numero;

}
