package br.com.acme.application.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.domain.model.condominio.Condominio;
import br.com.acme.domain.service.BaseService;
import br.com.acme.infrastructure.builder.LinkBuilder;
import br.com.acme.infrastructure.service.ConverterService;
import br.com.acme.infrastructure.service.ResponseService;
import br.com.acme.presentation.dto.condominio.CondominioReducedResponseTO;
import br.com.acme.presentation.dto.condominio.CondominioRequestTO;
import br.com.acme.presentation.dto.condominio.CondominioResponseTO;
import br.com.acme.presentation.dto.shared.ResponseTO;

@RestController
@RequestMapping("/condominios")
public class CondominioController{

    @Autowired
    private BaseService<Condominio> condominioService;

    @Autowired
    private ConverterService converterService;

    @Autowired
    private ResponseService responseService;

    @GetMapping
    public ResponseEntity<ResponseTO<Page<CondominioReducedResponseTO>>> findAll(Pageable pageable) {
        Page<Condominio> page = condominioService.findAll(pageable);
        Page<CondominioReducedResponseTO> responseTOPage = converterService.convert(page,
                CondominioReducedResponseTO.class);
        
        responseTOPage.forEach(r -> r.setLinks(new LinkBuilder()
                .controller(this)
                .addCrudSelf(r.getId())
                .build()));

        return responseService.ok(responseTOPage, new LinkBuilder()
                .controller(this)
                .addGetSelf().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTO<CondominioResponseTO>> find(@PathVariable Long id) {
        List<Link> links = new ArrayList<>();
        Link link = linkTo(methodOn(this.getClass()).find(id)).withSelfRel();
        links.add(link);
        Condominio condominio = condominioService.findById(id);
        CondominioResponseTO responseTO = converterService.convert(condominio, CondominioResponseTO.class);

        return responseService.ok(responseTO, links);
    }

    @PostMapping
    public ResponseEntity<ResponseTO<CondominioResponseTO>> save(@RequestBody CondominioRequestTO requestTO) {
        List<Link> links = new ArrayList<>();
        Condominio condominio = converterService.convert(requestTO, Condominio.class);
        Condominio savedCondominio = condominioService.save(condominio);
        CondominioResponseTO responseTO = converterService.convert(savedCondominio, CondominioResponseTO.class);
        Link link = linkTo(methodOn(this.getClass()).save(requestTO)).withSelfRel();
        links.add(link);
        return responseService.created(responseTO, links);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTO<CondominioResponseTO>> update(@PathVariable Long id,
            @RequestBody CondominioRequestTO requestTO) {
        List<Link> links = new ArrayList<>();
        Link link = linkTo(methodOn(this.getClass()).update(id, requestTO)).withSelfRel();
        links.add(link);
        Condominio condominio = converterService.convert(requestTO, Condominio.class);
        Condominio updatedCondominio = condominioService.update(id, condominio);
        CondominioResponseTO responseTO = converterService.convert(updatedCondominio, CondominioResponseTO.class);

        return responseService.ok(responseTO, links);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        condominioService.delete(id);
    }

}
