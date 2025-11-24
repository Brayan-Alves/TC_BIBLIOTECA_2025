package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Editora;


public class LivroDAO {

    public void salvarLivro(Livro livro, Editora editora) {
        String sqlGerente = "INSERT INTO livro (nome, editora_id) VALUES (?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psLivro = con.prepareStatement(sqlGerente);
            psLivro.setString(1, livro.getNome());
            psLivro.setInt(2, editora.getId());
            psLivro.executeUpdate();
            System.out.println("Livro inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
