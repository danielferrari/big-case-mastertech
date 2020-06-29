package br.com.mastertech.nfecalculo.enums;

public enum Imposto {
    IRRF(0.015),
    CSLL(0.03),
    PIS_COFINS(0.0065);

    private final double imposto;

    Imposto(double imposto) {
        this.imposto = imposto;
    }

    public double getImposto() {
        return imposto;
    }
}
