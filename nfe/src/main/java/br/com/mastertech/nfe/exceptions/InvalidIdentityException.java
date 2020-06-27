package br.com.mastertech.nfe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Número de identidade inválido")
public class InvalidIdentityException extends RuntimeException {
}
