package ifpr.edu.br.biblioteca.controller;

import java.util.List;

import ifpr.edu.br.biblioteca.model.Usuario;
import ifpr.edu.br.biblioteca.model.dao.UsuarioDAO;

public class UsuarioController {
    private UsuarioDAO dao;

    public UsuarioController() {
        this.dao = new UsuarioDAO();
    }

    public void cadastrarUsuario(Usuario usuario) {
        dao.cadastrar(usuario);
    }

    public Usuario login(String email, String senha) {
        return dao.login(email, senha);
    }

    public void atualizarUsuario(Usuario usuario) {
        dao.atualizar(usuario);
    }

    public void excluirUsuario(int id) {
        dao.excluir(id);
    }

    public List<Usuario> listarUsuarios() {
        return dao.listar();
    }
}