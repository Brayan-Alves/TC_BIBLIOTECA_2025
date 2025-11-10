package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Autor;
import ifpr.edu.br.biblioteca.model.dao.AutorDAO;


public class AutorController {
    private AutorDAO dao;

    public AutorController(){
        this.dao = new AutorDAO();
    }

    public void cadastrarAutor(Autor autor){
        if(autor.getNome() == null || autor.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!");
            return;
        }

        dao.salvarAutor(autor);
    }
}
