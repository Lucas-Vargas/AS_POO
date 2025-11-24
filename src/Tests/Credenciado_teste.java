package Tests;

import Model.user.Credenciado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Credenciado_teste {

    @Test
    void deve_inicializar_e_inativar_credenciado() {
        Credenciado credenciadoTeste = new Credenciado("Fernanda Lima", "11122233344", "987654321", "fernanda@email.com", 101, false, 0.05);
        Assertions.assertEquals("Fernanda Lima", credenciadoTeste.getNome());
        Assertions.assertEquals(101, credenciadoTeste.getCodigo());
        Assertions.assertFalse(credenciadoTeste.isPossui_cartao());

        credenciadoTeste.inativar();
        Assertions.assertFalse(credenciadoTeste.isAtivo());
    }

    @Test
    void deve_criar_cartao_para_credenciado() {
        Credenciado credenciadoTeste = new Credenciado("Fernanda", "1", "1", "a@b", 101, false, 0.05);
        Assertions.assertFalse(credenciadoTeste.isPossui_cartao());
        credenciadoTeste.criar_cartao();
        Assertions.assertTrue(credenciadoTeste.isPossui_cartao());
    }

    @Test
    void deve_editar_email_e_debito_herdado() {
        Credenciado credenciadoTeste = new Credenciado("Fernanda", "1", "1", "a@b", 101, false, 0.05);
        int[] opcoes = {4, 5};
        String[] alteracoes = {"novo_email@teste.com", "150.75"};

        credenciadoTeste.EditarDados(opcoes, alteracoes);

        Assertions.assertEquals("novo_email@teste.com", credenciadoTeste.getEmail());
        Assertions.assertEquals(150.75, credenciadoTeste.getDebito(), 0.001);
    }
}
