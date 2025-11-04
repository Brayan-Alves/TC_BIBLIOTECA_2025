package ifpr.edu.br.biblioteca.model;

public class Autor{
    private int id;
    private String nome;

    public Autor(String nome) {
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}