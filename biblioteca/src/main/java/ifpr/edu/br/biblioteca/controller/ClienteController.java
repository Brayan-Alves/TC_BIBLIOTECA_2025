package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Cliente;
import ifpr.edu.br.biblioteca.model.dao.ClienteDAO;

public class ClienteController {
    private ClienteDAO dao;

    public ClienteController(){
        this.dao = new ClienteDAO();
    }

    public void cadastrarCliente(Cliente cliente){
        if(cliente.getNome() == null || cliente.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!");
            return;
        }

        dao.salvarCliente(cliente);
    }
}
