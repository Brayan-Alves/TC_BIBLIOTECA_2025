package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ifpr.edu.br.biblioteca.model.Autor;

public class AutorDAO {

    private Connection conn;

    public AutorDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    public void salvar(Autor autor) {
        String sql = "INSERT INTO autor (nome) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, autor.getNome());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    autor.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar autor");
        }
    }

    public List<Autor> listarTodos() {
        List<Autor> lista = new ArrayList<>();
        String sql = "SELECT * FROM autor";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Autor a = new Autor();
                a.setId(rs.getInt("id_autor"));
                a.setNome(rs.getString("nome"));
                lista.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar autores");
        }
        return lista;
    }

    public void atualizar(String nome, int id) {
        String sql = "UPDATE autor SET nome = ? WHERE id_autor = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar autor");
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM autor WHERE id_autor = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir autor");
        }
    }
}
