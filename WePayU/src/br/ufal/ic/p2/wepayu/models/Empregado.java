package br.ufal.ic.p2.wepayu.models;

import br.ufal.ic.p2.wepayu.Exception.*;

public class Empregado {
    private String nome;
    private String endereco;
    private String tipo;
    private String salario;
    private String comissao;

    private Boolean sindicalizado;

    public Empregado(String nome, String endereco, String tipo, String salario) throws EmpregadoNaoExisteException {
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.salario = salario;
        this.sindicalizado = Boolean.FALSE;
    }

    public Empregado(String nome, String endereco, String tipo, String salario, String comissao) throws EmpregadoNaoExisteException {
        this.nome = nome;
        this.endereco = endereco;
        this.tipo = tipo;
        this.salario = salario;
        this.comissao = comissao;
        this.sindicalizado = Boolean.FALSE;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSalario() {
        if(!this.salario.contains(",")){
            this.salario += ",00";
        }
        return this.salario;
//        return salario;
    }

    public String getComissao() { return comissao; }

    public Boolean getSindicalizado() { return sindicalizado; }


    public String getAtributo(String atributo){
        switch (atributo){
            case "nome":
                return this.getNome();
            case "endereco":
                return this.getEndereco();
            case "tipo":
                return this.getTipo();
            case "salario":
                return this.getSalario();
            case "comissao":
                return this.getComissao();
            case "sindicalizado":
                return this.getSindicalizado().toString();
            default:
                throw new RuntimeException("Tipo invalido.");
        }
    }

}
