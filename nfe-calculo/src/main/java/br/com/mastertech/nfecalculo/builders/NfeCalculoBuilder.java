package br.com.mastertech.nfecalculo.builders;

import br.com.mastertech.nfecalculo.enums.Imposto;
import br.com.mastertech.nfecalculo.exceptions.ValueAlreadyDefinedException;
import br.com.mastertech.nfecalculo.dtos.NfeCalculo;

public class NfeCalculoBuilder {
    private double valorInicial;
    private double valorFinal;
    private double valorIRRF = 0.0;
    private double valorPISCOFINS = 0.0;
    private double valorCSLL = 0.0;

    public NfeCalculoBuilder(double valorNota) {
        this.valorInicial = valorNota;
        this.valorFinal = valorNota;
    }

    public NfeCalculoBuilder adicionaIRRF() {
        if (this.valorIRRF != 0.0) {
            throw new ValueAlreadyDefinedException();
        }
        this.valorIRRF = this.valorInicial * Imposto.IRRF.getImposto();
        this.valorFinal -= this.valorIRRF;
        return this;
    }

    public NfeCalculoBuilder adicionaPISCOFINS() {
        this.valorPISCOFINS = this.valorInicial * Imposto.PIS_COFINS.getImposto();
        this.valorFinal -= this.valorPISCOFINS;
        return this;
    }

    public NfeCalculoBuilder adicionaCSLL() {
        this.valorCSLL = this.valorInicial * Imposto.CSLL.getImposto();
        this.valorFinal -= this.valorCSLL;
        return this;
    }

    public NfeCalculo build() {
        NfeCalculo nfeCalculo = new NfeCalculo();
        nfeCalculo.setValorInicial(this.valorInicial);
        nfeCalculo.setValorIRRF(this.valorIRRF);
        nfeCalculo.setValorCofins(this.valorPISCOFINS);
        nfeCalculo.setValorCSLL(this.valorCSLL);
        nfeCalculo.setValorFinal(this.valorFinal);
        return nfeCalculo;
    }
}
