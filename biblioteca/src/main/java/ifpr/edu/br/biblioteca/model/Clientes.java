package ifpr.edu.br.biblioteca.model;

public class Clientes {
    private int id;
    private Pessoa pessoa;
    public Clientes() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
