package br.edu.insper.provapi.common;

public class CampoInvalidoException extends RuntimeException {
    public CampoInvalidoException(String message) {
        super(message);
    }
}
