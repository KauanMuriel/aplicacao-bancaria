package org.example.domain;

import org.example.interfaces.Titular;

import java.util.List;

public class ContaPoupanca extends Conta {
    private final List<Titular> titulares;

    public ContaPoupanca(IdentificadorConta identificadorConta, List<Titular> titulares, double saldoInicial) {
        super(identificadorConta, saldoInicial);
        this.titulares = titulares;
    }
}
