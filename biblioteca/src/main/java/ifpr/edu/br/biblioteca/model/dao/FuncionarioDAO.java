package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ifpr.edu.br.biblioteca.model.Biblioteca;
import ifpr.edu.br.biblioteca.model.Funcionario;
import ifpr.edu.br.biblioteca.model.Pessoa;


public class FuncionarioDAO {
        public void salvarFuncionario(Funcionario funcionario, Pessoa pessoa, Biblioteca biblioteca){
        String sqlFuncionario = "INSERT INTO funcionario (id_pessoa, id_biblioteca) VALUES (?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psFuncionario = con.prepareStatement(sqlFuncionario);
            psFuncionario.setInt(1, pessoa.getId());
            psFuncionario.setInt(2, biblioteca.getId());
            psFuncionario.executeUpdate();
            System.out.println("Funcionario inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    
    }
}
