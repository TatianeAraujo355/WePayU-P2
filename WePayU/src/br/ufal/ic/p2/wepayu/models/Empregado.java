package br.ufal.ic.p2.wepayu.models;

import br.ufal.ic.p2.wepayu.Exception.ExceptionError;

public abstract class Empregado {
    private String nome;
    private String endereco;
    private String tipo;
    private String salario;

    private Boolean sindicalizado;

    public Empregado(String nome, String endereco) throws ExceptionError {
        this.nome = nome;
        this.endereco = endereco;
//        this.tipo = tipo;
//        this.salario = salario;
        this.sindicalizado = Boolean.FALSE;
    }

//    public Empregado(String nome, String endereco, String tipo, String salario, String comissao) throws EmpregadoNaoExisteException {
//        this.nome = nome;
//        this.endereco = endereco;
//        this.tipo = tipo;
//        this.salario = salario;
//        this.comissao = comissao;
//        this.sindicalizado = Boolean.FALSE;
//    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public abstract String getTipo();

    public abstract String getSalario();

//    public String getSalario() {
//        if(!this.salario.contains(",")){
//            this.salario += ",00";
//        }
//        return this.salario;
////        return salario;
//    }


    public Boolean getSindicalizado() { return sindicalizado; }


    public String getAtributo(String atributo){
        switch (atributo){
            case "nome":
                return this.getNome();
            case "endereco":
                return this.getEndereco();
            case "tipo":
                return this.getTipo();
            case "salario":{
                return this.getSalario();
            }
            case "comissao": {
                return EmpregadoComissionado.getComissao();
            }
            case "sindicalizado":
                return this.getSindicalizado().toString();
            default:
                throw new TipoInvalidoException();
        }
    }

}
