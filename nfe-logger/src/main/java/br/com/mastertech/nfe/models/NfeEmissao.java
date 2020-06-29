package br.com.mastertech.nfe.models;

public class NfeEmissao {
    private Long id;
    private String identidade;
    private double valor;
    private Nfe nfe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Nfe getNfe() {
        return nfe;
    }

    public void setNfe(Nfe nfe) {
        this.nfe = nfe;
    }
}
