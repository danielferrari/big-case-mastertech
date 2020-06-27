package br.com.mastertech.nfe.dtos;

public class NfeEmissaoResponse {
    private String identidade;
    private double valor;
    private String status;
    private NfeResponse nfe;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NfeResponse getNfe() {
        return nfe;
    }

    public void setNfe(NfeResponse nfe) {
        this.nfe = nfe;
    }
}