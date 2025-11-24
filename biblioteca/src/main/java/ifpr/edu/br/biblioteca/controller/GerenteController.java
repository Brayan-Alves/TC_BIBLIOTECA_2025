package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Gerente;
import ifpr.edu.br.biblioteca.model.Biblioteca;
import ifpr.edu.br.biblioteca.model.dao.GerenteDAO;

public class GerenteController {
    private GerenteDAO dao;

    public GerenteController(){
        this.dao = new GerenteDAO();
    }

    public void cadastrarGerente(Gerente gerente){
        if(gerente.getNome() == null || gerente.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!(Funcionáro)");
            return;
        }else if(gerente.getCpf() == null || gerente.getCpf().isBlank()){
            System.out.println("CPF não pode ser vazio!(Funcionáro)");
            return;
        }else if(gerente.getEmail() == null || gerente.getEmail().isBlank()){
            System.out.println("Email não pode ser vazio!(Funcionáro)");
            return;
        }else if(gerente.getSenha() == null || gerente.getSenha().isBlank()){
            System.out.println("Senha não pode ser vazia!(Funcionáro)");
            return;
        }
        dao.salvarGerente(gerente);
    }
}
