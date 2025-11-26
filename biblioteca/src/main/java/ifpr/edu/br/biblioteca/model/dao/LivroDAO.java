package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Editora;


public class LivroDAO {
    public void salvarLivro(Livro livro) {
        String sql = "INSERT INTO livro (titulo, ano, id_editora) VALUES (?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAno());
            stmt.setInt(3, livro.getEditora().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar livro");
        }
    }

    public void atualizarLivro(Livro livro) {
        String sql = "UPDATE livro SET titulo = ?, ano_publicacao = ?, id_editora = ? WHERE id_livro = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAno());
            stmt.setInt(3, livro.getEditora().getId());
            stmt.setInt(4, livro.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar livro");
        }
    }

    public void deletarLivro(int idLivro) {
        String sql = "DELETE FROM livro WHERE id_livro = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idLivro);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar livro");
        }
    }

    public List<Livro> listarTodos() {
        String sql = "SELECT * FROM livro";
        List<Livro> livros = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                livros.add(mapearLivro(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros");
        }

        return livros;
    }


    private Livro mapearLivro(ResultSet rs) throws SQLException {
        Livro livro = new Livro();

        livro.setId(rs.getInt("id_livro"));
        livro.setTitulo(rs.getString("titulo"));
        livro.setAno(rs.getInt("ano"));

        Editora editora = new Editora();
        editora.setId(rs.getInt("id_editora"));
        livro.setEditora(editora);

        return livro;
    }
}

