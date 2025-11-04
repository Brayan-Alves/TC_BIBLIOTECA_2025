package ifpr.edu.br.biblioteca.model;

public class Funcionario {
    private int id;
    private Pessoa pessoa;
    public Funcionario() {
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
