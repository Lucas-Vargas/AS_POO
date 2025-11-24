package View;
import Model.Loja;
import Model.Produto;
import Model.Venda;
import Model.user.Cliente;
import Model.user.Credenciado;
import Model.user.Vendedor;

public class Controller_venda implements Usuario_Interface {
    public Venda newVenda(Cliente cliente, Vendedor vendedor, Produto[] produtos, int quant_parcelas){
        return new Venda(cliente, vendedor, produtos, quant_parcelas);
    }
    public void excluirVenda(Venda venda){
        venda.excluir();
        System.out.println("Venda excluida com sucesso!\nId da venda: "+venda.getId_venda());
    }
    public void devolverVenda(Venda venda){
        venda.devolver();
    }

    /**
     * @param nome
     * @param cpf
     * @param telefone
     * @param email
     * @return
     */
    @Override
    public Cliente newCliente(String nome, String cpf, String telefone, String email) {
        return null;
    }

    /**
     * @param nome
     * @param cpf
     * @param comissao
     * @param salario
     * @param loja
     * @return
     */
    @Override
    public Vendedor newVendedor(String nome, String cpf, double comissao, double salario, Loja loja) {
        return null;
    }

    /**
     * @param nome
     * @param cpf
     * @param telefone
     * @param email
     * @param codigo
     * @param possui_cartao
     * @param desconto_default
     * @return
     */
    @Override
    public Credenciado newCredenciado(String nome, String cpf, String telefone, String email, int codigo, boolean possui_cartao, double desconto_default) {
        return null;
    }

    /**
     * @param cliente
     */
    @Override
    public void inativarCliente(Cliente cliente) {

    }

    /**
     * @param vendedor
     */
    @Override
    public void inativarVendedor(Vendedor vendedor) {

    }

    /**
     * @param credenciado
     */
    @Override
    public void inativarCredenciado(Credenciado credenciado) {

    }

    /**
     * @param cliente
     * @param opcoes
     * @param alteracoes
     */
    @Override
    public void editarDadosCliente(Cliente cliente, int[] opcoes, String[] alteracoes) {

    }

    /**
     * @param vendedor
     * @param opcoes
     * @param alteracoes
     */
    @Override
    public void editarDadosVendedor(Vendedor vendedor, int[] opcoes, String[] alteracoes) {

    }

    @Override
    public void editarDadosCredenciado(Credenciado credenciado, int[] opcoes, String[] alteracoes) {

    }
}
