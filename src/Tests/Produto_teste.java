package Tests;

import Model.Estoque;
import Model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Produto_teste {

    @Test
    void deve_criar_produto_corretamente() {
        Estoque meuEstoque = new Estoque();
        meuEstoque.setQuantidade(50.0);

        Produto produto = new Produto("Camiseta", "Algodao Pima", 89.90, meuEstoque);

        Assertions.assertEquals("Camiseta", produto.getNome());
        Assertions.assertEquals(89.90, produto.getPreco(), 0.001);
        Assertions.assertEquals(meuEstoque, produto.getEstoque());
    }

    @Test
    void deve_validar_preco_positivo() {
        Estoque estoqueVazio = new Estoque();
        Produto produtoTeste = new Produto("Teste", "Teste", 10.0, estoqueVazio);

        Assertions.assertTrue(produtoTeste.ValidarPreco(0.01));
        Assertions.assertFalse(produtoTeste.ValidarPreco(0.0));
        Assertions.assertFalse(produtoTeste.ValidarPreco(-5.0));
    }

    @Test
    void deve_validar_nome_e_descricao_nao_vazios() {
        Estoque estoqueVazio = new Estoque();
        Produto produtoTeste = new Produto("Teste", "Teste", 10.0, estoqueVazio);

        Assertions.assertTrue(produtoTeste.ValidarnomeDesc("Nome OK", "Desc OK"));
        Assertions.assertFalse(produtoTeste.ValidarnomeDesc("", "Desc OK"));
        Assertions.assertFalse(produtoTeste.ValidarnomeDesc("Nome OK", ""));
    }

    @Test
    void deve_excluir_o_produto() {
        Estoque estoqueVazio = new Estoque();
        Produto produto = new Produto("Fone", "Bluetooth", 200.0, estoqueVazio);

        produto.excluir();

        Assertions.assertFalse(produto.isExiste());
    }
}
