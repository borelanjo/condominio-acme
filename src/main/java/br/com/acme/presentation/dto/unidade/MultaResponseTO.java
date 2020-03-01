package br.com.acme.presentation.dto.unidade;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.acme.presentation.dto.shared.HateosLinkTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultaResponseTO extends HateosLinkTO{
    
    private String descricao;

    private BigDecimal valor;
    
    private LocalDate data;

}
