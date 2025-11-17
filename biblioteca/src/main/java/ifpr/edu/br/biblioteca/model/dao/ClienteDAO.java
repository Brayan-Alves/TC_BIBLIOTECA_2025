package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import ifpr.edu.br.biblioteca.model.Cliente;

public class ClienteDAO {
    public static Scanner LER = new Scanner(System.in);
    
    public void salvarCliente(Cliente cliente){
        String sqlCliente = "INSERT INTO cliente (id_pessoa) VALUES (?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psCliente = con.prepareStatement(sqlCliente);
            psCliente.setString(1, cliente.getNome());
            psCliente.setString(2, cliente.getCpf());
            psCliente.setString(3, cliente.getEmail());
            psCliente.setString(4, cliente.getSenha());
            psCliente.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    }

}
