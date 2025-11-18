package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Autor;
import ifpr.edu.br.biblioteca.model.Livro;


public class AutorLivroDAO {
    
    //create
    public void salvarAutor(Autor autor, Livro livro){
        String sqlAutorLivro = "INSERT INTO autor_livro (id_autor, id_livro) VALUES (?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psAutorLivro = con.prepareStatement(sqlAutorLivro);
            psAutorLivro.setInt(1, autor.getId());
            psAutorLivro.setInt(2, livro.getId());
            psAutorLivro.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    }
}