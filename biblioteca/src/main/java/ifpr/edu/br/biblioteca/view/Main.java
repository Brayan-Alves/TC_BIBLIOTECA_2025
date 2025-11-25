package ifpr.edu.br.biblioteca.view;

import java.util.Scanner;

import ifpr.edu.br.biblioteca.controller.AutorController;
import ifpr.edu.br.biblioteca.controller.ClienteController;
import ifpr.edu.br.biblioteca.controller.EditoraController;
import ifpr.edu.br.biblioteca.controller.EmprestimoController;
import ifpr.edu.br.biblioteca.controller.FuncionarioController;
import ifpr.edu.br.biblioteca.controller.GerenteController;
import ifpr.edu.br.biblioteca.controller.LivroController;

import ifpr.edu.br.biblioteca.model.Cliente;

public class Main {
    public static Scanner LER = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarControllers();
        while (true) {
            imprimirCabecalho();
            int x = LER.nextInt();
            //menuLogin();
            if (x == 1) {
                criarConta();
            } else if (x == 2) {
                //fazerLogin();

            } else {
                limparTerminal();
                System.out.println("Finalizando...");
                esperar2Segundos();
                System.exit(0);
            }

        }

    }

    // public static int menuLogin(){
    //     System.out.print("Fazer Login como:\n\n1.Cliente\n2.Funcionário\n3.Gerente\n\n");
    //     int x = LER.nextInt();
    //     retur 

    // }

    public static void fazerLogin(int l) {
        limparBuffer();
        limparTerminal();
        System.out.print("Email: ");
        String email = LER.next();
        System.out.print("Senha: ");
        String senha = LER.next();
        System.out.println();
        limparTerminal();
        if(l == 1){
            if (controllerCliente.autenticar(email, senha)) {
                System.out.println("Login Válido!");
                esperar2Segundos();
                return;
            } else {
                System.out.println("Login Inválido!");
                esperar2Segundos();
                return;
            }
        }else if(l == 2){
            if (controllerFuncionario.autenticar(email, senha)) {
                System.out.println("Login Válido!");
                esperar2Segundos();
                return;
            } else {
                System.out.println("Login Inválido!");
                esperar2Segundos();
                return;
            }
        }else if(l == 2){
            if (controllerGerente.autenticar(email, senha)) {
                System.out.println("Login Válido!");
                esperar2Segundos();
                return;
            } else {
                System.out.println("Login Inválido!");
                esperar2Segundos();
                return;
            }
        }

    }

    public static void criarConta() {
        limparTerminal();
        System.out.println("Deseja criar conta como:\n\n1.Cliente\n\n2.Voltar");
        int n = LER.nextInt();
        limparBuffer();
        limparTerminal();
        if(n == 1){ // cliente
            Cliente c = new Cliente();
            System.out.print("Nome: ");
            c.setNome(LER.nextLine());
            System.out.print("CPF: ");
            c.setCpf(LER.nextLine());
            System.out.print("Email: ");
            c.setEmail(LER.nextLine());
            System.out.print("Senha: ");
            c.setSenha(LER.nextLine());
            limparTerminal();
            controllerCliente.cadastrarCliente(c);
            System.out.println("Cadastro Concluido!");
            esperar2Segundos();
            limparTerminal();
        }else if(n == 2){
            limparTerminal();
            return;
        }
        

    }

    public static void imprimirCabecalho() {
        limparTerminal();
        System.out.println("____  _ _     _ _       _                   ___ _____ \n" + //
                "| __ )(_) |__ | (_) ___ | |_ ___  ___ __ _  |_ _|  ___|\n" + //
                "|  _ \\| | '_ \\| | |/ _ \\| __/ _ \\/ __/ _` |  | || |_   \n" + //
                "| |_) | | |_) | | | (_) | ||  __/ (_| (_| |  | ||  _|  \n" + //
                "|____/|_|_.__/|_|_|\\___/ \\__\\___|\\___\\__,_| |___|_|    ");
        System.out.println("\nBem-Vindo(a) \n\nO que deseja?\n\n1.Criar Conta\n2.Login\n\n3.Sair\n");
    }

    public static void limparTerminal() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
        System.out.print("\033\143");
    }

    public static void limparBuffer() {
        LER.nextLine();
    }

    public static void esperar2Segundos() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void iniciarControllers() {
        controllerAutor = new AutorController();
        controllerCliente = new ClienteController();
        controllerEditora = new EditoraController();
        controllerEmprestimo = new EmprestimoController();
        controllerFuncionario = new FuncionarioController();
        controllerGerente = new GerenteController();
        controllerLivro = new LivroController();
    }

    static AutorController controllerAutor;
    static ClienteController controllerCliente;
    static EditoraController controllerEditora;
    static EmprestimoController controllerEmprestimo;
    static FuncionarioController controllerFuncionario;
    static GerenteController controllerGerente;
    static LivroController controllerLivro;
}