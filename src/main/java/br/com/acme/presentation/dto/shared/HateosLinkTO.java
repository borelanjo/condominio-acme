package br.com.acme.presentation.dto.shared;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class HateosLinkTO {
    
    protected List<Link> links;
    
    protected Long id;
    
    public void addLink(Link link) {
        if(links == null) {
            links = new ArrayList<>();
        }
        links.add(link);
    }

}
