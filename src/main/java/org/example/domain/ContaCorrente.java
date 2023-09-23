package org.example.domain;

import org.example.interfaces.Titular;

public class ContaCorrente extends Conta{
    public ContaCorrente(IdentificadorConta identificadorConta, Titular titular, double saldoInicial) {
        super(identificadorConta, saldoInicial);
    }
}
