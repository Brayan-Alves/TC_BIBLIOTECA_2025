package ifpr.edu.br.biblioteca.controller;

import ifpr.edu.br.biblioteca.model.Emprestimo;
import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Cliente;
import ifpr.edu.br.biblioteca.model.dao.EmprestimoDAO;

public class EmprestimoController {
    private EmprestimoDAO dao;

    public EmprestimoController(){
        this.dao = new EmprestimoDAO();
    }

    public void cadastrarEmprestimo(Emprestimo emprestimo, Livro livro, Cliente cliente){

        dao.salvarEmprestimo(emprestimo, livro, cliente);
    }
}
