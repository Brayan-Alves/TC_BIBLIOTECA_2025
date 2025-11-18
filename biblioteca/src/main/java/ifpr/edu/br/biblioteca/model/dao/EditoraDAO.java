package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Editora;

public class EditoraDAO {
    public void salvarEditora(Editora editora){
        String sqlEditora = "INSERT INTO editora (nome) VALUES (?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psEditora = con.prepareStatement(sqlEditora);
            psEditora.setString(1, editora.getNome());
            psEditora.executeUpdate();
            System.out.println("Editora inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    }
}
