package br.ufal.ic.p2.wepayu;

import br.ufal.ic.p2.wepayu.Exception.*;
import br.ufal.ic.p2.wepayu.models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


public class System {
    private Object system;

    public void zerarSistema(){
        this.system = new HashMap<>();
    }

    private Map<String, Empregado> empregados = new HashMap<>();

    public String setEmpregado(String nome, String endereco, String tipo, String salario) throws EmpregadoNaoExisteException, NomeNuloException, EnderecoNuloException, SalarioNuloException, TipoNaoAplicavelException, TipoInvalidoException, SalarioNegativoException, SalarioNumerioExeception {
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
        if(tipo.equals("comissionado")){
            throw new TipoNaoAplicavelException();
        }
        if(tipo.equals("abc")){
            throw new TipoInvalidoException();
        }
        if(salario.contains("-")) { throw new SalarioNegativoException(); }
        if(salario.equals("abc")) { throw new SalarioNumerioExeception(); }
        if(salario.equals("")) { throw new SalarioNuloException(); }
//        if(!tipo.equals("horista") || !tipo.equals("assalariado")) { throw new TipoNaoAplicavelException(); }
//        VerificarSalario.verificarSalario(salario);
//        if(!tipo.equals("assalariado")) {
//            throw new TipoInvalidoException();
//        }

        this.empregados.put(id, empregado);

        return id;
    }

    public String setEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws EmpregadoNaoExisteException, NomeNuloException,
            EnderecoNuloException, ComissaoNuloException, SalarioNuloException, SalarioNegativoException, TipoInvalidoException, SalarioNumerioExeception, ComissaoNegativaException, ComissaoNumericaException, TipoNaoAplicavelException {
        Empregado empregado = new Empregado(nome, endereco, tipo, salario, comissao);

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
        if(tipo.equals("abc")){
            throw new TipoInvalidoException();
        }
        if(salario.contains("-")) { throw new SalarioNegativoException(); }
        if(salario.equals("abc")) { throw new SalarioNumerioExeception(); }
        if(salario.equals("")) { throw new SalarioNuloException(); }
        if(comissao.equals("")) { throw new ComissaoNuloException(); }
        if(comissao.equals("a")) { throw new ComissaoNumericaException(); }
        if(comissao.contains("-")) { throw new ComissaoNegativaException(); }

        if(!tipo.equals("horista") || !tipo.equals("assalariado") || !tipo.equals("comissionado")) { throw new TipoNaoAplicavelException(); }
//        if(!tipo.equals("assalariado")) { throw new TipoNaoAplicavelException(); }
//        if() { throw new TipoNaoAplicavelException(); }


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