package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Gerente;
import ifpr.edu.br.biblioteca.model.Pessoa;
import ifpr.edu.br.biblioteca.model.Biblioteca;

public class GerenteDAO {
        public void salvarGerente(Gerente gerente, Biblioteca biblioteca, Pessoa pessoa){
        String sqlGerente = "INSERT INTO gerente (id_biblioteca, id_pessoa) VALUES (?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psGerente = con.prepareStatement(sqlGerente);
            psGerente.setInt(1, biblioteca.getId());
            psGerente.setInt(2, pessoa.getId());
            psGerente.executeUpdate();
            System.out.println("Gerente inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    
    }
}
