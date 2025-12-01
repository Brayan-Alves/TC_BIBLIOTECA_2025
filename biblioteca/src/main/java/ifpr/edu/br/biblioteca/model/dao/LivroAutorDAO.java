package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ifpr.edu.br.biblioteca.model.Autor;
import ifpr.edu.br.biblioteca.model.Livro;


public class LivroAutorDAO {

    public void associarAutorAoLivro(Livro livro, Autor autor) {
        String sql = "INSERT INTO autor_livro (id_autor, id_livro) VALUES (?,?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, autor.getId());
            stmt.setInt(2, livro.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao associar autor ao livro");
        }
    }

    public void removerAssociacao(int idLivro) {
        String sql = "DELETE FROM autor_livro WHERE id_livro = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idLivro);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover associação");
        }
    }
}