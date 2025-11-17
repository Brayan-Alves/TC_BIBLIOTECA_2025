package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.dao.LivroDAO;

public class LivroController {
    private LivroDAO dao;

    public LivroController(){
        this.dao = new LivroDAO();
    }

    public void cadastrarLivro(Livro livro){
        if(livro.getNome() == null || livro.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!");
            return;
        }
        dao.salvarLivro(livro, editora, biblioteca);
    }
}
