package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Cliente;
import ifpr.edu.br.biblioteca.model.Pessoa;

public class ClienteDAO {
    
    public void salvarCliente(Cliente cliente, Pessoa pessoa){
        String sqlCliente = "INSERT INTO cliente (id_pessoa) VALUES (?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psCliente = con.prepareStatement(sqlCliente);
            psCliente.setInt(1, pessoa.getId());
            psCliente.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    }

}
