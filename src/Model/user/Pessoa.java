package Model.user;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected boolean ativo;

    public Pessoa() {
        this.ativo = true;
    }

    abstract public void inativar();
    abstract public void EditarDados(int[] opcoes, String[] alteracoes);

    // getters públicos usados pelos testes
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public boolean isAtivo() {
        return ativo;
    }

    // setters protegidos (mantive protected)
    protected void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }
    protected void setNome(String nome) {
        this.nome = nome;
    }
}
