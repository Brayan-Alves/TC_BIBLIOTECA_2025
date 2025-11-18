package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Cliente;
import ifpr.edu.br.biblioteca.model.Pessoa;
import ifpr.edu.br.biblioteca.model.dao.ClienteDAO;

public class ClienteController {
    private ClienteDAO dao;

    public ClienteController(){
        this.dao = new ClienteDAO();
    }

    public void cadastrarCliente(Cliente cliente, Pessoa pessoa){
        if(pessoa.getNome() == null || pessoa.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!(Cliente)");
            return;
        }else if(pessoa.getCpf() == null || pessoa.getCpf().isBlank()){
            System.out.println("CPF não pode ser vazio!(Cliente)");
            return;
        }else if(pessoa.getEmail() == null || pessoa.getEmail().isBlank()){
            System.out.println("Email não pode ser vazio!(Cliente)");
            return;
        }else if(pessoa.getSenha() == null || pessoa.getSenha().isBlank()){
            System.out.println("Senha não pode ser vazia!(Cliente)");
            return;
        }

        dao.salvarCliente(cliente, pessoa);
    }
}
