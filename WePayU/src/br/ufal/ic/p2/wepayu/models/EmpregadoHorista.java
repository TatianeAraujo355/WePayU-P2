package br.ufal.ic.p2.wepayu.models;

import br.ufal.ic.p2.wepayu.Exception.EmpregadoNaoExisteException;

public class EmpregadoHorista extends Empregado{

    private static String salarioHora;
    public EmpregadoHorista(String nome, String endereco, String salario) throws EmpregadoNaoExisteException {
        super(nome, endereco);

        this.salarioHora = salario;
    }

    public String getSalario(){
            if(!salarioHora.contains(",")){
                salarioHora += ",00";
            }
            return salarioHora;
//        return salario;

    }
    public String getTipo(){
        return "horista";
    }
}
