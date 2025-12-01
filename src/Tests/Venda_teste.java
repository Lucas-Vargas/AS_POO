package Teste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Model.Loja;
import Model.Produto;
import Model.Venda;
import Model.user.Cliente;
import Model.user.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class Venda_teste {

    private Vendedor vendedor;
    private Cliente cliente;
    private Loja loja;
    private Produto p1;
    private Produto p2;
    private List<Produto> itensVenda;

    @BeforeEach
    void setUp() {
        loja = new Loja();
        vendedor = new Vendedor("Rui Castro", "111", 0.05, 2500.0, loja);
        cliente = new Cliente("Joana Silva", "999", "21987654321", "joana@email.com");

        p1 = new Produto("Smartphone X", "Premium", "SMT001", 1500.00, 10.0);
        p2 = new Produto("Fone Bluetooth", "NC", "FNC002", 250.00, 5.0);

        itensVenda = new ArrayList<>();
        itensVenda.add(p1);
        itensVenda.add(p2);
    }

    @Test
    void testCriacaoVenda() {
        double valorTotal = 1500.00 + 250.00;

        // Esta linha depende do getVendedor()
        Venda venda = new Venda(vendedor, cliente, itensVenda.toArray(new Produto[0]), valorTotal);

        assertNotNull(venda);
        assertEquals(vendedor, venda.getVendedor()); // LINHA ONDE O ERRO OCORRIA
        assertEquals(cliente, venda.getCliente());
        assertEquals(valorTotal, venda.getValor(), 0.001);
    }

    @Test
    void testStatusDevolucao() {
        double valorTotal = 1750.00;
        Venda venda = new Venda(vendedor, cliente, itensVenda.toArray(new Produto[0]), valorTotal);

        venda.setDevolvido(true);
        assertTrue(venda.isDevolvido(), "Venda deve ser marcada como devolvida.");
    }

    @Test
    void testStatusExclusao() {
        double valorTotal = 1750.00;
        Venda venda = new Venda(vendedor, cliente, itensVenda.toArray(new Produto[0]), valorTotal);

        venda.setExiste(false);
        assertFalse(venda.isExiste(), "Venda deve ser marcada como não existente.");
    }
}