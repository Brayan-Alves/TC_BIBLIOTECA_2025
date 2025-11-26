package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ifpr.edu.br.biblioteca.model.Editora;

public class EditoraDAO {

    private Connection conn;

    public EditoraDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    public void salvar(Editora editora) {
        String sql = "INSERT INTO editora (nome) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, editora.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar editora");
        }
    }

    public List<Editora> listarTodos() {
        List<Editora> lista = new ArrayList<>();
        String sql = "SELECT * FROM editora";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Editora e = new Editora();
                e.setId(rs.getInt("id_editora"));
                e.setNome(rs.getString("nome"));
                lista.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar editoras");
        }
        return lista;
    }

    public void atualizar(String nome, int id) {
        String sql = "UPDATE editora SET nome = ? WHERE id_editora = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar editora");
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM editora WHERE id_editora = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir editora");
        }
    }
}
