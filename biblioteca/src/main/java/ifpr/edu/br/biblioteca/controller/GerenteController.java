package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Gerente;
import ifpr.edu.br.biblioteca.model.Pessoa;
import ifpr.edu.br.biblioteca.model.Biblioteca;
import ifpr.edu.br.biblioteca.model.dao.GerenteDAO;

public class GerenteController {
    private GerenteDAO dao;

    public GerenteController(){
        this.dao = new GerenteDAO();
    }

    public void cadastrarGerente(Gerente gerente, Biblioteca biblioteca, Pessoa pessoa){
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
        dao.salvarGerente(gerente, biblioteca, pessoa);
    }
}
