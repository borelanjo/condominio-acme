package br.com.acme.infrastructure.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import br.com.acme.infrastructure.builder.LinkBuilder;
import br.com.acme.presentation.dto.shared.HateosLinkTO;

@Service
public class LinkService {
    
    public Page<? extends HateosLinkTO> linksOfPage(Object controller, Page<? extends HateosLinkTO> page){
        
        page.forEach(r -> linkOfResponse(controller, r));
        
        return page;
        
    }
    
    public HateosLinkTO linkOfResponse(Object controller, HateosLinkTO responseTO){
        
        responseTO.setLinks(new LinkBuilder()
                .controller(controller)
                .addSelf(responseTO.getId())
                .build());
        
        return responseTO;
    }
    
    public List<Link> linkOfController(Object controller){
        
        return new LinkBuilder()
                .controller(controller)
                .addSelf()
                .build();
    }
    
    public List<Link> linkOfController(Object controller, Long id){
        
        return new LinkBuilder()
                .controller(controller)
                .addSelf(id)
                .build();
    }

}
