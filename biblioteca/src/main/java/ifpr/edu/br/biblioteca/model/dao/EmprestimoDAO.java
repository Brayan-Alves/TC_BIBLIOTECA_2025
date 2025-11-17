package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import ifpr.edu.br.biblioteca.model.Emprestimo;
import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Cliente;

public class EmprestimoDAO {
    public static Scanner LER = new Scanner(System.in);
        public void salvarEmprestimo(Emprestimo emprestimo, Livro livro, Cliente cliente){
        String sqlEmprestimo = "INSERT INTO emprestimo (livro_id_livro, cliente_id_cliente) VALUES (?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psEmprestimo = con.prepareStatement(sqlEmprestimo);
            psEmprestimo.setInt(1, livro.getId());
            psEmprestimo.setInt(2, cliente.getId());
            psEmprestimo.executeUpdate();
            System.out.println("Empréstimo inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    
    }
}
