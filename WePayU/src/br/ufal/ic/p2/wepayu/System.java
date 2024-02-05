package br.ufal.ic.p2.wepayu;

import br.ufal.ic.p2.wepayu.Exception.*;
import br.ufal.ic.p2.wepayu.models.Empregado;

import java.util.*;


public class System {
    private Object system;

    public void zerarSistema(){
        this.system = new HashMap<>();
    }

    private Map<String, Empregado> empregados = new HashMap<>();

    public String setEmpregado(String nome, String endereco, String tipo, String salario) throws EmpregadoNaoExisteException, NomeNuloException, EnderecoNuloException, SalarioNuloException{
        Empregado empregado = new Empregado(nome, endereco, tipo, salario);

        String id = UUID.randomUUID().toString();

        if(Objects.equals(empregado.getNome(), "")) {
            throw new NomeNuloException();
        }
        if(Objects.equals(empregado.getSalario(), "")) {
            throw new SalarioNuloException();
        }
        if(Objects.equals(empregado.getEndereco(), "")) {
            throw new EnderecoNuloException();
        }

        this.empregados.put(id, empregado);

        return id;
    }

    public String setEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws EmpregadoNaoExisteException, NomeNuloException,
                                                                                                            EnderecoNuloException, ComissaoNuloException, SalarioNuloException{
        Empregado empregado = new Empregado(nome, endereco, tipo, salario);

        String id = UUID.randomUUID().toString();

        if(Objects.equals(empregado.getNome(), "")) {
            throw new NomeNuloException();
        }
        if(Objects.equals(empregado.getEndereco(), "")) {
            throw new EnderecoNuloException();
        }
        if(Objects.equals(empregado.getSalario(), "")) {
            throw new SalarioNuloException();
        }
        if(Objects.equals(empregado.getComissao(), "")) {
            throw new ComissaoNuloException();
        }

        this.empregados.put(id, empregado);

        return id;
    }

    public Empregado getEmpregado(String id) throws EmpregadoNaoExisteException {
        if(!this.empregados.containsKey(id)){
            throw new EmpregadoNaoExisteException();
        }
        return this.empregados.get(id);
    }

    public String getAtributoEmpregado(String id, String atributo) throws AtributoNaoExisteException, EmpregadoNaoExisteException,
                                                                    NomeNuloException, ComissaoNuloException, SalarioNuloException {
        Empregado empregado = this.empregados.get(id);

        if(!this.empregados.containsKey(id)){
            throw new EmpregadoNaoExisteException();
        }

        return empregado.getAtributo(atributo);
    }

}