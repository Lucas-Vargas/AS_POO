package Model;

public class Produto {
    private String nome, descricao;
    private double preco;
    private Estoque estoque;
    private boolean existe = true;

    public Produto(String nome, String descricao, double preco, Estoque estoque){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.existe = true;
    }

    public boolean ValidarPreco(double preco) {
        return preco > 0;
    }

    // Ajustei a assinatura para (nome, descricao) para bater com os testes
    public boolean ValidarnomeDesc(String nome, String descricao) {
        if(nome == null || descricao == null) return false;
        return !nome.isEmpty() && !descricao.isEmpty();
    }

    public double getPreco() {
        return preco;
    }
    public Estoque getEstoque() {
        return estoque;
    }
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    public void excluir() {
        this.existe = false;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // getters adicionados
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public boolean isExiste() {
        return existe;
    }
}
