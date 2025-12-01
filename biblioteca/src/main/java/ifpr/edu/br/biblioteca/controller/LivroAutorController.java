package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.dao.LivroAutorDAO;

import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Autor;

public class LivroAutorController {
    
    private LivroAutorDAO dao;

    public LivroAutorController() {
        this.dao = new LivroAutorDAO();
    }

    public void adicionarAutorAoLivro(Livro livro, Autor autor) {
        dao.associarAutorAoLivro(livro, autor);
    }

    public void removerAutorDoLivro(int idLivro) {
        dao.removerAssociacao(idLivro);
    }
}