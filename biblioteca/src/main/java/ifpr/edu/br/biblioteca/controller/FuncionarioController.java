package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Biblioteca;
import ifpr.edu.br.biblioteca.model.Funcionario;
import ifpr.edu.br.biblioteca.model.Pessoa;
import ifpr.edu.br.biblioteca.model.dao.FuncionarioDAO;

public class FuncionarioController {
    private FuncionarioDAO dao;

    public FuncionarioController(){
        this.dao = new FuncionarioDAO();
    }

    public void cadastrarFuncionario(Funcionario funcionario, Pessoa pessoa, Biblioteca biblioteca){
        if(pessoa.getNome() == null || pessoa.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!(Funcionáro)");
            return;
        }else if(pessoa.getCpf() == null || pessoa.getCpf().isBlank()){
            System.out.println("CPF não pode ser vazio!(Funcionáro)");
            return;
        }else if(pessoa.getEmail() == null || pessoa.getEmail().isBlank()){
            System.out.println("Email não pode ser vazio!(Funcionáro)");
            return;
        }else if(pessoa.getSenha() == null || pessoa.getSenha().isBlank()){
            System.out.println("Senha não pode ser vazia!(Funcionáro)");
            return;
        }else if(biblioteca.getNome() == null || biblioteca.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!(Biblioteca)");
            return;
        }
        dao.salvarFuncionario(funcionario, pessoa, biblioteca);
    }
}
