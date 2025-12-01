package Tests;

import Model.Estoque;
import Model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Produto_teste {

    @Test
    void deve_criar_produto_corretamente() {
        // CORREÇÃO: O construtor de Produto AGORA TEM 5 ARGUMENTOS:
        // (String nome, String descricao, String id, double preco, double quantidade)

        Produto produto = new Produto("Camiseta", "Algodao Pima", "CAM001", 89.90, 10.0);

        Assertions.assertEquals("Camiseta", produto.getNome());
        Assertions.assertEquals("CAM001", produto.getId()); // Testar o ID
        Assertions.assertEquals(89.90, produto.getPreco(), 0.001);

        // CORREÇÃO: Testar a quantidade, pois o objeto Estoque não faz mais parte do Produto.
        Assertions.assertEquals(10.0, produto.getQuantidade(), 0.001);
    }

    @Test
    void deve_atualizar_quantidade_do_produto() {
        // O produto em si deve ser capaz de ter sua quantidade modificada.
        Produto produto = new Produto("Camiseta", "Algodao Pima", "CAM001", 89.90, 10.0);

        produto.setQuantidade(5.0);
        Assertions.assertEquals(5.0, produto.getQuantidade(), 0.001);

        // Testar a modificação:
        produto.setQuantidade(produto.getQuantidade() + 15.0);
        Assertions.assertEquals(20.0, produto.getQuantidade(), 0.001);
    }

    // REMOVIDO: O teste 'deve_validar_preco_positivo' e 'deve_validar_nome_e_descricao_nao_vazios'
    // A lógica de validação deve ser feita no Controller/View antes de instanciar o Model.

    @Test
    void deve_excluir_o_produto() {
        // CORREÇÃO: Construtor ajustado para 5 argumentos.
        Produto produto = new Produto("Fone", "Bluetooth", "FONE01", 200.0, 5.0);

        produto.excluir();

        Assertions.assertFalse(produto.isExiste());
    }
}