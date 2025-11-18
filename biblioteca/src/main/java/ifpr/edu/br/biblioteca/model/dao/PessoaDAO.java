package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Pessoa;

public class PessoaDAO {
        public void salvarGerente(Pessoa pessoa){
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
}
