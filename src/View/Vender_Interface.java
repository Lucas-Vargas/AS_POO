package View;

import Model.Loja;
import Model.Produto;
import Model.Venda;
import Model.user.Cliente;
import Model.user.Vendedor;

public interface Vender_Interface {

    public Venda newVenda(Loja loja, Cliente cliente, Vendedor vendedor, Produto[] produtos, int quant_parcelas);

    public void excluirVenda(Loja loja, Venda venda);

    public void devolverVenda(Loja loja, Venda venda);
}
