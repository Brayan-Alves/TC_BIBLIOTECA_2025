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
public class Main {
    public static Scanner LER = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarControllers();
        imprimirCabecalho();
        menuDeEntrada();
        
        
        
    }

    public static void criarBiblioteca(){
        limparBuffer();
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("Digite o nome da Biblioteca:");
        biblioteca.setNome(LER.nextLine());
        controllerBiblioteca.cadastrarBiblioteca(biblioteca);
    }

    public static void menuDeEntrada(){
        int x = LER.nextInt();
        limparTerminal();
        if(x == 1){
            BibliotecaDAO dao = new BibliotecaDAO();
            List<Biblioteca> bibliotecas = dao.select();
            for (Biblioteca b : bibliotecas) {
                System.out.println(b.getId() + " - " + b.getNome());
            }
            System.out.println("Selecione a biblioteca desejada:");
            x = LER.nextInt();
        }

    }

    public static void imprimirCabecalho(){
        System.out.println(" _     _ _                            ____            _                 \n" + //
                        "| |   (_) |__  _ __ __ _ _ __ _   _  / ___| _   _ ___| |_ ___ _ __ ___  \n" + //
                        "| |   | | '_ \\| '__/ _` | '__| | | | \\___ \\| | | / __| __/ _ \\ '_ ` _ \\ \n" + //
                        "| |___| | |_) | | | (_| | |  | |_| |  ___) | |_| \\__ \\ ||  __/ | | | | |\n" + //
                        "|_____|_|_.__/|_|  \\__,_|_|   \\__, | |____/ \\__, |___/\\__\\___|_| |_| |_|\n" + //
                        "                              |___/         |___/                       ");
        System.out.println("Bem-Vindo \nO que deseja?\n\n1.Selecionar Biblioteca\n2.Sair\n");
    }

    public static void limparTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void limparBuffer(){
        LER.nextLine();
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