package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Editora;
import ifpr.edu.br.biblioteca.model.Biblioteca;


public class LivroDAO {
    public static Scanner LER = new Scanner(System.in);

    public void salvarLivro(Livro livro, Editora editora, Biblioteca biblioteca ) {
        String sqlGerente = "INSERT INTO livro (nome, id_editora, biblioteca_id_biblioteca) VALUES (?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psLivro = con.prepareStatement(sqlGerente);
            psLivro.setString(1, sqlGerente);
            psLivro.setInt(2, livro.getId());
            psLivro.setInt(3, editora.getId());
            psLivro.executeUpdate();
            System.out.println("Livro inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
