package org.example.services;

import org.example.domain.Conta;
import org.example.domain.Empresa;
import org.example.domain.enums.TipoConta;
import org.example.interfaces.Titular;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorContas {
    private final double saldoInicialMinimoPoupanca = 50.0;
    private final int numeroMaximoTitularesContaConjunta = 2;
    private final ContaFactory contaFactory;

    public GerenciadorContas(ContaFactory contaFactory) {
        this.contaFactory = contaFactory;
    }

    public Conta AbrirContaIndividual(Titular titular, double saldoInicial, TipoConta tipoConta) {
        Conta contaBancaria;

        switch (tipoConta) {
            case SALARIO:
                validarAberturaContaSalario(titular);
                contaBancaria = contaFactory.ContaSalario(titular, saldoInicial);
                break;
            case POUPANCA:
                var titulares = new ArrayList<Titular>();
                validarAberturaContaPoupanca(titular, saldoInicial);
                contaBancaria = contaFactory.ContaPoupanca(titular, saldoInicial);
                break;
            case CORRENTE:
                contaBancaria = contaFactory.ContaCorrente(titular, saldoInicial);
                break;
            default:
                throw new IllegalArgumentException("O tipo de conta especificado nao e valido.");
        }

        return contaBancaria;
    }

    public Conta AbrirContaConjunta(List<Titular> titulares, double saldoInicial, TipoConta tipoConta) {
        validarAberturaContaConjunta(titulares, tipoConta);

        return;
    }

    private void validarAberturaContaSalario(Titular titular) {
        if (titular instanceof Empresa) {
            throw new IllegalArgumentException("Apenas pessoas físicas podem ser titulares de uma conta salário");
        }
    }

    private void validarAberturaContaCorrente(Titular titular) {

    }

    private void validarAberturaContaPoupanca(Titular titular, double saldoInicial) {
        if (saldoInicial < saldoInicialMinimoPoupanca) {
            throw new IllegalArgumentException("O saldo inicial minimo para uma conta poupanca e de R$" + saldoInicialMinimoPoupanca);
        }
    }

    private void validarAberturaContaConjunta(List<Titular> titulares, TipoConta tipoConta) {
        if (titulares.size() > numeroMaximoTitularesContaConjunta) {
            throw new IllegalArgumentException("Uma conta conjunta pode ter no máximo " + numeroMaximoTitularesContaConjunta + " titulares.");
        }

        if (titulares.stream().anyMatch(titular -> titular instanceof Empresa)) {
            throw new IllegalArgumentException("Uma conta conjunta só pode ter pessoas físicas como titulares.");
        }

        if (tipoConta.equals(TipoConta.SALARIO)) {
            throw new IllegalArgumentException("Contas do tipo salario so podem ser individuais.");
        }
    }
}
