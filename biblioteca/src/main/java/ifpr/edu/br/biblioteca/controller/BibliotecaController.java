package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Biblioteca;
import ifpr.edu.br.biblioteca.model.dao.BibliotecaDAO;

public class BibliotecaController {
    private BibliotecaDAO dao;

    public BibliotecaController(){
        this.dao = new BibliotecaDAO();
    }

    public void cadastrarBiblioteca(Biblioteca biblioteca){
        if(biblioteca.getNome() == null || biblioteca.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!");
            return;
        }

        dao.salvarBiblioteca(biblioteca);
    }
}
