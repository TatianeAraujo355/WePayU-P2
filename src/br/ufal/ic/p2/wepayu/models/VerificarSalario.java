package br.ufal.ic.p2.wepayu.models;

import br.ufal.ic.p2.wepayu.Exception.*;

public class VerificarSalario {
    public static void verificarSalario(String salarioString) throws SalarioNegativoException, SalarioNuloException {
        if(salarioString.contains("-")){
            throw new SalarioNegativoException();
        }
        Double salario = Double.parseDouble(salarioString);

//        if(salario < 0){
//            throw new SalarioNegativoException();
//        }
//        if(salario == 0){
//            throw new SalarioNuloException();
//        }
//        else{
//            String salarioFormatado = String.valueOf(salario);
//
//            salarioFormatado = salarioFormatado.replaceAll(".", ",");
//
//            return salarioFormatado;
//        }
//        return salarioString;
    }
}
