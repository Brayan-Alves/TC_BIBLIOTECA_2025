package ifpr.edu.br.biblioteca.controller;

import java.util.List;

import ifpr.edu.br.biblioteca.model.Autor;
import ifpr.edu.br.biblioteca.model.dao.AutorDAO;


public class AutorController {

    private AutorDAO dao;

    public AutorController() {
        this.dao = new AutorDAO();
    }

    public void cadastrarAutor(Autor autor) {
        if (autor.getNome() == null || autor.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do autor é obrigatório.");
        }
        dao.salvar(autor);
    }

    public List<Autor> listarAutores() {
        return dao.listarTodos();
    }

    public void atualizarAutor(String nome, int id) {
        dao.atualizar(nome, id);
    }

    public void excluirAutor(int id) {
        dao.excluir(id);
    }
}