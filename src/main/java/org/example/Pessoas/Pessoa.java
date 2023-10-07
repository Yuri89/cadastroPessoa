package org.example.Pessoas;

import org.example.Endereco.Endereco;

public class Pessoa {
    public String nome;
    public float rendimento;
    public Endereco endereco;

    public float CalcularImposto(float rendimento){
        return rendimento;
    }
}
