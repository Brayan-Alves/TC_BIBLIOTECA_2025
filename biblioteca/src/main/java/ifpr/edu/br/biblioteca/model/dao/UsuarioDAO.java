package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ifpr.edu.br.biblioteca.model.Cliente;
import ifpr.edu.br.biblioteca.model.Funcionario;
import ifpr.edu.br.biblioteca.model.Gerente;

public class UsuarioDAO {
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


}
