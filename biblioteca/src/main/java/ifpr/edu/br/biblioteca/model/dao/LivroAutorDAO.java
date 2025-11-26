package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ifpr.edu.br.biblioteca.model.Autor;
import ifpr.edu.br.biblioteca.model.Livro;


public class LivroAutorDAO {

    public void associarAutorAoLivro(Livro livro, Autor autor) {
        String sql = "INSERT INTO livro_autor (id_livro, id_autor) VALUES (?, ?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, livro.getId());
            stmt.setInt(2, autor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao associar autor ao livro");
        }
    }

    public void removerAssociacao(Livro livro, Autor autor) {
        String sql = "DELETE FROM livro_autor WHERE id_livro = ? AND id_autor = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, livro.getId());
            stmt.setInt(2, autor.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover associação");
        }
    }
}