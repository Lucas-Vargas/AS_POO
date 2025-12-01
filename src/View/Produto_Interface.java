package View;

import Model.Estoque;
import Model.Produto;

public interface Produto_Interface {

    public Produto cadastroProduto(String nome, String descricao, String id, double preco, double quantidadeInicial);

    public void excluirProduto(Produto produto);

    public void adicionarEstoque(double quantidade, Produto produto);

    public void removerEstoque(double quantidade, Produto produto);

    public void alterarDescricao(String descricao, Produto produto);

    public void alterarNome(String nome, Produto produto);

    public void alterarPreco(double preco, Produto produto);
}