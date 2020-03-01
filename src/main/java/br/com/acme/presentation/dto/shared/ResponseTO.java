package br.com.acme.presentation.dto.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;

public final class ResponseTO<T> implements Serializable {

    private static final long serialVersionUID = -8994690967909005621L;

    private T data;

    private List<String> errors = new ArrayList<>();

    private List<Link> links = new ArrayList<>();

    public ResponseTO() {
    }

    public ResponseTO(T data) {
        this.data = data;
    }

    public ResponseTO(T data, List<Link> links) {
        super();
        this.data = data;
        this.links = links;
    }

    public ResponseTO(List<String> errors) {
        super();
        this.errors = errors;
    }

    public T getData() {
        return data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
