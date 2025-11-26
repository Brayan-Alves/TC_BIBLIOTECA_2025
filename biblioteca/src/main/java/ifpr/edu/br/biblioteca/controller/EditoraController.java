package ifpr.edu.br.biblioteca.controller;

import java.util.List;

import ifpr.edu.br.biblioteca.model.Editora;
import ifpr.edu.br.biblioteca.model.dao.EditoraDAO;

public class EditoraController {
    private EditoraDAO dao;

    public EditoraController(){
        this.dao = new EditoraDAO();
    }

    public void cadastrarAutor(Editora editora) {
        if (editora.getNome() == null || editora.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da editora é obrigatório.");
        }
        dao.salvar(editora);
    }

    public List<Editora> listarEditora() {
        return dao.listarTodos();
    }

    public void atualizarEditora(String nome, int id) {
        dao.atualizar(nome, id);
    }

    public void excluirEditora(int id) {
        dao.excluir(id);
    }
}

