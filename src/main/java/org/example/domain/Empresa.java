package org.example.domain;

import org.example.interfaces.Titular;

import java.util.Date;

public class Empresa implements Titular {
    private final Date dataAbertura;
    private final String CNPJ;

    public Empresa(String cnpj, Date dataAbertura) {
        this.dataAbertura = dataAbertura;
        this.CNPJ = cnpj;
    }
}
