package ifpr.edu.br.biblioteca.model;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Clientes cliente;
    public Emprestimo() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Clientes getCliente() {
        return cliente;
    }
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}
