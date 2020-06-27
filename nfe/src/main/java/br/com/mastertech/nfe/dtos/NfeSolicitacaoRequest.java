package br.com.mastertech.nfe.dtos;

public class NfeSolicitacaoRequest {
    private String identidade;
    private double valor;

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
