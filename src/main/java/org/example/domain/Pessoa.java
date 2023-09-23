package org.example.domain;

import org.example.domain.enums.EstadoCivil;
import org.example.interfaces.Titular;

import java.util.Date;

public class Pessoa implements Titular {
    private final Date dataNascimento;
    private EstadoCivil estadoCivil;
    private final String CPF;

    public Pessoa(String cpf, Date dataNascimento, EstadoCivil estadoCivil) {
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.CPF = cpf;
    }
}
