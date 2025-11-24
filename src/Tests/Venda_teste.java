package Tests;

import Model.Estoque;
import Model.Produto;
import Model.Venda;
import Model.user.Cliente;
import Model.user.Vendedor;
import Model.Loja;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Venda_teste {

    @Test
    void deve_criar_venda_e_diminuir_estoque() {
        Loja lojaTeste = new Loja();
        Cliente clienteTeste = new Cliente("Ana", "111", "999", "ana@email.com");
        Vendedor vendedorTeste = new Vendedor("Beto", "222", 0.05, 1500.0, lojaTeste);

        Estoque estoqueTeste = new Estoque();
        estoqueTeste.setQuantidade(5.0);
        Produto produto1 = new Produto("Caneta", "Azul", 5.0, estoqueTeste);
        Produto produto2 = new Produto("Caderno", "Pena", 20.0, estoqueTeste);
        Produto[] produtos = {produto1, produto2};

        Venda vendaTeste = new Venda(clienteTeste, vendedorTeste, produtos, 1);

        Assertions.assertTrue(vendaTeste.isExiste());
        Assertions.assertEquals(25.0, vendaTeste.getValor(), 0.001);
        Assertions.assertEquals(3.0, estoqueTeste.getQuantidade(), 0.001);
    }

    @Test
    void deve_devolver_e_aumentar_estoque() {
        Loja lojaTeste = new Loja();
        Cliente clienteTeste = new Cliente("Ana", "111", "999", "ana@email.com");
        Vendedor vendedorTeste = new Vendedor("Beto", "222", 0.05, 1500.0, lojaTeste);

        Estoque estoqueTeste = new Estoque();
        estoqueTeste.setQuantidade(5.0);
        Produto produto1 = new Produto("Caneta", "Azul", 5.0, estoqueTeste);
        Produto produto2 = new Produto("Caderno", "Pena", 20.0, estoqueTeste);
        Produto[] produtos = {produto1, produto2};
        Venda vendaTeste = new Venda(clienteTeste, vendedorTeste, produtos, 1);
        double estoqueAntesDaDevolucao = estoqueTeste.getQuantidade();

        vendaTeste.devolver();

        Assertions.assertTrue(vendaTeste.isDevolvido());
        Assertions.assertEquals(estoqueAntesDaDevolucao + 2.0, estoqueTeste.getQuantidade(), 0.001);
    }

    @Test
    void deve_excluir_venda() {
        Venda vendaTeste = new Venda(null, null, new Produto[0], 1);
        vendaTeste.excluir();
        Assertions.assertFalse(vendaTeste.isExiste());
    }
}
