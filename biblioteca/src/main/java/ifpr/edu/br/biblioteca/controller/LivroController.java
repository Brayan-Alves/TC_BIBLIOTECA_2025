package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Editora;
import ifpr.edu.br.biblioteca.model.Biblioteca;
import ifpr.edu.br.biblioteca.model.dao.LivroDAO;

public class LivroController {
    private LivroDAO dao;

    public LivroController(){
        this.dao = new LivroDAO();
    }

    public void cadastrarLivro(Livro livro, Editora editora, Biblioteca biblioteca){
        if(livro.getNome() == null || livro.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!(Livro)");
            return;
        }else if(editora.getNome() == null || editora.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!(Editora)");
            return;
        }else if(biblioteca.getNome() == null || biblioteca.getNome().isBlank()){
            System.out.println("Nome não pode ser vazio!(Biblioteca)");
            return;
        }
        dao.salvarLivro(livro, editora, biblioteca);
    }
}
