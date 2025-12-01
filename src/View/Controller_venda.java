package View;

import Model.Loja;
import Model.Produto;
import Model.Venda;
import Model.user.Cliente;
import Model.user.Vendedor;
import java.util.ArrayList;
import java.util.List;

public class Controller_venda implements Vender_Interface {

    // NOVO CAMPO: O Controller precisa da Loja para operar
    private Loja loja;

    // CONSTRUTOR CORRIGIDO: Agora recebe a Loja
    public Controller_venda(Loja loja) {
        this.loja = loja;
    }

    // Assumindo que você tem um construtor sem argumentos para testes que precisem
    public Controller_venda() {
        // Pode ser usado para mockar ou inicializar sem Loja imediatamente,
        // mas os métodos abaixo usam a variável 'loja'
        this.loja = null;
    }


    /**
     * Cria e registra uma nova venda, gerenciando o estoque.
     */
    @Override
    public Venda newVenda(Loja loja, Cliente cliente, Vendedor vendedor, Produto[] produtos, int quant_parcelas) {

        // Aqui o parâmetro 'loja' é usado, mas se o método não tivesse 'loja'
        // você usaria o campo 'this.loja'

        double valorTotal = 0.0;
        List<Produto> produtosVendidos = new ArrayList<>();

        // 1. Verifica disponibilidade e calcula valor
        for (Produto p : produtos) {
            // Usando o parâmetro 'loja'
            if (loja.getEstoque().verificarDisponibilidade(p, 1.0)) {
                valorTotal += p.getPreco();
                produtosVendidos.add(p);
            } else {
                System.out.println("Produto " + p.getNome() + " indisponível em estoque.");
                return null;
            }
        }

        // 2. Dá baixa no estoque
        for (Produto p : produtosVendidos) {
            loja.getEstoque().removerProduto(p, 1.0);
        }

        // 3. Cria a Venda
        Venda venda = new Venda(vendedor, cliente, produtosVendidos.toArray(new Produto[0]), valorTotal);
        venda.setQuant_parcelas(quant_parcelas);

        // 4. Registra a Venda na Loja
        loja.registrarVenda(venda);

        return venda;
    }

    /**
     * Exclui logicamente a venda e ajusta a receita.
     */
    @Override
    public void excluirVenda(Loja loja, Venda venda) {
        if (venda != null && venda.isExiste()) {
            venda.setExiste(false);
            loja.ajustarReceitaPorAcao(venda, -venda.getValor());
            System.out.println("Venda ID " + venda.getId_venda() + " excluída logicamente.");
        }
    }

    /**
     * Realiza a devolução da venda.
     */
    @Override
    public void devolverVenda(Loja loja, Venda venda) {
        if (venda != null && venda.isExiste() && !venda.isDevolvido()) {
            venda.setDevolvido(true);

            // 1. Devolve os produtos ao estoque
            for (Produto p : venda.getProdutos()) {
                loja.getEstoque().adicionarProduto(p, 1.0);
            }

            // 2. Ajusta a receita
            loja.ajustarReceitaPorAcao(venda, -venda.getValor());

            System.out.println("Venda ID " + venda.getId_venda() + " devolvida e produtos reintegrados ao estoque.");
        } else if (venda.isDevolvido()) {
            System.out.println("Venda ID " + venda.getId_venda() + " já estava devolvida.");
        }
    }
}