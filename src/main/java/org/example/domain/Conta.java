package org.example.domain;

public abstract class Conta {
    private final IdentificadorConta identificadorConta;
    private double saldo;

    public Conta(IdentificadorConta identificadorConta, double saldoInicial) {
        this.identificadorConta = identificadorConta;
        this.saldo = saldoInicial;
    }
}
