package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.sql.Statement;

import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Autor;
import ifpr.edu.br.biblioteca.model.Editora;

public class LivroDAO {
    public void salvarLivro(Livro livro) {
        String sql = "INSERT INTO livro (titulo, ano, id_editora) VALUES (?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAno());
            stmt.setInt(3, livro.getEditora().getId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    livro.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar livro");
        }
    }

    public void atualizarLivro(Livro livro) {
        String sql = "UPDATE livro SET titulo = ?, ano = ?, id_editora = ? WHERE id_livro = ?";

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
        String sql = "SELECT l.id_livro, l.titulo, l.ano, e.id_editora, e.nome AS nome_editora, a.id_autor, a.nome AS nome_autor " + 
                    "FROM livro l " + 
                    "JOIN editora e ON e.id_editora = l.id_editora " + 
                    "JOIN autor_livro al ON al.id_livro = l.id_livro " + 
                    "JOIN autor a ON a.id_autor = al.id_autor";

        Map<Integer, Livro> mapaLivros = new LinkedHashMap<>();

        try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int idLivro = rs.getInt("id_livro");

                Livro livro = mapaLivros.get(idLivro);

                if (livro == null) {
                    livro = new Livro();
                    livro.setId(idLivro);
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setAno(rs.getInt("ano"));

                    Editora editora = new Editora();
                    editora.setId(rs.getInt("id_editora"));
                    editora.setNome(rs.getString("nome_editora"));
                    livro.setEditora(editora);

                    livro.setAutores(new ArrayList<>());
                    mapaLivros.put(idLivro, livro);
                }

                int idAutor = rs.getInt("id_autor");
                if (idAutor != 0) {
                    Autor autor = new Autor();
                    autor.setId(idAutor);
                    autor.setNome(rs.getString("nome_autor"));
                    livro.getAutores().add(autor);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros", e);
        }

        return new ArrayList<>(mapaLivros.values());
    }
}
