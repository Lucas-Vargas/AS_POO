package Model;

import java.util.Objects;

public class Produto {

    // --- Atributos ---
    private String nome;
    private String descricao;
    private String id;
    private double preco;
    private double quantidade; // quantidade "no objeto" (opcional, mantendo)
    private boolean existe;

    // Campo estático para gerar IDs sequenciais (opcional)
    private static int proximoId = 1;

    // --- Construtor (5 argumentos) ---
    public Produto(String nome, String descricao, String id, double preco, double quantidade) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser positivo.");
        }
        if (id == null || id.trim().isEmpty()) {
            // gera um ID automático se não fornecido
            this.id = "PROD" + (proximoId++);
        } else {
            this.id = id;
        }

        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = Math.max(0.0, quantidade);
        this.existe = true;
    }

    // --- Getters ---
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getId() { return id; }
    public double getPreco() { return preco; }
    public double getQuantidade() { return quantidade; }
    public boolean isExiste() { return existe; }

    // --- Setters ---
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio.");
        this.nome = nome;
    }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setPreco(double preco) {
        if (preco <= 0) throw new IllegalArgumentException("Preço deve ser positivo.");
        this.preco = preco;
    }
    public void setQuantidade(double quantidade) {
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        this.quantidade = quantidade;
    }

    public void excluir() {
        this.existe = false;
        System.out.println("Produto " + this.nome + " marcado como excluído.");
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", existe=" + existe +
                '}';
    }

    // IMPORTANTÍSSIMO para usar Produto como chave no Map do Estoque:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
