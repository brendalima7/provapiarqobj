package br.edu.insper.provapi.agendamento.exception;

public class AgendamentoNaoEncontradoException extends RuntimeException {

    public AgendamentoNaoEncontradoException(String message) {
        super(message);
    }
}