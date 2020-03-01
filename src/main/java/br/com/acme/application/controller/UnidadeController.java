package br.com.acme.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.domain.model.avisounidade.AvisoUnidade;
import br.com.acme.domain.model.condominio.Condominio;
import br.com.acme.domain.model.multa.Multa;
import br.com.acme.domain.model.unidade.Unidade;
import br.com.acme.domain.service.UnidadeService;
import br.com.acme.infrastructure.service.ConverterService;
import br.com.acme.infrastructure.service.LinkService;
import br.com.acme.infrastructure.service.ResponseService;
import br.com.acme.presentation.dto.shared.ResponseTO;
import br.com.acme.presentation.dto.unidade.AvisoRequestTO;
import br.com.acme.presentation.dto.unidade.MultaRequestTO;
import br.com.acme.presentation.dto.unidade.UnidadeReducedResponseTO;
import br.com.acme.presentation.dto.unidade.UnidadeRequestTO;
import br.com.acme.presentation.dto.unidade.UnidadeResponseTO;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    
    @Autowired
    private ConverterService converterService;

    @Autowired
    private ResponseService responseService;
    
    @Autowired
    private LinkService linkService;

    @GetMapping
    public ResponseEntity<ResponseTO<Page<UnidadeReducedResponseTO>>> findAll(Pageable pageable) {
        Page<Unidade> page = unidadeService.findAll(pageable);
        Page<UnidadeReducedResponseTO> responseTOPage = converterService.convert(page,
                UnidadeReducedResponseTO.class);
        
        linkService.linksOfPage(this, responseTOPage);

        return responseService.ok(responseTOPage, linkService.linkOfController(this));
    }
    
    @GetMapping(params = "hasMultas")
    public ResponseEntity<ResponseTO<Page<UnidadeReducedResponseTO>>> findAll(@RequestParam(value = "hasMultas")  boolean hasMultas, Pageable pageable) {
        Page<Unidade> page = unidadeService.findAll(hasMultas, pageable);
        Page<UnidadeReducedResponseTO> responseTOPage = converterService.convert(page,
                UnidadeReducedResponseTO.class);
        
        linkService.linksOfPage(this, responseTOPage);

        return responseService.ok(responseTOPage, linkService.linkOfController(this));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTO<UnidadeResponseTO>> find(@PathVariable Long id) {
        Unidade unidade = unidadeService.findById(id);
        UnidadeResponseTO responseTO = converterService.convert(unidade, UnidadeResponseTO.class);
        linkService.linkOfResponse(this, responseTO);

        return responseService.ok(responseTO, linkService.linkOfController(this, id));
    }

    @PostMapping
    public ResponseEntity<ResponseTO<UnidadeResponseTO>> save(@RequestBody UnidadeRequestTO requestTO) {
        Unidade unidade = converterService.convert(requestTO, Unidade.class);
        unidade.setCondominio(new Condominio(requestTO.getCondominio()));
        Unidade savedUnidade = unidadeService.save(unidade);
        UnidadeResponseTO responseTO = converterService.convert(savedUnidade, UnidadeResponseTO.class);
        linkService.linkOfResponse(this, responseTO);
        
        return responseService.created(responseTO, linkService.linkOfController(this));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTO<UnidadeResponseTO>> update(@PathVariable Long id,
            @RequestBody UnidadeRequestTO requestTO) {
        Unidade unidade = converterService.convert(requestTO, Unidade.class);
        unidade.setCondominio(new Condominio(requestTO.getCondominio()));
        Unidade updatedUnidade = unidadeService.update(id, unidade);
        UnidadeResponseTO responseTO = converterService.convert(updatedUnidade, UnidadeResponseTO.class);
        linkService.linkOfResponse(this, responseTO);

        return responseService.ok(responseTO, linkService.linkOfController(this, id));
    }
    
    @PatchMapping("/{id}/multas")
    public ResponseEntity<ResponseTO<UnidadeResponseTO>> enviarMulta(@PathVariable Long id,
            @RequestBody MultaRequestTO requestTO) {
        
        Multa multa = converterService.convert(requestTO, Multa.class);
        Unidade updatedUnidade = unidadeService.sendPenalty(id, multa);
        UnidadeResponseTO responseTO = converterService.convert(updatedUnidade, UnidadeResponseTO.class);
        linkService.linkOfResponse(this, responseTO);

        return responseService.ok(responseTO, linkService.linkOfController(this, id));
    }
    
    @PatchMapping("/{id}/avisos")
    public ResponseEntity<ResponseTO<UnidadeResponseTO>> enviarAviso(@PathVariable Long id,
            @RequestBody AvisoRequestTO requestTO) {
        
        AvisoUnidade aviso = converterService.convert(requestTO, AvisoUnidade.class);
        Unidade updatedUnidade = unidadeService.sendWarning(id, aviso);
        UnidadeResponseTO responseTO = converterService.convert(updatedUnidade, UnidadeResponseTO.class);
        linkService.linkOfResponse(this, responseTO);

        return responseService.ok(responseTO, linkService.linkOfController(this, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        unidadeService.delete(id);
    }

}
