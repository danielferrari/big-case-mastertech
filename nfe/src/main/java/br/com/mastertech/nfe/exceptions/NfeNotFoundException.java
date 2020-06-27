package br.com.mastertech.nfe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nota fiscal não encontrada")
public class NfeNotFoundException extends RuntimeException {
}
