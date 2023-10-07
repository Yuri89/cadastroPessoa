package org.example.Pessoas;

import java.time.LocalDate;

public class PessoaJuridica extends Pessoa{

    String cnpj;
    LocalDate dataRegis;

    public float CalcularImposto(float rendimento) {

        if (rendimento <= 1500){
            return 0;
        } else if (rendimento <= 3500) {
            return rendimento * .02f;
        } else if (rendimento <= 6000) {
            return rendimento * .035f;
        }else {
            return rendimento * .05f;
        }

    }
}
