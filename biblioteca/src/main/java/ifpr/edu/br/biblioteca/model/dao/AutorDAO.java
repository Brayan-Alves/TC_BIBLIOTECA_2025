package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Autor;

public class AutorDAO {
    
    //create
    public void salvarAutor(Autor autor){
        String sqlAutor = "INSERT INTO autor (nome) VALUES (?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psAutor = con.prepareStatement(sqlAutor);
            psAutor.setString(1, autor.getNome());
            psAutor.executeUpdate();
            System.out.println("Autor inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    }
}
