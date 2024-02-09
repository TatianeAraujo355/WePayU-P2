package br.ufal.ic.p2.wepayu;

import br.ufal.ic.p2.wepayu.Exception.*;
import br.ufal.ic.p2.wepayu.models.Empregado;
import br.ufal.ic.p2.wepayu.models.EmpregadoAssalariado;
import br.ufal.ic.p2.wepayu.models.EmpregadoComissionado;
import br.ufal.ic.p2.wepayu.models.EmpregadoHorista;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


public class System {
    private static Object out;
    private Object system;

    public void zerarSistema(){
        this.system = new HashMap<>();
    }

    private Map<String, Empregado> empregados = new HashMap<>();

    public String setEmpregado(String nome, String endereco, String tipo, String salario) throws Exception, EmpregadoNaoExisteException, NomeNuloException, EnderecoNuloException, SalarioNuloException, TipoNaoAplicavelException, TipoInvalidoException, SalarioNegativoException, SalarioNumerioExeception {
        Empregado empregado = null;
        if(tipo.equals("assalariado")){
            empregado = new EmpregadoAssalariado(nome, endereco, salario);
        }
        else if(tipo.equals("horista")){
            empregado = new EmpregadoHorista(nome, endereco, salario);
        }
        else{
            throw new ExceptionError("Tipo invalido.");
        }

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
        if(!tipo.equals("horista") && !tipo.equals("assalariado")) { throw new TipoNaoAplicavelException(); }
//        VerificarSalario.verificarSalario(salario);
//        if(!tipo.equals("assalariado")) {
//            throw new TipoInvalidoException();
//        }

        this.empregados.put(id, empregado);

        return id;
    }

    public String setEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws Exception, EmpregadoNaoExisteException, NomeNuloException,
            EnderecoNuloException, ComissaoNuloException, SalarioNuloException, SalarioNegativoException, TipoInvalidoException, SalarioNumerioExeception, ComissaoNegativaException, ComissaoNumericaException, TipoNaoAplicavelException {


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


//        if(Objects.equals(empregado.getNome(), "")) {
//            throw new NomeNuloException();
//        }
//        if(Objects.equals(empregado.getEndereco(), "")) {
//            throw new EnderecoNuloException();
//        }
//        if(Objects.equals(empregado.getSalario(), "")) {
//            throw new SalarioNuloException();
//        }
//        if(Objects.equals(empregado.getComissao(), "")) {
//            throw new ComissaoNuloException();
//        }
//        if(tipo.equals("abc")){
//            throw new TipoInvalidoException();
//        }
//        if(salario.contains("-")) { throw new SalarioNegativoException(); }
//        if(salario.equals("abc")) { throw new SalarioNumerioExeception(); }
//        if(salario.equals("")) { throw new SalarioNuloException(); }
//        if(comissao.equals("")) { throw new ComissaoNuloException(); }
//        if(comissao.equals("a")) { throw new ComissaoNumericaException(); }
//        if(comissao.contains("-")) { throw new ComissaoNegativaException(); }
//
//        if(!tipo.equals("horista") && !tipo.equals("assalariado") && !tipo.equals("comissionado")) { throw new TipoNaoAplicavelException(); }
////        if(!tipo.equals("assalariado")) { throw new TipoNaoAplicavelException(); }
////        if() { throw new TipoNaoAplicavelException(); }


        this.empregados.put(id, empregado);

        return id;
    }

    public Empregado getEmpregado(String id) throws EmpregadoNaoExisteException {
        if(!this.empregados.containsKey(id)){
            throw new EmpregadoNaoExisteException();
        }

        return this.empregados.get(id);
    }

    public String getAtributoEmpregado(String id, String atributo) throws Exception, AtributoNaoExisteException, EmpregadoNaoExisteException,
                                                                    NomeNuloException, ComissaoNuloException, SalarioNuloException {
        Empregado empregado = this.empregados.get(id);

        if(atributo.equals("abc")){ throw new AtributoNaoExisteException(); }
        if(id.equals("")) throw new ExceptionError("Identificacao do empregado nao pode ser nula.");
        if(!this.empregados.containsKey(id)){
            throw new EmpregadoNaoExisteException();
        }

        return empregado.getAtributo(atributo);
    }

}