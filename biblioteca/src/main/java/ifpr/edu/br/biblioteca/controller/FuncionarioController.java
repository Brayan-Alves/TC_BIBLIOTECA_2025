package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Funcionario;
import ifpr.edu.br.biblioteca.model.dao.FuncionarioDAO;

public class FuncionarioController {
    private FuncionarioDAO dao;

    public FuncionarioController(){
        this.dao = new FuncionarioDAO();
    }

    public void cadastrarFuncionario(Funcionario funcionario){
        if(funcionario.getNome() == null || funcionario.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!");
            return;
        }
        dao.salvarFuncionario(funcionario);
    }
}
