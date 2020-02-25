package br.com.acme.application.service;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.acme.infrastructure.service.ResponseService;
import br.com.acme.presentation.dto.ResponseTO;

@Service
public class ResponseServiceImpl implements ResponseService {

    public <T> ResponseEntity<ResponseTO<T>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseTO<T>(data));
    }

    public <T> ResponseEntity<ResponseTO<T>> created(T data, String locationURI) {
        return ResponseEntity.created(URI.create(locationURI)).body(new ResponseTO<T>(data));
    }

    public <T> ResponseEntity<ResponseTO<T>> ok(T data) {
        return ResponseEntity.ok(new ResponseTO<T>(data));
    }

    public <T> ResponseEntity<T> notFound() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> noContent() {
        return ResponseEntity.noContent().build();
    }

}
