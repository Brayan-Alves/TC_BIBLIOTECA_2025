package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ifpr.edu.br.biblioteca.model.Biblioteca;

public class BibliotecaDAO {

    public void salvarBiblioteca(Biblioteca biblioteca) {
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

    public List<Biblioteca> mostrarBibliotecas() {
        List<Biblioteca> lista = new ArrayList<>();

        String sql = "SELECT id_biblioteca, nome FROM biblioteca";

        try (
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Biblioteca b = new Biblioteca();
                b.setId(rs.getInt("id_biblioteca"));
                b.setNome(rs.getString("nome"));
                lista.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

}
