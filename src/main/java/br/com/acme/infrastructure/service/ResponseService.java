package br.com.acme.infrastructure.service;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;

import br.com.acme.presentation.dto.shared.ResponseTO;

public interface ResponseService {

    public <T> ResponseEntity<ResponseTO<T>> created(T data);

    public <T> ResponseEntity<ResponseTO<T>> created(T data, String locationURI);

    public <T> ResponseEntity<ResponseTO<T>> ok(T data);
    
    public <T> ResponseEntity<ResponseTO<T>> created(T data, List<Link> links);

    public <T> ResponseEntity<ResponseTO<T>> created(T data, String locationURI, List<Link> links);

    public <T> ResponseEntity<ResponseTO<T>> ok(T data, List<Link> links);

    public <T> ResponseEntity<T> notFound();

    public ResponseEntity<?> noContent();

}
