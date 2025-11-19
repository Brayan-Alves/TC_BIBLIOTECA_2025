package ifpr.edu.br.biblioteca.view;

import java.util.Scanner;
import java.util.List;

import ifpr.edu.br.biblioteca.controller.AutorController;
import ifpr.edu.br.biblioteca.controller.BibliotecaController;
import ifpr.edu.br.biblioteca.controller.ClienteController;
import ifpr.edu.br.biblioteca.controller.EditoraController;
import ifpr.edu.br.biblioteca.controller.EmprestimoController;
import ifpr.edu.br.biblioteca.controller.FuncionarioController;
import ifpr.edu.br.biblioteca.controller.GerenteController;
import ifpr.edu.br.biblioteca.controller.LivroController;

import ifpr.edu.br.biblioteca.model.dao.BibliotecaDAO;

import ifpr.edu.br.biblioteca.model.Biblioteca;
import ifpr.edu.br.biblioteca.model.Pessoa;
public class Main {
    public static Scanner LER = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarControllers();
        while (true) {
            imprimirCabecalho();
            mostrarMenuPrincipal();
        }
        
        
        
    }

    public static void criarBiblioteca(){
        limparBuffer();
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("Digite o nome da Biblioteca:");
        biblioteca.setNome(LER.nextLine());
        limparTerminal();
        controllerBiblioteca.cadastrarBiblioteca(biblioteca);
    }

    public static void menuDeLogin(Biblioteca biblioteca){
        limparTerminal();
        System.out.println("Bem-Vindo á " + biblioteca.getNome() + "!\n");
        System.out.println("O que deseja?\n\n1.Fazer Login\n2.Criar Conta\n3.Voltar\n4.Sair");
        int x = LER.nextInt();
        if(x == 1){
            fazerLogin();
        }else if(x == 2){
            //criarConta();
        }else if(x == 3){
            System.out.println("Voltando...");
            esperar2Segundos();
            return;
        }else{
            System.out.println("Finalizando...");
            esperar2Segundos();
            System.exit(0);
        }
    }

    public static void fazerLogin(){
        limparTerminal();
        System.out.println("Deseja fazer Login como: \n\n1.Cliente\n2.Funcionário\n3.Gerente\n\n");
        int x = LER.nextInt();
        if(x == 1){
            System.out.print("Email: ");
            String email = LER.next();
            System.out.println("\nSenha: ");
            String senha = LER.next();
            System.out.println();
            Pessoa p = controllerCliente.logarCliente(email, senha);
            limparTerminal();
            if(p == null){
                System.out.println("Login Inválido!");
                esperar2Segundos();
                return;
            }else{
                System.out.println("Login Aceito!");
                esperar2Segundos();
                return;
            }
        }

        
    }

    public static void mostrarMenuPrincipal(){
        int x = LER.nextInt();
        limparTerminal();
        if(x == 1){
            BibliotecaDAO dao = new BibliotecaDAO();
            List<Biblioteca> bibliotecas = dao.mostrarBibliotecas();
            if(bibliotecas.isEmpty()){
                limparTerminal();
                System.out.println("Nenhuma biblioteca registrada!");
                esperar2Segundos();
                return;
            }
            for (Biblioteca b : bibliotecas) {
                System.out.println(b.getId() + " - " + b.getNome());
            }
            System.out.println("Selecione a biblioteca desejada:");
            x = LER.nextInt();
            menuDeLogin(bibliotecas.get(x-1));
        }else if(x == 2){
            criarBiblioteca();
            esperar2Segundos();
            return;
        }else if(x == 3){
            System.out.println("Finalizando...");
            esperar2Segundos();
            System.exit(0);
        }else{
            System.out.println("Número Inválido!");
            esperar2Segundos();
            return;
        }

    }

    public static void imprimirCabecalho(){
        limparTerminal();
        System.out.println(" _     _ _                            ____            _                 \n" + //
                        "| |   (_) |__  _ __ __ _ _ __ _   _  / ___| _   _ ___| |_ ___ _ __ ___  \n" + //
                        "| |   | | '_ \\| '__/ _` | '__| | | | \\___ \\| | | / __| __/ _ \\ '_ ` _ \\ \n" + //
                        "| |___| | |_) | | | (_| | |  | |_| |  ___) | |_| \\__ \\ ||  __/ | | | | |\n" + //
                        "|_____|_|_.__/|_|  \\__,_|_|   \\__, | |____/ \\__, |___/\\__\\___|_| |_| |_|\n" + //
                        "                              |___/         |___/                       ");
        System.out.println("Bem-Vindo \nO que deseja?\n\n1.Selecionar Biblioteca\n2.Adicionar Biblioteca\n3.Sair\n");
    }

    public static void limparTerminal() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
        System.out.print("\033\143");
    }

    public static void limparBuffer(){
        LER.nextLine();
    }

    public static void esperar2Segundos(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void iniciarControllers(){
        controllerAutor = new AutorController();
        controllerBiblioteca = new BibliotecaController();
        controllerCliente = new ClienteController();
        controllerEditora = new EditoraController();
        controllerEmprestimo = new EmprestimoController();
        controllerFuncionario = new FuncionarioController();
        controllerGerente = new GerenteController();
        controllerLivro = new LivroController();
    }

    static AutorController controllerAutor;
    static BibliotecaController controllerBiblioteca;
    static ClienteController controllerCliente;
    static EditoraController controllerEditora;
    static EmprestimoController controllerEmprestimo;
    static FuncionarioController controllerFuncionario;
    static GerenteController controllerGerente;
    static LivroController controllerLivro;
}