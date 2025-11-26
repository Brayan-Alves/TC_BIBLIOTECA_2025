package ifpr.edu.br.biblioteca.controller;

import java.util.List;

import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.dao.LivroDAO;

public class LivroController {

    private LivroDAO dao;

    public LivroController() {
        this.dao = new LivroDAO();
    }

    public void cadastrarLivro(Livro livro) {

        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new IllegalArgumentException("O título do livro é obrigatório.");
        }

        if (livro.getAno() <= 0) {
            throw new IllegalArgumentException("Ano de publicação inválido.");
        }

        if (livro.getEditora() == null) {
            throw new IllegalArgumentException("A editora do livro é obrigatória.");
        }

        dao.salvarLivro(livro);
    }

    public void atualizarLivro(Livro livro) {
        if (livro.getId() <= 0) {
            throw new IllegalArgumentException("ID do livro inválido.");
        }
        dao.atualizarLivro(livro);
    }

    public void deletarLivro(int id) {
        dao.deletarLivro(id);
    }

    public List<Livro> listarTodos() {
        return dao.listarTodos();
    }
}
