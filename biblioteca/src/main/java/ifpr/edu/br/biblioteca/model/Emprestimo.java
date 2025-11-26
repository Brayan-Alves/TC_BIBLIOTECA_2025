package ifpr.edu.br.biblioteca.model;

import java.sql.Date;

public class Emprestimo {
    private int id;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Livro livro;
    private Usuario usuario;
    private boolean devolvido;
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
    public Usuario getCliente() {
        return usuario;
    }
    public void setCliente(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public Date getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public boolean isDevolvido() {
        return devolvido;
    }
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
