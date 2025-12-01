package View;

import Model.Loja;
import Model.Produto;
import Model.Venda;
import Model.user.Cliente;
import Model.user.Vendedor;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- INICIALIZAÇÃO DO SISTEMA DE VENDAS ---");

        // 1. Inicializa a Loja e Controllers
        Loja lojaPrincipal = new Loja();

        // Controller_produto: Geralmente precisa do Estoque
        Controller_produto controllerProduto = new Controller_produto(lojaPrincipal.getEstoque());

        // CORRIGIDO: Passando o objeto 'lojaPrincipal' para o construtor
        Controller_venda controllerVenda = new Controller_venda(lojaPrincipal);

        // 2. Criação de Usuários e Produtos de Teste

        // Vendedor
        Vendedor v1 = new Vendedor("Ana Garcia", "111.111.111-11", 0.05, 2500.0, lojaPrincipal);
        lojaPrincipal.adicionarVendedor(v1);

        // Cliente
        Cliente c1 = new Cliente("Ricardo Almeida", "222.222.222-22", "(21) 98765-4321", "ricardo@mail.com");

        // Cria e cadastra Produtos
        Produto p1 = controllerProduto.cadastroProduto("Celular X", "Modelo top de linha", "CX100", 3500.00, 5.0);
        Produto p2 = controllerProduto.cadastroProduto("Carregador USB", "Rápido 65W", "CRG01", 150.00, 20.0);

        System.out.println("\n--- ESTADO INICIAL ---");
        lojaPrincipal.resumo_loja();
        lojaPrincipal.getEstoque().exibirEstoque();

        // 3. Simulação de Venda (usando o Controller de Venda)

        Produto[] itensVenda1 = {p1, p2};
        double valorVenda1 = p1.getPreco() + p2.getPreco();
        int parcelas = 6;

        System.out.println("\n--- REALIZANDO VENDA 1 ---");

        // Chamando o método newVenda do Controller_venda
        Venda venda1 = controllerVenda.newVenda(lojaPrincipal, c1, v1, itensVenda1, parcelas);

        if (venda1 != null) {
            System.out.println("Venda realizada com sucesso!");
            System.out.println("Detalhes: Vendedor: " + venda1.getVendedor().getNome() +
                    ", Valor: R$ " + String.format("%.2f", venda1.getValor()));

            // Verifica se o estoque foi atualizado
            System.out.println("Novo estoque de " + p1.getNome() + ": " + lojaPrincipal.getEstoque().getQuantidadeProduto(p1));
        }

        // 4. Exemplo de Devolução (usando o Controller de Venda)
        if (venda1 != null) {
            System.out.println("\n--- DEVOLUÇÃO DA VENDA 1 ---");
            controllerVenda.devolverVenda(lojaPrincipal, venda1);

            // Verifica se o estoque foi reintegrado
            System.out.println("Estoque após devolução de " + p1.getNome() + ": " + lojaPrincipal.getEstoque().getQuantidadeProduto(p1));
        }

        // 5. Estado Final
        System.out.println("\n--- ESTADO FINAL ---");
        lojaPrincipal.resumo_loja();
        lojaPrincipal.getEstoque().exibirEstoque();
    }
}