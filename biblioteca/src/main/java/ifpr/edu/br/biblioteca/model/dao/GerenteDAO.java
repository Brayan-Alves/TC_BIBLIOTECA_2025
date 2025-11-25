package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ifpr.edu.br.biblioteca.model.Gerente;

public class GerenteDAO {
        public void salvarGerente(Gerente gerente){
        String sqlGerente = "INSERT INTO usuario (nome, cpf, email, senha, id_role) VALUES (?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psGerente = con.prepareStatement(sqlGerente);
            psGerente.setString(1, gerente.getNome());
            psGerente.setString(2, gerente.getCpf());
            psGerente.setString(3, gerente.getEmail());
            psGerente.setString(4, gerente.getSenha());
            psGerente.setInt(5, 3);
            psGerente.executeUpdate();
            System.out.println("Gerente inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    
    }

    public boolean loginGerente(String email, String senha) {

        String sql = "SELECT * FROM gerente WHERE email = ? AND senha = ?";

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
