package br.com.mastertech.nfecalculo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CnpjDto {
    private String cnpj;

    @JsonProperty("capital_social")
    private String capitalSocial;

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
}
