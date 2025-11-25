package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ifpr.edu.br.biblioteca.model.Cliente;

public class ClienteDAO {

    public void salvarCliente(Cliente cliente) {

        String sql = "INSERT INTO usuario (nome, cpf, email, senha, id_role) VALUES (?,?,?,?,?)";
        
        try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getSenha());
            ps.setInt(5, 1);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "INSERT INTO cliente (id_cliente, endereco) VALUES (?,?)";
        try (Connection con = ConnectionFactory.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getEndereco());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginCliente(String email, String senha) {

        String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
