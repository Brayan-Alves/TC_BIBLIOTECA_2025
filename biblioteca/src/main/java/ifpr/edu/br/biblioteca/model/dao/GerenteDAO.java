package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Gerente;

public class GerenteDAO {
        public void salvarGerente(Gerente gerente){
        String sqlGerente = "INSERT INTO gerente (nome, cpf, email, senha) VALUES (?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psGerente = con.prepareStatement(sqlGerente);
            psGerente.setString(1, gerente.getNome());
            psGerente.setString(2, gerente.getCpf());
            psGerente.setString(3, gerente.getEmail());
            psGerente.setString(4, gerente.getSenha());
            psGerente.executeUpdate();
            System.out.println("Gerente inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    
    }
}
