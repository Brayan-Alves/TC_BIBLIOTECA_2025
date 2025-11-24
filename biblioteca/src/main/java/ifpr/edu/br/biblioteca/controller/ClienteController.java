package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Cliente;
import ifpr.edu.br.biblioteca.model.dao.ClienteDAO;

public class ClienteController {
    private ClienteDAO daoC;

    public ClienteController(){
        this.daoC = new ClienteDAO();
    }

    public void cadastrarCliente(Cliente cliente){
        if(cliente.getNome() == null || cliente.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!(Cliente)");
            return;
        }else if(cliente.getCpf() == null || cliente.getCpf().isBlank()){
            System.out.println("CPF não pode ser vazio!(Cliente)");
            return;
        }else if(cliente.getEmail() == null || cliente.getEmail().isBlank()){
            System.out.println("Email não pode ser vazio!(Cliente)");
            return;
        }else if(cliente.getSenha() == null || cliente.getSenha().isBlank()){
            System.out.println("Senha não pode ser vazia!(Cliente)");
            return;
        }

        daoC.salvarCliente(cliente);
    }

    public boolean autenticar(String email, String senha){
        return daoC.loginCliente(email, senha);
    }
}
