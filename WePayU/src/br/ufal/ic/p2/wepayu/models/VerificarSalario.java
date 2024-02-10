package br.ufal.ic.p2.wepayu.models;

import br.ufal.ic.p2.wepayu.Exception.*;

public class VerificarSalario {
    public static void verificarSalario(String salarioString) throws ExceptionError {
        if(salarioString.contains("-")){
            throw new ExceptionError("Salario deve ser nao-negativo.");
        }
        Double salario = Double.parseDouble(salarioString);

    }
}
