package org.example.domain;

import org.example.interfaces.Titular;

public class ContaSalario extends Conta {
    private final Titular titular;

    public ContaSalario(IdentificadorConta identificadorConta, double saldoInicial, Titular titular) {
        super(identificadorConta, saldoInicial);
        this.titular = titular;
    }
}
