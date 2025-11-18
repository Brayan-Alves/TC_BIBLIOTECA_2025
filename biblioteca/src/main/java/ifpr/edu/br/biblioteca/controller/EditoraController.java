package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Editora;
import ifpr.edu.br.biblioteca.model.dao.EditoraDAO;

public class EditoraController {
    private EditoraDAO dao;

    public EditoraController(){
        this.dao = new EditoraDAO();
    }

    public void cadastrarEditora(Editora editora){
        if(editora.getNome() == null || editora.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!(Editora)");
            return;
        }

        dao.salvarEditora(editora);
    }
}

