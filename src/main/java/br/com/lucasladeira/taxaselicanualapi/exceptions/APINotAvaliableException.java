package br.com.lucasladeira.taxaselicanualapi.exceptions;

public class APINotAvaliableException extends RuntimeException {

    public APINotAvaliableException(String msg){
        super(msg);
    }
}
