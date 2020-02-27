package br.com.acme.infrastructure.builder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;

public class LinkBuilder {
    
    private List<Link> links = new ArrayList<>();
    
    private Class<? extends Object> controllerClass;
    
    public LinkBuilder controller(Object controller) {
        this.controllerClass = controller.getClass();
        return this;
    }
    
    public LinkBuilder addSelf() {
        links.add(linkTo(controllerClass).withSelfRel());
        return this;
    }
    
    public LinkBuilder addGetSelf() {
        links.add(linkTo(controllerClass).withSelfRel().withType("GET"));
        return this;
    }
    
    public LinkBuilder addSelf(Long id) {
        links.add(linkTo(controllerClass).slash(id).withSelfRel());
        return this;
    }
    
    public LinkBuilder addCrudSelf(Long id) {
        links.add(linkTo(controllerClass).slash(id).withSelfRel().withType("GET"));
        links.add(linkTo(controllerClass).slash(id).withSelfRel().withType("PUT"));
        links.add(linkTo(controllerClass).slash(id).withSelfRel().withType("DELETE"));
        return this;
    }
    
    public List<Link> build (){
        return links;
    }

}
