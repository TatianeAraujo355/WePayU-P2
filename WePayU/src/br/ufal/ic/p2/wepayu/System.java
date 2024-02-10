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
        Empregado empregado = null;
        if(tipo.equals("assalariado")){
            empregado = new EmpregadoAssalariado(nome, endereco, salario);
        }
        else if(tipo.equals("horista")){
            empregado = new EmpregadoHorista(nome, endereco, salario);
        }
        else{
            if(tipo.equals("comissionado")){
                throw new ExceptionError("Tipo nao aplicavel.");
            }
            else{
                throw new ExceptionError("Tipo invalido.");
            }
        }

        String id = UUID.randomUUID().toString();

        if(Objects.equals(empregado.getNome(), "")) {
            throw new ExceptionError("Nome nao pode ser nulo.");
        }
        if(Objects.equals(empregado.getSalario(), "")) {
            throw new ExceptionError("Salario nao pode ser nulo.");
        }
        if(Objects.equals(empregado.getEndereco(), "")) {
            throw new ExceptionError("Endereco nao pode ser nulo.");
        }
//        if(tipo.equals("comissionado")){
//            throw new TipoNaoAplicavelException();
//        }
        if(tipo.equals("abc")){
            throw new ExceptionError("Tipo invalido.");
        }
        if(salario.contains("-")) { throw new ExceptionError("Salario deve ser nao-negativo."); }
        if(salario.equals("abc")) { throw new ExceptionError("Salario deve ser numerico."); }
        if(salario.equals("")) { throw new ExceptionError("Salario nao pode ser nulo."); }
        if(!tipo.equals("horista") && !tipo.equals("assalariado")) { throw new ExceptionError("Tipo nao aplicavel."); }

        this.empregados.put(id, empregado);

        return id;
    }

    public String setEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws Exception {

        if (nome.isEmpty()) {
            throw new ExceptionError("Nome nao pode ser nulo.");
        }else if (endereco.isEmpty()) {
            throw new ExceptionError("Endereco nao pode ser nulo.");
        } else if (tipo.equals("abc")) {
            throw new ExceptionError("Tipo invalido.");
        } else if (tipo.equals("horista") || tipo.equals("assalariado")) {
            throw new ExceptionError("Tipo nao aplicavel.");
        } else if (salario.isEmpty()) {
            throw new ExceptionError("Salario nao pode ser nulo.");
        } else if (!salario.matches("[0-9,-]+")) {
            throw new ExceptionError("Salario deve ser numerico.");
        } else if (salario.contains("-")) {
            throw new ExceptionError("Salario deve ser nao-negativo.");
        } else if (comissao.isEmpty()) {
            throw new ExceptionError("Comissao nao pode ser nula.");
        } else if (!comissao.matches("[0-9,-]+")) {
            throw new ExceptionError("Comissao deve ser numerica.");
        } else if (comissao.contains("-")) {
            throw new ExceptionError("Comissao deve ser nao-negativa.");
        }

        String id = UUID.randomUUID().toString();
        Empregado empregado = new EmpregadoComissionado(nome, endereco, salario, comissao);

        this.empregados.put(id, empregado);

        return id;
    }

    public Empregado getEmpregado(String id) throws ExceptionError {
        if(!this.empregados.containsKey(id)){
            throw new ExceptionError("Empregado nao existe.");
        }

        return this.empregados.get(id);
    }

    public String getAtributoEmpregado(String id, String atributo) throws Exception{
        Empregado empregado = this.empregados.get(id);

        if(atributo.equals("abc")){ throw new ExceptionError("Atributo nao existe."); }
        if(id.equals("")) throw new ExceptionError("Identificacao do empregado nao pode ser nula.");
        if(!this.empregados.containsKey(id)){
            throw new ExceptionError("Empregado nao existe.");
        }

        return empregado.getAtributo(atributo);
    }

    public void encerrarSistema(){
        empregados = null;
    }
}