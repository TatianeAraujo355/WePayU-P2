package br.ufal.ic.p2.wepayu;

import br.ufal.ic.p2.wepayu.Exception.*;
import br.ufal.ic.p2.wepayu.models.*;

import java.util.*;

public class System {
    private static Object out;
    private Object system;

    public void zerarSistema(){
        this.system = new HashMap<>();
    }

    private Map<String, Empregado> empregados = new HashMap<>();

    public String setEmpregado(String nome, String endereco, String tipo, String salario) throws Exception {
        verificarEntradaCriarEmp(nome, endereco, tipo, salario);
        String id = UUID.randomUUID().toString();
        Empregado empregado = null;
        
        if(tipo.equals("assalariado")){
            empregado = new EmpregadoAssalariado(nome, endereco, salario);
            this.empregados.put(id, empregado);
        }
        else if(tipo.equals("horista")){
            empregado = new EmpregadoHorista(nome, endereco, salario);
            this.empregados.put(id, empregado);

        }else if (tipo.equals("comissionado")){

            throw new TipoNaoAplicavelException();
        }
    
        return id;

    }

    public String setEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws Exception {
        verificarEntradaCriarEmp(nome, endereco, tipo, salario);
            try {
                double salarioDouble = Double.parseDouble(comissao);
                if (salarioDouble <= 0) {
                    throw new AtributoDeveSerPositivo("Comissao");
                }
            } catch (NumberFormatException e) {
                throw new AtributoDeveSerNumerico("Comissao");
            }
    
        Empregado empregado = new EmpregadoComissionado(nome, endereco, salario, comissao);
        String id = UUID.randomUUID().toString();
        this.empregados.put(id, empregado);
    
        return id;
    }

     private void verificarEntradaCriarEmp(String nome, String endereco, String tipo, String salario) throws Exception {
        if (nome.isEmpty()) {
            throw new AtributoNaoPodeSerNulo("Nome");
        } else if (endereco.isEmpty()) {
            throw new AtributoNaoPodeSerNulo("Endereco");
        } else if (salario.isEmpty()) {
            throw new AtributoNaoPodeSerNulo("Salario.");
        } else {
            try {
                double salarioDouble = Double.parseDouble(salario);
                if (salarioDouble <= 0) {
                    throw new AtributoDeveSerPositivo("Salario");
                }
            } catch (NumberFormatException e) {
                throw new AtributoDeveSerNumerico("Salario");
            }
        }
    
        if (!tipo.equals("horista") && !tipo.equals("assalariado") && !tipo.equals("comissionado") ) {
            throw new TipoInvalidoException();
        }
    }

    public Empregado getEmpregado(String id) throws ExceptionError {
        if(!this.empregados.containsKey(id)){
            throw new ExceptionError("Empregado nao existe.");
        }

        return this.empregados.get(id);
    }

    public String getAtributoEmpregado(String id, String atributo) throws Exception{
      if(id.equals("")) {
            throw new IdentificacaoNaoPodeSerNulaException();
        }

        if(!this.empregados.containsKey(id)){
            throw new EmpregadoNaoExisteException();
        }

        Empregado empregado = this.empregados.get(id);
        return empregado.getAtributo(atributo);
    }

    public void encerrarSistema(){
        empregados = null;
    }
}
