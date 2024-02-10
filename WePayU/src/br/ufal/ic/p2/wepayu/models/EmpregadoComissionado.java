package br.ufal.ic.p2.wepayu.models;

import br.ufal.ic.p2.wepayu.Exception.ExceptionError;

public class EmpregadoComissionado extends Empregado{

    private static String salarioMensal;
    private static String taxaComissao;
    public EmpregadoComissionado(String nome, String endereco, String salario, String comissao) throws ExceptionError {
        super(nome, endereco);

        this.salarioMensal = salario;
        this.taxaComissao = comissao;
    }

    public String getSalario(){
        if(!salarioMensal.contains(",")){
            salarioMensal += ",00";
        }
        return salarioMensal;
//        return salario;

    }

    public static String getComissao(){
        return taxaComissao;
    }

    public String getTipo(){
        return "comissionado";
    }
}
