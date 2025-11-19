package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ifpr.edu.br.biblioteca.model.Pessoa;

public class PessoaDAO {
    public void salvarPessoa(Pessoa pessoa) {
        String sqlPessoa = "INSERT INTO pessoa (nome, cpf, email, senha) VALUES (?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psPessoa = con.prepareStatement(sqlPessoa);
            psPessoa.setString(1, pessoa.getNome());
            psPessoa.setString(2, pessoa.getCpf());
            psPessoa.setString(3, pessoa.getEmail());
            psPessoa.setString(4, pessoa.getSenha());
            psPessoa.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public Pessoa login(String email, String senha) {
        String sql = "SELECT id_pessoa, nome FROM pessoa WHERE email = ? AND senha = ?";

        try (
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, email);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id_pessoa"));
                p.setNome(rs.getString("nome"));
                return p;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
