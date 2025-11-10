package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Biblioteca;

public class BibliotecaDAO {
    
    public void salvarBiblioteca(Biblioteca biblioteca){
        String sqlBiblioteca = "INSERT INTO biblioteca (nome) VALUES (?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psBiblioteca = con.prepareStatement(sqlBiblioteca);
            psBiblioteca.setString(1, biblioteca.getNome());
            psBiblioteca.executeUpdate();
            System.out.println("Biblioteca inserida com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    }

}
