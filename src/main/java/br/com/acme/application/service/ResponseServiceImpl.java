package br.com.acme.application.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.acme.infrastructure.service.ResponseService;
import br.com.acme.presentation.dto.shared.ResponseTO;

@Service
public class ResponseServiceImpl implements ResponseService {

    public <T> ResponseEntity<ResponseTO<T>> created(T data) {
        return created(data, new ArrayList<>());
    }
    
    public <T> ResponseEntity<ResponseTO<T>> created(T data, String locationURI) {
        return created(data, locationURI, new ArrayList<>());
    }
    
    public <T> ResponseEntity<ResponseTO<T>> ok(T data) {
        return ok(data, new ArrayList<>());
    }
    
    public <T> ResponseEntity<ResponseTO<T>> created(T data, List<Link> links) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseTO<T>(data, links));
    }

    public <T> ResponseEntity<ResponseTO<T>> created(T data, String locationURI, List<Link> links) {
        return ResponseEntity.created(URI.create(locationURI)).body(new ResponseTO<T>(data, links));
    }

    public <T> ResponseEntity<ResponseTO<T>> ok(T data, List<Link> links) {
        return ResponseEntity.ok(new ResponseTO<T>(data, links));
    }

    public <T> ResponseEntity<T> notFound() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> noContent() {
        return ResponseEntity.noContent().build();
    }

}
