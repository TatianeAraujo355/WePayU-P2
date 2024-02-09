package br.ufal.ic.p2.wepayu.Exception;

public class ComissaoNuloException extends Exception{
    public ComissaoNuloException(){
        super("Comissao nao pode ser nula.");
    }
}
