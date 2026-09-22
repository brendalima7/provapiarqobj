package br.edu.insper.provapi.cliente.errorhandler;

import br.edu.insper.provapi.cliente.exception.ClienteNaoEncontradoException;
import br.edu.insper.provapi.common.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ClienteErrorHandler {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleRuntimeException(ClienteNaoEncontradoException re) {

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setDate(LocalDateTime.now());
        errorResponseDTO.setMessage(re.getMessage());
        errorResponseDTO.setStatusCode(404);
        return errorResponseDTO;

    }

}
