package br.ufal.ic.p2.wepayu;

import br.ufal.ic.p2.wepayu.Exception.*;

public class Facade {

    private br.ufal.ic.p2.wepayu.System system = new System();

    public void zerarSistema(){
        this.system = new System();
    }
    public String criarEmpregado(String nome, String endereco, String tipo, String salario) throws Exception {
        return this.system.setEmpregado(nome, endereco, tipo, salario);
    }
    public String criarEmpregado(String nome, String endereco, String tipo, String salario, String comissao) throws Exception, EmpregadoNaoExisteException, NomeNuloException,
            EnderecoNuloException, ComissaoNuloException, SalarioNuloException, SalarioNegativoException, TipoInvalidoException, SalarioNumerioExeception, ComissaoNegativaException, ComissaoNumericaException, TipoNaoAplicavelException {
        return this.system.setEmpregado(nome, endereco, tipo, salario, comissao);
    }
    public String getAtributoEmpregado(String id, String atributo) throws Exception, AtributoNaoExisteException, EmpregadoNaoExisteException,
            NomeNuloException, ComissaoNuloException, SalarioNuloException, SalarioNegativoException{
        return this.system.getAtributoEmpregado(id, atributo);
    }

}
