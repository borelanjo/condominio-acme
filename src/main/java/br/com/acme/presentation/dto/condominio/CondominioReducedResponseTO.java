package br.com.acme.presentation.dto.condominio;

import java.io.Serializable;

import br.com.acme.presentation.dto.shared.HateosLinkTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondominioReducedResponseTO extends HateosLinkTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;

}
