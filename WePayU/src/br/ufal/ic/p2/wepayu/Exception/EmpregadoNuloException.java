package br.ufal.ic.p2.wepayu.Exception;

public class EmpregadoNuloException extends Exception{
    public EmpregadoNuloException(){
        super("Identificacao do empregado nao pode ser nula.");
    }
}
