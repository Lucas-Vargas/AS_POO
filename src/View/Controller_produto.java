package View;

import Model.Estoque;
import Model.Produto;

public class Controller_produto implements Produto_Interface {

    private final Estoque estoqueGeral;

    public Controller_produto(Estoque estoqueGeral) {
        this.estoqueGeral = estoqueGeral;
    }

    @Override
    public Produto cadastroProduto(String nome, String descricao, String id, double preco, double quantidadeInicial) {
        Produto novoProduto = new Produto(nome, descricao, id, preco, quantidadeInicial);
        this.estoqueGeral.adicionarProduto(novoProduto, quantidadeInicial);
        return novoProduto;
    }

    @Override
    public void excluirProduto(Produto produto){
        if (produto == null) return;
        produto.excluir();
        // opcional: remover do inventário
        // estoqueGeral.removerProduto(produto, estoqueGeral.getQuantidadeProduto(produto));
    }

    @Override
    public void adicionarEstoque(double quantidade, Produto produto){
        if (quantidade > 0 && produto != null) {
            this.estoqueGeral.adicionarProduto(produto, quantidade);
        }
    }

    @Override
    public void removerEstoque(double quantidade, Produto produto){
        if (quantidade > 0 && produto != null) {
            if (this.estoqueGeral.verificarDisponibilidade(produto, quantidade)) {
                this.estoqueGeral.removerProduto(produto, quantidade);
            } else {
                System.err.println("Erro: Quantidade insuficiente em estoque para " + produto.getNome());
            }
        }
    }

    @Override
    public void alterarDescricao(String descricao, Produto produto){
        if (produto != null) produto.setDescricao(descricao);
    }

    @Override
    public void alterarNome(String nome, Produto produto){
        if (produto != null) produto.setNome(nome);
    }

    @Override
    public void alterarPreco(double preco, Produto produto){
        if (produto != null) produto.setPreco(preco);
    }
}
