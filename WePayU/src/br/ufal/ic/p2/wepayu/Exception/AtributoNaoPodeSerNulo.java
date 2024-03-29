package br.ufal.ic.p2.wepayu.Exception;

public class AtributoNaoPodeSerNulo extends Exception{
    public AtributoNaoPodeSerNulo (String atributo){
        super(atributo + " nao pode ser nulo.");
    }
}
