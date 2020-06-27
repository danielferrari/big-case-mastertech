package br.com.mastertech.nfe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Esse número de nota fiscal já existe")
public class NfeAlreadyExistsException extends RuntimeException {
}
