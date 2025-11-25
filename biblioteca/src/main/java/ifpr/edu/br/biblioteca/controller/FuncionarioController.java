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
            System.out.println("Nome não pode ser vazio!(Funcionáro)");
            return;
        }else if(funcionario.getCpf() == null || funcionario.getCpf().isBlank()){
            System.out.println("CPF não pode ser vazio!(Funcionáro)");
            return;
        }else if(funcionario.getEmail() == null || funcionario.getEmail().isBlank()){
            System.out.println("Email não pode ser vazio!(Funcionáro)");
            return;
        }else if(funcionario.getSenha() == null || funcionario.getSenha().isBlank()){
            System.out.println("Senha não pode ser vazia!(Funcionáro)");
            return;
        }
        dao.salvarFuncionario(funcionario);
    }

    public boolean autenticar(String email, String senha){
        return dao.loginFuncionario(email, senha);
    }
}
