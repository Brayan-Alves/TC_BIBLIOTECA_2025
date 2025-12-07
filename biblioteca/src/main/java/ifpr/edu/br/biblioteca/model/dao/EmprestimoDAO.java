package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ifpr.edu.br.biblioteca.model.Emprestimo;
import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Usuario;

public class EmprestimoDAO {

    public void registrarEmprestimo(Emprestimo e) {
        String sql = "INSERT INTO emprestimo (id_usuario, id_livro, data_emprestimo, data_devolucao, devolvido) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, e.getUsuario().getId());
            stmt.setInt(2, e.getLivro().getId());
            stmt.setDate(3, e.getDataEmprestimo());
            stmt.setDate(4, e.getDataDevolucao());
            stmt.setInt(5, 0);
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    e.setId(rs.getInt(1));
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao registrar empréstimo");
        }
    }

    public void marcarDevolvido(int idEmprestimo) {
        String sql = "UPDATE emprestimo SET devolvido = 1 WHERE id_emprestimo = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idEmprestimo);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao marcar empréstimo como devolvido");
        }
    }

    public List<Emprestimo> listarTodos() {
        String sql = "SELECT * FROM emprestimo";
        List<Emprestimo> lista = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearEmprestimo(rs));
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar empréstimos", ex);
        }

        return lista;
    }


    public List<Emprestimo> listarPorUsuario(int idUsuario) {
        String sql = "SELECT * FROM emprestimo WHERE id_usuario = ?";
        List<Emprestimo> lista = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(mapearEmprestimo(rs));
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar empréstimos por usuário", ex);
        }

        return lista;
    }

    private Emprestimo mapearEmprestimo(ResultSet rs) throws SQLException {
        Emprestimo e = new Emprestimo();

        e.setId(rs.getInt("id_emprestimo"));

        Usuario u = new Usuario();
        u.setId(rs.getInt("id_usuario"));
        e.setUsuario(u);

        Livro l = new Livro();
        l.setId(rs.getInt("id_livro"));
        e.setLivro(l);

        e.setDataEmprestimo(rs.getDate("data_emprestimo"));
        e.setDataDevolucao(rs.getDate("data_devolucao"));
        e.setDevolvido(rs.getBoolean("devolvido"));

        return e;
    }
}