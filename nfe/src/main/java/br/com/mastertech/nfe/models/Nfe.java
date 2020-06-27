package br.com.mastertech.nfe.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Nfe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private NfeEmissao nfeEmissao;

    @NotNull
    private double valorInicial;

    @NotNull
    private double valorIRRF;

    @NotNull
    private double valorCSLL;

    @NotNull
    private double valorCofins;

    @NotNull
    private double valorFinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NfeEmissao getNfeEmissao() {
        return nfeEmissao;
    }

    public void setNfeEmissao(NfeEmissao nfeEmissao) {
        this.nfeEmissao = nfeEmissao;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorIRRF() {
        return valorIRRF;
    }

    public void setValorIRRF(double valorIRRF) {
        this.valorIRRF = valorIRRF;
    }

    public double getValorCSLL() {
        return valorCSLL;
    }

    public void setValorCSLL(double valorCSLL) {
        this.valorCSLL = valorCSLL;
    }

    public double getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(double valorCofins) {
        this.valorCofins = valorCofins;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

}
