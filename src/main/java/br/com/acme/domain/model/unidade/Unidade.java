package br.com.acme.domain.model.unidade;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.acme.domain.model.avisounidade.AvisoUnidade;
import br.com.acme.domain.model.condominio.Condominio;
import br.com.acme.domain.model.multa.Multa;
import br.com.acme.domain.shared.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "t_unidade")
@NoArgsConstructor
public class Unidade extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_condominio")
    private Condominio condominio;

    @Column(name="numero_unidade")
    private String numero;

    @Column(name="bloco_unidade")
    private String bloco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidade", fetch = FetchType.EAGER)
    private Set<Multa> multas;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidade", fetch = FetchType.EAGER)
    private Set<AvisoUnidade> avisos;
    
    public void addMulta(Multa multa) {
        if(multas == null) {
            multas = new HashSet<>();
        }
        
        multas.add(multa);
    }
    
    public void addAviso(AvisoUnidade aviso) {
        if(avisos == null) {
            avisos = new HashSet<>();
        }
        
        avisos.add(aviso);
    }

}
