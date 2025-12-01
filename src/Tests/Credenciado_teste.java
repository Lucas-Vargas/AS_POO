package Tests;

import Model.user.Credenciado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Credenciado_teste {

    @Test
    void deve_inicializar_e_inativar_credenciado() {
        // CORREÇÃO: O construtor Credenciado tem 6 argumentos, não 7.
        // O construtor é: super(nome, cpf, telefone, email), possui_cartao, desconto_default
        // A ordem dos argumentos no seu construtor Credenciado é:
        // (String nome, String cpf, String telefone, String email, boolean possui_cartao, double desconto_default)

        // Argumentos passados: "Fernanda Lima", "11122233344", "987654321", "fernanda@email.com", 101, false, 0.05
        // PROBLEMA: O '101' está sendo passado em excesso ou incorretamente.

        // ASSUMINDO que a ordem correta é: nome, cpf, telefone, email, possui_cartao (boolean), desconto_default (double)
        Credenciado credenciadoTeste = new Credenciado("Fernanda Lima", "11122233344", "987654321", "fernanda@email.com", false, 0.05);

        Assertions.assertEquals("Fernanda Lima", credenciadoTeste.getNome());
        // REMOVIDO: getCodigo() está na interface, mas 101 não é passado no construtor.
        // Se você quiser testar o código, teste o método getCodigo() diretamente.
        Assertions.assertEquals(101, credenciadoTeste.getCodigo());
        Assertions.assertEquals(0.05, credenciadoTeste.getDesconto_default(), 0.001); // Teste do desconto
        Assertions.assertFalse(credenciadoTeste.isPossui_cartao());

        credenciadoTeste.inativar();
        Assertions.assertFalse(credenciadoTeste.isAtivo());
    }

    @Test
    void deve_criar_cartao_para_credenciado() {
        // Ajustado para o construtor de 6 argumentos
        Credenciado credenciadoTeste = new Credenciado("Fernanda", "1", "1", "a@b", false, 0.05);
        Assertions.assertFalse(credenciadoTeste.isPossui_cartao());
        credenciadoTeste.criar_cartao();
        Assertions.assertTrue(credenciadoTeste.isPossui_cartao());
    }

    @Test
    void deve_editar_email_e_debito_herdado() {
        // Ajustado para o construtor de 6 argumentos
        Credenciado credenciadoTeste = new Credenciado("Fernanda", "1", "1", "a@b", false, 0.05);
        int[] opcoes = {4, 5};
        String[] alteracoes = {"novo_email@teste.com", "150.75"};

        credenciadoTeste.EditarDados(opcoes, alteracoes);

        Assertions.assertEquals("novo_email@teste.com", credenciadoTeste.getEmail());
        Assertions.assertEquals(150.75, credenciadoTeste.getDebito(), 0.001);
    }
}