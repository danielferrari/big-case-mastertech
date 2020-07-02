package br.com.mastertech.nfecalculo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CnpjResponseDto {
    private String cnpj;

    @JsonProperty("capital_social")
    private String capitalSocial;

    private String status;

    private String message;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(String capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
