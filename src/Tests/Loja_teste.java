package Tests;

import Model.Estoque;
import Model.Loja;
import Model.Produto;
import Model.Venda;
import Model.user.Cliente;
import Model.user.Vendedor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Loja_teste {

    private Loja lojaTeste;
    private Produto p1;
    private Produto p2;
    private Vendedor vendedor;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        lojaTeste = new Loja();
        p1 = new Produto("Laptop", "Alto Desempenho", "LT001", 3000.00, 10.0);
        p2 = new Produto("Mouse", "Ergonômico", "MSE002", 100.00, 50.0);

        vendedor = new Vendedor("Ana Silva", "12345678900", 0.05, 2000.0, lojaTeste);
        cliente = new Cliente("Carlos Lima", "98765432100", "21999999999", "carlos@mail.com");

        lojaTeste.adicionarVendedor(vendedor);

        lojaTeste.getEstoque().adicionarProduto(p1, p1.getQuantidade());
        lojaTeste.getEstoque().adicionarProduto(p2, p2.getQuantidade());
    }

    @Test
    void testInicializacaoLoja() {
        Assertions.assertNotNull(lojaTeste.getEstoque());
        Assertions.assertEquals(0.0, lojaTeste.getReceita(), 0.001);
    }

    @Test
    void testRegistrarVendaEAtualizarReceita() {

        Estoque estoque = lojaTeste.getEstoque();

        Produto[] itensVenda = {p1, p2};
        double valorTotal = p1.getPreco() + p2.getPreco();

        estoque.removerProduto(p1, 1.0);
        estoque.removerProduto(p2, 1.0);

        Venda venda = new Venda(vendedor, cliente, itensVenda, valorTotal);
        lojaTeste.registrarVenda(venda);

        Assertions.assertEquals(1, lojaTeste.getVendasRealizadas().size());
        Assertions.assertEquals(valorTotal, lojaTeste.getReceita(), 0.001);
    }

    @Test
    void testAjustarReceitaPorAcao() {

        Produto[] itensVenda = {p2};

        Venda venda = new Venda(vendedor, cliente, itensVenda, 500.00);

        lojaTeste.registrarVenda(venda);
        lojaTeste.ajustarReceitaPorAcao(venda, -500.00);

        Assertions.assertEquals(0.0, lojaTeste.getReceita(), 0.001);
    }

    @Test
    void testResumoLoja() {
        lojaTeste.resumo_loja(); // Somente para não quebrar
    }
}
