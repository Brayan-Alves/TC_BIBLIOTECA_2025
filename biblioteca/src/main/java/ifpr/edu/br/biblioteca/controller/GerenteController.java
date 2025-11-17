package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Gerente;
import ifpr.edu.br.biblioteca.model.dao.GerenteDAO;

public class GerenteController {
    private GerenteDAO dao;

    public GerenteController(){
        this.dao = new GerenteDAO();
    }

    public void cadastrarGerente(Gerente gerente){
        if(gerente.getNome() == null || gerente.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!");
            return;
        }
        dao.salvarGerente(gerente);
    }
}
