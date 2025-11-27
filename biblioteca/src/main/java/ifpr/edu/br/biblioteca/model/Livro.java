package ifpr.edu.br.biblioteca.model;

import java.util.List;

public class Livro {
    private int id;
    private String titulo;
    private List<Autor> autores;
    private int ano;
    private Editora editora;
    public Livro() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Editora getEditora() {
        return editora;
    }
    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public List<Autor> getAutores() {
        return autores;
    }
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }
}
