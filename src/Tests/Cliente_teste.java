package Tests;

import Model.user.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cliente_teste {

    @Test
    void deve_inicializar_cliente_corretamente() {
        Cliente clienteTeste = new Cliente("Joao Silva", "12345678900", "987654321", "joao@email.com");
        Assertions.assertEquals("Joao Silva", clienteTeste.getNome());
        Assertions.assertEquals("12345678900", clienteTeste.getCpf());
        Assertions.assertEquals(0.0, clienteTeste.getDebito(), 0.001);
        Assertions.assertTrue(clienteTeste.isAtivo());
    }

    @Test
    void deve_inativar_cliente() {
        Cliente clienteTeste = new Cliente("Joao", "1", "1", "a@b");
        clienteTeste.inativar();
        Assertions.assertFalse(clienteTeste.isAtivo());
    }

    @Test
    void deve_editar_nome_e_telefone_corretamente() {
        Cliente clienteTeste = new Cliente("Joao", "1", "1", "a@b");
        int[] opcoes = {1, 3};
        String[] alteracoes = {"Novo Nome Teste", "999998888"};
        clienteTeste.EditarDados(opcoes, alteracoes);
        Assertions.assertEquals("Novo Nome Teste", clienteTeste.getNome());
        Assertions.assertEquals("999998888", clienteTeste.getTelefone());
    }

    @Test
    void deve_editar_debito_corretamente() {
        Cliente clienteTeste = new Cliente("Joao", "1", "1", "a@b");
        int[] opcoes = {5};
        String[] alteracoes = {"150.75"};
        clienteTeste.EditarDados(opcoes, alteracoes);
        Assertions.assertEquals(150.75, clienteTeste.getDebito(), 0.001);
    }
}
