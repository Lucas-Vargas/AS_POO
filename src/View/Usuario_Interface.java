package View;

import Model.Loja;
import Model.user.Cliente;
import Model.user.Credenciado;
import Model.user.Vendedor;

public interface Usuario_Interface {

    public Cliente newCliente(String nome, String cpf, String telefone, String email);
    public Vendedor newVendedor(String nome, String cpf, double comissao, double salario, Loja loja);

    public Credenciado newCredenciado(String nome, String cpf, String telefone, String email, boolean possui_cartao, double desconto_default);

    public void inativarCliente(Cliente cliente);
    public void inativarVendedor(Vendedor vendedor);
    public void inativarCredenciado(Credenciado credenciado);

    public void editarDadosCliente(Cliente cliente, int[] opcoes, String[] alteracoes);
    public void editarDadosVendedor(Vendedor vendedor, int[] opcoes, String[] alteracoes);
    public void editarDadosCredenciado(Credenciado credenciado, int[] opcoes, String[] alteracoes);
}
