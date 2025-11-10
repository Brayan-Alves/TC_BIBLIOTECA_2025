package ifpr.edu.br.biblioteca.view;

import ifpr.edu.br.biblioteca.controller.AutorController;
import ifpr.edu.br.biblioteca.controller.BibliotecaController;
import ifpr.edu.br.biblioteca.model.Autor;
import ifpr.edu.br.biblioteca.model.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome("Biblioteca Central");
        BibliotecaController controllerBiblioteca = new BibliotecaController();
        controllerBiblioteca.cadastrarBiblioteca(biblioteca);


        Autor autor = new Autor();
        autor.setNome("Olavo de Carvalho");
        AutorController controllerAutor = new AutorController();
        controllerAutor.cadastrarAutor(autor);
    }
}