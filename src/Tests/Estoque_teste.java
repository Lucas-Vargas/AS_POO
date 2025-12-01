package Tests;

import Model.Estoque;
import Model.Produto; // Importar a classe Produto
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Estoque_teste {

    @Test
    void deve_adicionar_e_verificar_disponibilidade_de_produtos() {
        Estoque meuEstoque = new Estoque();

        // 1. Criar produtos para teste (usando o construtor corrigido)
        Produto produtoA = new Produto("Monitor LED", "24 polegadas", "MON001", 850.00, 0.0);
        Produto produtoB = new Produto("Teclado Mecânico", "Gamer RGB", "TEC002", 300.00, 0.0);

        // 2. Adicionar quantidades
        meuEstoque.adicionarProduto(produtoA, 10.0);
        meuEstoque.adicionarProduto(produtoB, 5.0);

        // 3. Adicionar mais quantidade ao produto A
        meuEstoque.adicionarProduto(produtoA, 5.0);

        // 4. Testar a disponibilidade (deve ser 15)
        Assertions.assertTrue(meuEstoque.verificarDisponibilidade(produtoA, 15.0));

        // 5. Testar indisponibilidade
        Assertions.assertFalse(meuEstoque.verificarDisponibilidade(produtoB, 6.0));
    }

    @Test
    void deve_remover_produto_e_tratar_estoque_zero() {
        Estoque meuEstoque = new Estoque();
        Produto produtoA = new Produto("Monitor LED", "24 polegadas", "MON001", 850.00, 0.0);

        meuEstoque.adicionarProduto(produtoA, 2.0);

        // 1. Remover uma quantidade
        meuEstoque.removerProduto(produtoA, 1.0);
        Assertions.assertTrue(meuEstoque.verificarDisponibilidade(produtoA, 1.0)); // Resta 1

        // 2. Remover a quantidade restante (deve remover o produto do Map)
        meuEstoque.removerProduto(produtoA, 1.0);

        // 3. Verificar se o produto não está mais no estoque (disponibilidade deve ser false)
        Assertions.assertFalse(meuEstoque.verificarDisponibilidade(produtoA, 0.1));
    }
}