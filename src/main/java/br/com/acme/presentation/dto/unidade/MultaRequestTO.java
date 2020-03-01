package br.com.acme.presentation.dto.unidade;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultaRequestTO {
    
    private String descricao;

    private BigDecimal valor;

}
