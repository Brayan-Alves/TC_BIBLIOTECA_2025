package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import ifpr.edu.br.biblioteca.model.Cliente;
import ifpr.edu.br.biblioteca.model.Pessoa;

public class ClienteDAO {
    public static Scanner LER = new Scanner(System.in);
    
    public void salvarCliente(Cliente clientes){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(LER.next());
        pessoa.setCpf(LER.next());
        pessoa.setEmail(LER.next());
        pessoa.setSenha(LER.next());
        String sqlCliente = "INSERT INTO cliente (nome, cpf, email, senha) VALUES (?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psCliente = con.prepareStatement(sqlCliente);
            psCliente.setString(1, pessoa.getNome());
            psCliente.setString(2, pessoa.getCpf());
            psCliente.setString(3, pessoa.getEmail());
            psCliente.setString(4, pessoa.getSenha());
            psCliente.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    }

}
