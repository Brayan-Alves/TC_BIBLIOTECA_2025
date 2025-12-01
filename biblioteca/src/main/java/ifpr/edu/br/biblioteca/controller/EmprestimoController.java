package ifpr.edu.br.biblioteca.controller;

import java.util.List;

import ifpr.edu.br.biblioteca.model.Emprestimo;
import ifpr.edu.br.biblioteca.model.dao.EmprestimoDAO;

public class EmprestimoController {

    private EmprestimoDAO dao;

    public EmprestimoController() {
        this.dao = new EmprestimoDAO();
    }

    public void registrarEmprestimo(Emprestimo emprestimo) {
        dao.registrarEmprestimo(emprestimo);
    }

    public void devolverEmprestimo(int idEmprestimo) {
        dao.marcarDevolvido(idEmprestimo);
    }

    public List<Emprestimo> listarEmprestimosPorUsuario(int idUsuario) {
        return dao.listarPorUsuario(idUsuario);
    }
}
