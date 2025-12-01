package View;

import Model.Loja;
import Model.user.Cliente;
import Model.user.Credenciado;
import Model.user.Vendedor;

/**
 * Controller para criação/edição/inativação de usuários.
 * Está intencionalmente simples — validações podem ser adicionadas conforme necessário.
 */
public class Controller_usuario implements Usuario_Interface {

    // Cria um Cliente simples
    @Override
    public Cliente newCliente(String nome, String cpf, String telefone, String email) {
        return new Cliente(nome, cpf, telefone, email);
    }

    // Cria um Vendedor, vinculando-o à Loja passada
    @Override
    public Vendedor newVendedor(String nome, String cpf, double comissao, double salario, Loja loja) {
        return new Vendedor(nome, cpf, comissao, salario, loja);
    }

    // Cria um Credenciado (assinatura ajustada conforme sua classe Credenciado)
    @Override
    public Credenciado newCredenciado(String nome, String cpf, String telefone, String email, boolean possui_cartao, double desconto_default) {
        return new Credenciado(nome, cpf, telefone, email, possui_cartao, desconto_default);
    }

    // Inativação
    @Override
    public void inativarCliente(Cliente cliente) {
        if (cliente != null) cliente.inativar();
    }

    @Override
    public void inativarVendedor(Vendedor vendedor) {
        if (vendedor != null) vendedor.inativar();
    }

    @Override
    public void inativarCredenciado(Credenciado credenciado) {
        if (credenciado != null) credenciado.inativar();
    }

    // Edição
    @Override
    public void editarDadosCliente(Cliente cliente, int[] opcoes, String[] alteracoes) {
        if (cliente != null) cliente.EditarDados(opcoes, alteracoes);
    }

    @Override
    public void editarDadosVendedor(Vendedor vendedor, int[] opcoes, String[] alteracoes) {
        if (vendedor != null) vendedor.EditarDados(opcoes, alteracoes);
    }

    @Override
    public void editarDadosCredenciado(Credenciado credenciado, int[] opcoes, String[] alteracoes) {
        if (credenciado != null) credenciado.EditarDados(opcoes, alteracoes);
    }
}
