package br.ufal.ic.p2.wepayu.Exception;

public class AtributoDeveSerNumerico extends Exception {
   public  AtributoDeveSerNumerico(String atributo){
      super(atributo + " deve ser numerico.");
   }
}
