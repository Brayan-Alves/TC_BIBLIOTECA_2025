package ifpr.edu.br.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import ifpr.edu.br.biblioteca.model.Funcionario;


public class FuncionarioDAO {
    public static Scanner LER = new Scanner(System.in);
        public void salvarFuncionario(Funcionario funcionario){
        String sqlFuncionario = "INSERT INTO funcionario (nome, cpf, email, senha) VALUES (?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psFuncionario = con.prepareStatement(sqlFuncionario);
            psFuncionario.setString(1, funcionario.getNome());
            psFuncionario.setString(2, funcionario.getCpf());
            psFuncionario.setString(3, funcionario.getEmail());
            psFuncionario.setString(4, funcionario.getSenha());
            psFuncionario.executeUpdate();
            System.out.println("Funcionario inserido com sucesso!");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 
    
    }
}
