package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ifpr.edu.br.biblioteca.model.Funcionario;

public class FuncionarioDAO {
    public void salvarFuncionario(Funcionario funcionario) {
        String sqlFuncionario = "INSERT INTO usuario (nome, cpf, email, senha, id_role) VALUES (?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psFuncionario = con.prepareStatement(sqlFuncionario);
            psFuncionario.setString(1, funcionario.getNome());
            psFuncionario.setString(2, funcionario.getCpf());
            psFuncionario.setString(3, funcionario.getEmail());
            psFuncionario.setString(4, funcionario.getSenha());
            psFuncionario.setInt(5, 2);
            psFuncionario.executeUpdate();
            System.out.println("Funcionario inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public boolean loginFuncionario(String email, String senha) {

        String sql = "SELECT * FROM funcionario WHERE email = ? AND senha = ?";

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
