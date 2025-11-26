package ifpr.edu.br.biblioteca.model;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
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
    
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
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
}
