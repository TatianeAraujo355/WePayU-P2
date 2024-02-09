package br.ufal.ic.p2.wepayu.models;

import br.ufal.ic.p2.wepayu.Exception.EmpregadoNaoExisteException;

public class EmpregadoAssalariado extends Empregado{

    private static String salarioMensal;
    private static String tipo;
    public EmpregadoAssalariado(String nome, String endereco, String salario) throws EmpregadoNaoExisteException {
        super(nome, endereco);
        this.salarioMensal = salario;
    }

    public String getSalario(){
        if(!salarioMensal.contains(",")){
            salarioMensal += ",00";
        }
        return salarioMensal;
//        return salario;

    }
    public String getTipo(){
        return "assalariado";
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
