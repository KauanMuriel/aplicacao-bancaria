package org.example.services;

import org.example.domain.ContaCorrente;
import org.example.domain.ContaPoupanca;
import org.example.domain.ContaSalario;
import org.example.domain.IdentificadorConta;
import org.example.interfaces.Titular;

import java.util.List;

public class ContaFactory {
    public ContaCorrente ContaCorrente(Titular titular, double saldoInicial) {
        IdentificadorConta identificador = gerarIdentificadorConta();
        return new ContaCorrente(identificador, titular, saldoInicial);
    }

    public ContaPoupanca ContaPoupanca(List<Titular> titulares, double saldoInicial) {
        IdentificadorConta identificador = gerarIdentificadorConta();
        return new ContaPoupanca(identificador, titulares, saldoInicial);
    }

    public ContaSalario ContaSalario(Titular titular, double saldoInicial) {
        IdentificadorConta identificador = gerarIdentificadorConta();
        return new ContaSalario(identificador, saldoInicial, titular);
    }

    private IdentificadorConta gerarIdentificadorConta() {
        return;
    }
}
