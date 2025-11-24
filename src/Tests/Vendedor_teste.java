package Tests;

import Model.Loja;
import Model.user.Vendedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vendedor_teste {

    @Test
    void deve_inicializar_vendedor_corretamente() {
        Loja lojaTeste = new Loja();
        Vendedor vendedorTeste = new Vendedor("Carlos Souza", "99988877766", 0.10, 2000.0, lojaTeste);

        Assertions.assertEquals("Carlos Souza", vendedorTeste.getNome());
        Assertions.assertEquals(0.10, vendedorTeste.getComissao(), 0.001);
        Assertions.assertEquals(2000.0, vendedorTeste.getSalario(), 0.001);
        Assertions.assertTrue(vendedorTeste.isAtivo());
        Assertions.assertEquals(lojaTeste, vendedorTeste.getLoja());
    }

    @Test
    void deve_inativar_vendedor() {
        Loja lojaTeste = new Loja();
        Vendedor vendedorTeste = new Vendedor("Carlos", "1", 0.10, 2000.0, lojaTeste);
        vendedorTeste.inativar();
        Assertions.assertFalse(vendedorTeste.isAtivo());
    }

    @Test
    void deve_editar_nome_e_salario() {
        Loja lojaTeste = new Loja();
        Vendedor vendedorTeste = new Vendedor("Carlos", "1", 0.10, 2000.0, lojaTeste);
        int[] opcoes = {1, 4};
        String[] alteracoes = {"Carlos Novo", "2500.00"};

        vendedorTeste.EditarDados(opcoes, alteracoes);

        Assertions.assertEquals("Carlos Novo", vendedorTeste.getNome());
        Assertions.assertEquals(2500.00, vendedorTeste.getSalario(), 0.001);
    }
}
