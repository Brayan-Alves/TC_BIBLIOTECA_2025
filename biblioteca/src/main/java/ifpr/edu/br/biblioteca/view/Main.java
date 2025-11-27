package ifpr.edu.br.biblioteca.view;

import java.util.Scanner;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import ifpr.edu.br.biblioteca.controller.AutorController;
import ifpr.edu.br.biblioteca.controller.EditoraController;
import ifpr.edu.br.biblioteca.controller.EmprestimoController;
import ifpr.edu.br.biblioteca.controller.LivroController;
import ifpr.edu.br.biblioteca.controller.LivroAutorController;
import ifpr.edu.br.biblioteca.controller.UsuarioController;

import ifpr.edu.br.biblioteca.model.Usuario;
import ifpr.edu.br.biblioteca.model.Livro;
import ifpr.edu.br.biblioteca.model.Emprestimo;
import ifpr.edu.br.biblioteca.model.Autor;
import ifpr.edu.br.biblioteca.model.Editora;

public class Main {
    public static Scanner LER = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarControllers();
        while (true) {
            imprimirCabecalho();
            int x = LER.nextInt();
            if (x == 1) {
                criarConta();
            } else if (x == 2) {
                Usuario u = fazerLogin();
                if (u != null) {
                    menuUsuario(u);
                }
            } else if (x == 3) {
                limparTerminal();
                System.out.print("Digite a senha de administrador: ");
                x = LER.nextInt();
                if (x == 1234) {
                    limparTerminal();
                    System.out.println("Acesso de administrador concedido!");
                    esperar2Segundos();
                    menuAdministrador();
                } else {
                    limparTerminal();
                    System.out.println("Senha incorreta!");
                    esperar2Segundos();
                }
            } else {
                limparTerminal();
                System.out.println("Finalizando...");
                esperar2Segundos();
                System.exit(0);
            }

        }

    }

    public static void menuAdministrador() {
        limparTerminal();
        System.out.println("Bem-vindo, Administrador!\n");
        esperar2Segundos();
        System.out.println(
                "O que deseja fazer?\n\n1.Gerenciar Autores\n2.Gerenciar Editoras\n3.Gerenciar Livros\n4.Gerenciar Usuários\n\n5.Logout");
        int x = LER.nextInt();
        limparTerminal();
        switch (x) {
            case 1:
                System.out.println("Gerenciar Autores\n");
                System.out
                        .println("1.Cadastrar Autor\n2.Listar Autores\n3.Atualizar Autor\n4.Excluir Autor\n\n5.Voltar");
                int k = LER.nextInt();
                switch (k) {
                    case 1:
                        limparTerminal();
                        System.out.println("---- Cadastrar Autor ----\n");
                        Autor a = new Autor();
                        System.out.print("Nome: ");
                        limparBuffer();
                        a.setNome(LER.nextLine());
                        controllerAutor.cadastrarAutor(a);
                        limparTerminal();
                        System.out.println("Autor cadastrado com sucesso!");
                        esperar2Segundos();
                        limparTerminal();
                        break;
                    case 2:
                        limparTerminal();
                        List<Autor> autores = controllerAutor.listarAutores();
                        limparTerminal();
                        System.out.println("Lista de Autores:");
                        for (Autor autor : autores) {
                            System.out.println("ID: " + autor.getId() + " | Nome: " + autor.getNome());
                        }
                        System.out.print("Pressione Enter para continuar...");
                        limparBuffer();
                        LER.nextLine();
                        limparTerminal();
                        break;
                    case 3:
                        limparTerminal();
                        limparBuffer();
                        System.out.print("ID do Autor a ser atualizado: ");
                        int idAtualizar = LER.nextInt();
                        limparBuffer();
                        System.out.print("Novo nome do Autor: ");
                        String novoNome = LER.nextLine();
                        controllerAutor.atualizarAutor(novoNome, idAtualizar);
                        limparTerminal();
                        System.out.println("Autor atualizado com sucesso!");
                        esperar2Segundos();
                        limparTerminal();
                        break;
                    case 4:
                        limparTerminal();
                        System.out.print("ID do Autor a ser excluído: ");
                        int idExcluir = LER.nextInt();
                        controllerAutor.excluirAutor(idExcluir);
                        limparTerminal();
                        System.out.println("Autor excluído com sucesso!");
                        esperar2Segundos();
                        limparTerminal();
                        break;
                    case 5:
                        limparTerminal();
                        System.out.println("Voltando...");
                        esperar2Segundos();
                        menuAdministrador();
                        break;
                    default:
                        limparTerminal();
                        System.out.println("Opção inválida!");
                        esperar2Segundos();
                        break;
                }
                menuAdministrador();
                break;
            case 2:
                System.out.println("Gerenciar Editoras\n");
                System.out.println(
                        "1.Cadastrar Editora\n2.Listar Editoras\n3.Atualizar Editora\n4.Excluir Editora\n\n5.Voltar");
                int j = LER.nextInt();
                switch (j) {
                    case 1:
                        Editora e = new Editora();
                        System.out.print("Nome: ");
                        limparBuffer();
                        e.setNome(LER.nextLine());
                        controllerEditora.cadastrarEditora(e);
                        limparTerminal();
                        System.out.println("Editora cadastrada com sucesso!");
                        esperar2Segundos();
                        break;
                    case 2:
                        List<Editora> editoras = controllerEditora.listarEditora();
                        limparTerminal();
                        System.out.println("Lista de Editoras:");
                        for (Editora editora : editoras) {
                            System.out.println("ID: " + editora.getId() + " | Nome: " + editora.getNome());
                        }
                        System.out.print("Pressione Enter para continuar...");
                        limparBuffer();
                        LER.nextLine();
                        break;
                    case 3:
                        System.out.print("ID da Editora a ser atualizada: ");
                        int id = LER.nextInt();
                        limparBuffer();
                        System.out.print("Novo nome da Editora: ");
                        String nome = LER.nextLine();
                        controllerEditora.atualizarEditora(nome, id);
                        limparTerminal();
                        System.out.println("Editora atualizada com sucesso!");
                        esperar2Segundos();
                        break;
                    case 4:
                        System.out.println("ID da Editora a ser excluída: ");
                        int idEx = LER.nextInt();
                        controllerEditora.excluirEditora(idEx);
                        limparTerminal();
                        System.out.println("Editora excluída com sucesso!");
                        esperar2Segundos();
                        break;
                    case 5:
                        limparTerminal();
                        System.out.println("Voltando...");
                        esperar2Segundos();
                        menuAdministrador();
                        break;
                    default:
                        limparTerminal();
                        System.out.println("Opção inválida!");
                        esperar2Segundos();
                        break;
                }
                menuAdministrador();
                break;
            case 3:
                System.out.println("Gerenciar Livros\n");
                System.out
                        .println("1.Cadastrar Livro\n2.Listar Livros\n3.Atualizar Livro\n4.Excluir Livro\n\n5.Voltar");
                int m = LER.nextInt();
                switch (m) {
                    case 1:
                        Livro l = new Livro();
                        System.out.print("Título: ");
                        limparBuffer();
                        l.setTitulo(LER.nextLine());
                        System.out.println("Autor(es): ");
                        while (true) {
                            System.out.print("Digite o ID do Autor (ou 0 para finalizar): ");
                            for (Autor a : controllerAutor.listarAutores()) {
                                System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome());
                            }
                            int idAutor = LER.nextInt();
                            if (idAutor == 0) {
                                break;
                            }
                            Autor autor = new Autor();
                            for (Autor a1 : controllerAutor.listarAutores()) {
                                if (a1.getId() == idAutor) {
                                    autor = a1;
                                    break;
                                }
                            }
                            if (autor != null) {
                                l.addAutor(autor);
                            } else {
                                System.out.println("Autor com ID " + idAutor + " não encontrado.");
                            }
                        }
                        
                        System.out.print("Ano: ");
                        l.setAno(LER.nextInt());
                        System.out.print("ID da Editora: ");
                        int idEditora = LER.nextInt();
                        Editora editora = null;
                        for (Editora ed : controllerEditora.listarEditora()) {
                            if (ed.getId() == idEditora) {
                                editora = ed;
                                break;
                            }
                        }
                        l.setEditora(editora);
                        controllerLivro.cadastrarLivro(l);
                    case 2:
                        limparTerminal();
                        for (Livro livro : controllerLivro.listarTodos()) {
                            String nomesAutores = "";
                            for (int i = 0; i < livro.getAutores().size(); i++) {
                                if (i == livro.getAutores().size() - 1) {
                                    nomesAutores += livro.getAutores().get(i).getNome();
                                } else {
                                    nomesAutores += livro.getAutores().get(i).getNome() + ", ";
                                }
                            }
                            System.out.println("ID: " + livro.getId() + " | Título: " + livro.getTitulo()
                                    + " | Autores: " + nomesAutores + " | Ano: "
                                    + livro.getAno() + " | Editora: " + livro.getEditora().getNome());
                        }
                        System.out.print("Pressione Enter para continuar...");
                        limparBuffer();
                        LER.nextLine();
                        break;
                    case 3:
                        Livro lAtu = new Livro();
                        System.out.print("ID do Livro a ser atualizado: ");
                        lAtu.setId(LER.nextInt());
                        limparBuffer();
                        System.out.print("Novo Título: ");
                        lAtu.setTitulo(LER.nextLine());
                        System.out.print("Novo Ano: ");
                        lAtu.setAno(LER.nextInt());
                        controllerLivro.atualizarLivro(lAtu);
                        limparTerminal();
                    case 4:
                        System.out.println("ID do Livro a ser excluído: ");
                        int idEx = LER.nextInt();
                        controllerLivro.deletarLivro(idEx);
                        limparTerminal();
                        System.out.println("Livro excluído com sucesso!");
                        esperar2Segundos();
                    case 5:
                        limparTerminal();
                        System.out.println("Voltando...");
                        esperar2Segundos();
                        menuAdministrador();
                    default:
                        limparTerminal();
                        System.out.println("Opção inválida!");
                        esperar2Segundos();
                        break;
                }
                menuAdministrador();
                break;
            case 4:
                System.out.println("Gerenciar Usuários\n");
                System.out.println(
                        "1.Cadastrar Usuário\n2.Listar Usuários\n3.Atualizar Usuário\n4.Excluir Usuário\n\n5.Voltar");
                int n = LER.nextInt();
                switch (n) {
                    case 1:
                        Usuario u = new Usuario();
                        System.out.print("Nome: ");
                        limparBuffer();
                        u.setNome(LER.nextLine());
                        System.out.print("Email: ");
                        u.setEmail(LER.nextLine());
                        System.out.print("Senha: ");
                        u.setSenha(LER.nextLine());
                        System.out.print("Endereço: ");
                        u.setEndereco(LER.nextLine());
                        controllerUsuario.cadastrarUsuario(u);
                        limparTerminal();
                        System.out.println("Usuário cadastrado com sucesso!");
                        esperar2Segundos();
                        break;
                    case 2:
                        List<Usuario> usuarios = controllerUsuario.listarUsuarios();
                        for (Usuario usuario : usuarios) {
                            System.out.println("ID: " + usuario.getId() + " | Nome: " + usuario.getNome() + " | Email: "
                                    + usuario.getEmail() + " | Endereço: " + usuario.getEndereco());
                        }
                        System.out.print("Pressione Enter para continuar...");
                        limparBuffer();
                        LER.nextLine();
                        break;
                    case 3:
                        Usuario uAtu = new Usuario();
                        System.out.print("ID do Usuário a ser atualizado: ");
                        uAtu.setId(LER.nextInt());
                        limparBuffer();
                        System.out.print("Novo Nome: ");
                        uAtu.setNome(LER.nextLine());
                        System.out.print("Novo Email: ");
                        uAtu.setEmail(LER.nextLine());
                        System.out.print("Nova Senha: ");
                        uAtu.setSenha(LER.nextLine());
                        System.out.print("Novo Endereço: ");
                        uAtu.setEndereco(LER.nextLine());
                        controllerUsuario.atualizarUsuario(uAtu);
                        limparTerminal();
                        System.out.println("Usuário atualizado com sucesso!");
                        esperar2Segundos();
                        break;
                    case 4:
                        System.out.print("ID do Usuário a ser excluído: ");
                        int idUsuEx = LER.nextInt();
                        controllerUsuario.excluirUsuario(idUsuEx);
                        limparTerminal();
                        System.out.println("Usuário excluído com sucesso!");
                        esperar2Segundos();
                        break;
                    case 5:
                        limparTerminal();
                        System.out.println("Voltando...");
                        esperar2Segundos();
                        menuAdministrador();
                    default:
                        limparTerminal();
                        System.out.println("Opção inválida!");
                        esperar2Segundos();
                        break;
                }
                menuAdministrador();
                break;
            case 5:
                System.out.println("Fazendo logout...");
                esperar2Segundos();
                return;
            default:
                System.out.println("Opção inválida!");
                esperar2Segundos();
                break;
        }

    }

    public static void menuUsuario(Usuario u) {
        limparTerminal();
        System.out.println("Bem-vindo, " + u.getNome() + "!");
        esperar2Segundos();
        System.out.println(
                "\nO que deseja fazer?\n\n1.Ver livros disponíveis\n2.Ver meus empréstimos\n3.Fazer empréstimo\n4.Devolver livro\n\n5.Logout");
        int x = LER.nextInt();
        switch (x) {
            case 1:
                limparTerminal();
                for (Livro livro : controllerLivro.listarTodos()) {
                    String nomesAutores = "";
                    for (int i = 0; i < livro.getAutores().size(); i++) {
                        if (i == livro.getAutores().size() - 1) {
                            nomesAutores += livro.getAutores().get(i).getNome();
                        } else {
                            nomesAutores += livro.getAutores().get(i).getNome() + ", ";
                        }
                    }
                    System.out.println("ID: " + livro.getId() + " | Título: " + livro.getTitulo() + " | Autores: "
                            + nomesAutores + " | Ano: "
                            + livro.getAno() + " | Editora: " + livro.getEditora().getNome());
                }
                System.out.print("Pressione Enter para continuar...");
                limparBuffer();
                LER.nextLine();
                break;
            case 2:
                for (Emprestimo emp : controllerEmprestimo.listarEmprestimosPorUsuario(u.getId())) {
                    System.out.println("Empréstimo ID: " + emp.getId() + " | Livro: " + emp.getLivro().getTitulo()
                            + " | Data Empréstimo: " + emp.getDataEmprestimo() + " | Data Devolução: "
                            + emp.getDataDevolucao() + " | Devolvido: " + (emp.isDevolvido() ? "Sim" : "Não"));
                }
                System.out.print("Pressione Enter para continuar...");
                limparBuffer();
                LER.nextLine();
                break;
            case 3:
                Emprestimo emp = new Emprestimo();
                emp.setUsuario(u);
                System.out.println("Digite o ID do livro que deseja emprestar:");
                List<Livro> livros = controllerLivro.listarTodos();
                for (Livro livro : livros) {
                    System.out.println("ID: " + livro.getId() + " | Título: " + livro.getTitulo());
                }
                int idLivro = LER.nextInt();
                Livro livroSelecionado = null;
                for (Livro livro : controllerLivro.listarTodos()) {
                    if (livro.getId() == idLivro) {
                        livroSelecionado = livro;
                        break;
                    }
                }
                emp.setLivro(livroSelecionado);
                emp.setDataEmprestimo(Date.valueOf(LocalDate.now()));
                emp.setDevolvido(false);
                break;
            case 4:
                List<Emprestimo> emprestimosUsuario = controllerEmprestimo.listarEmprestimosPorUsuario(u.getId());
                System.out.println("Seus empréstimos:");
                for (Emprestimo emprestimo : emprestimosUsuario) {
                    System.out.println(
                            "ID Empréstimo: " + emprestimo.getId() + " | Livro: " + emprestimo.getLivro().getTitulo()
                                    + " | Devolvido: " + (emprestimo.isDevolvido() ? "Sim" : "Não"));
                }
                System.out.println("Digite o ID do empréstimo que deseja devolver:");
                int idEmprestimo = LER.nextInt();
                controllerEmprestimo.devolverEmprestimo(idEmprestimo, LocalDate.now());
                break;
            case 5:
                limparTerminal();
                System.out.println("Fazendo logout...");
                esperar2Segundos();
                return;
            default:
                System.out.println("Opção inválida!");
                esperar2Segundos();
                break;
        }
        menuUsuario(u);
    }

    public static Usuario fazerLogin() {
        limparBuffer();
        limparTerminal();
        System.out.println("---- Login ----\n");
        System.out.print("Email: ");
        String email = LER.nextLine();
        System.out.print("Senha: ");
        String senha = LER.nextLine();

        Usuario u = controllerUsuario.login(email, senha);
        if (u != null) {
            limparTerminal();
            System.out.println("Login realizado com sucesso!");
            esperar2Segundos();
            return u;
        } else {
            limparTerminal();
            System.out.println("Falha no login!");
            esperar2Segundos();
            return null;
        }
    }

    public static void criarConta() {
        limparBuffer();
        limparTerminal();
        System.out.println("---- Criar Conta ----\n");
        Usuario u = new Usuario();
        System.out.print("Nome: ");
        u.setNome(LER.nextLine());
        System.out.print("Email: ");
        u.setEmail(LER.nextLine());
        System.out.print("Senha: ");
        u.setSenha(LER.nextLine());
        System.out.print("Endereço: ");
        u.setEndereco(LER.nextLine());

        controllerUsuario.cadastrarUsuario(u);
        limparTerminal();
        System.out.println("\nUsuário cadastrado com sucesso!");
        esperar2Segundos();
        return;
    }

    public static void imprimirCabecalho() {
        limparTerminal();
        System.out.println("____  _ _     _ _       _                   ___ _____ \n" + //
                "| __ )(_) |__ | (_) ___ | |_ ___  ___ __ _  |_ _|  ___|\n" + //
                "|  _ \\| | '_ \\| | |/ _ \\| __/ _ \\/ __/ _` |  | || |_   \n" + //
                "| |_) | | |_) | | | (_) | ||  __/ (_| (_| |  | ||  _|  \n" + //
                "|____/|_|_.__/|_|_|\\___/ \\__\\___|\\___\\__,_| |___|_|    ");
        System.out.println(
                "\nBem-Vindo(a) \n\nO que deseja?\n\n1.Criar Conta\n2.Login\n3.Entrar como Administrador\n\n4.Sair\n");
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
        controllerEditora = new EditoraController();
        controllerEmprestimo = new EmprestimoController();
        controllerLivroAutor = new LivroAutorController();
        controllerLivro = new LivroController();
        controllerUsuario = new UsuarioController();
    }

    static AutorController controllerAutor;
    static EditoraController controllerEditora;
    static EmprestimoController controllerEmprestimo;
    static LivroAutorController controllerLivroAutor;
    static LivroController controllerLivro;
    static UsuarioController controllerUsuario;
}