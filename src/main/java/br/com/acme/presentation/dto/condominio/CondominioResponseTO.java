package br.com.acme.presentation.dto.condominio;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondominioResponseTO implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String email;
    
    private String nome;
    
    private String telefone;

}
