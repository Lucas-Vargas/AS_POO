package Model;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    // O estoque armazena o Produto (chave) e a quantidade (valor)
    private Map<Produto, Double> inventario;

    public Estoque() {
        this.inventario = new HashMap<>();
    }

    /**
     * Adiciona ou atualiza a quantidade de um produto no inventário.
     */
    public void adicionarProduto(Produto produto, double quantidade) {
        if (produto == null || quantidade <= 0) return;
        double quantidadeAtual = inventario.getOrDefault(produto, 0.0);
        inventario.put(produto, quantidadeAtual + quantidade);
    }

    /**
     * Remove uma quantidade do produto, se disponível.
     * Se após a remoção a quantidade for zero, remove a entrada do mapa.
     */
    public void removerProduto(Produto produto, double quantidade) {
        if (produto == null || quantidade <= 0) return;
        double quantidadeAtual = inventario.getOrDefault(produto, 0.0);
        if (quantidadeAtual >= quantidade) {
            double nova = quantidadeAtual - quantidade;
            if (nova <= 0.0) {
                inventario.remove(produto);
            } else {
                inventario.put(produto, nova);
            }
        } else {
            System.err.println("Erro: Não há estoque suficiente para remover " + produto.getNome());
        }
    }

    /**
     * Verifica se a quantidade desejada está disponível em estoque.
     */
    public boolean verificarDisponibilidade(Produto produto, double quantidadeDesejada) {
        if (produto == null || quantidadeDesejada <= 0) return false;
        double quantidadeAtual = inventario.getOrDefault(produto, 0.0);
        return quantidadeAtual >= quantidadeDesejada;
    }

    /**
     * Retorna a quantidade atual de um produto específico no estoque.
     */
    public double getQuantidadeProduto(Produto produto) {
        return inventario.getOrDefault(produto, 0.0);
    }

    /**
     * Exibe o estado atual do estoque.
     */
    public void exibirEstoque() {
        System.out.println("--- INVENTÁRIO ATUAL ---");
        if (inventario.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        for (Map.Entry<Produto, Double> entry : inventario.entrySet()) {
            Produto p = entry.getKey();
            Double q = entry.getValue();
            if (p.isExiste() && q > 0) {
                System.out.println("ID: " + p.getId() + " | Produto: " + p.getNome() + " | Quantidade: " + q);
            }
        }
        System.out.println("------------------------");
    }
}
