import Model.Loja;
import Model.Estoque;
import Model.Produto;
import Model.Venda;
import Model.user.Cliente;
import Model.user.Credenciado;
import Model.user.Vendedor;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // 1. INICIALIZAÇÃO E SETUP
        Loja lojaPrincipal = new Loja();
        Estoque estoque = lojaPrincipal.getEstoque();

        System.out.println("==================================================");
        System.out.println("          Simulação do Sistema de Vendas da " + lojaPrincipal.getNome());
        System.out.println("==================================================");

        // 2. CRIAÇÃO DE USUÁRIOS
        Vendedor vendedorA = new Vendedor("Rui Castro", "11122233344", 0.05, 2500.0, lojaPrincipal);
        Vendedor vendedorB = new Vendedor("Sara Lopes", "55566677788", 0.07, 2800.0, lojaPrincipal);

        Cliente clienteComum = new Cliente("Joana Silva", "99988877766", "21987654321", "joana@email.com");
        Credenciado clienteVIP = new Credenciado("Pedro Alves", "12312312300", "21912345678", "pedro@cred.com", 1001, true, 0.15);

        lojaPrincipal.adicionarVendedor(vendedorA);
        lojaPrincipal.adicionarVendedor(vendedorB);

        System.out.println("\n--- Status Inicial dos Clientes ---");
        System.out.println("Joana (Comum) Ativo: " + clienteComum.isAtivo());
        System.out.println("Pedro (VIP) Desconto: " + clienteVIP.getDesconto_default() * 100 + "%");
        System.out.println("-----------------------------------\n");

        // 3. CRIAÇÃO DE PRODUTOS E ADIÇÃO AO ESTOQUE
        Produto p1 = new Produto(1, "Smartphone Modelo X", 1500.00);
        Produto p2 = new Produto(2, "Fone Bluetooth", 250.00);
        // O trecho anterior estava incompleto aqui. O produto p3 foi recriado.
        Produto p3 = new Produto(3, "Cabo USB-C", 50.00);

        estoque.adicionarProduto(p1, 10);
        estoque.adicionarProduto(p2, 25);
        estoque.adicionarProduto(p3, 50);

        estoque.exibirEstoque();

        // 4. SIMULAÇÃO DE VENDAS

        // --- Venda 1: Cliente Comum ---
        System.out.println("SIMULAÇÃO DE VENDA 1 (Cliente Comum)");

        List<Produto> itensVenda1 = new ArrayList<>();
        itensVenda1.add(p1); // 1x Smartphone
        itensVenda1.add(p2); // 1x Fone

        if (estoque.verificarDisponibilidade(p1, 1) && estoque.verificarDisponibilidade(p2, 1)) {
            double totalVenda1 = p1.getPreco() + p2.getPreco(); // 1500 + 250 = 1750.00

            // Simula a remoção do estoque
            estoque.removerProduto(p1, 1);
            estoque.removerProduto(p2, 1);

            Venda venda1 = new Venda(vendedorA, clienteComum, itensVenda1, totalVenda1);
            lojaPrincipal.registrarVenda(venda1);

        } else {
            System.out.println("Venda 1 cancelada por falta de estoque.");
        }

        // --- Venda 2: Cliente VIP (com desconto) ---
        System.out.println("SIMULAÇÃO DE VENDA 2 (Cliente Credenciado)");

        List<Produto> itensVenda2 = new ArrayList<>();
        itensVenda2.add(p3); // 1x Cabo USB-C (50.00)

        if (estoque.verificarDisponibilidade(p3, 1)) {
            double precoBruto = p3.getPreco(); // 50.00
            double desconto = clienteVIP.getDesconto_default(); // 0.15 (15%)
            double totalVenda2 = precoBruto * (1.0 - desconto); // 50.00 * 0.85 = 42.50

            // Simula a remoção do estoque
            estoque.removerProduto(p3, 1);

            Venda venda2 = new Venda(vendedorB, clienteVIP, itensVenda2, totalVenda2);
            lojaPrincipal.registrarVenda(venda2);

            // Simula uma dívida (débito) para o cliente VIP
            clienteVIP.EditarDados(new int[]{5}, new String[]{"42.50"});

        } else {
            System.out.println("Venda 2 cancelada por falta de estoque.");
        }

        // 5. DEMONSTRAÇÃO DE MÉTODOS DE USER

        // Inativar cliente comum
        clienteComum.inativar();
        System.out.println("Joana Silva (Cliente Comum) foi inativada.");

        // Editar dados do vendedor
        System.out.println("\nSalário antigo do Rui: " + vendedorA.getSalario());
        vendedorA.EditarDados(new int[]{4}, new String[]{"3000.00"});
        System.out.println("Salário novo do Rui: " + vendedorA.getSalario());

        // 6. PERSISTÊNCIA DO ID DA VENDA (Seu código)
        System.out.println("\n==================================================");
        System.out.println("          DEMONSTRAÇÃO DE PERSISTÊNCIA DO ID");
        System.out.println("==================================================");

        final String FILENAME = "Venda_Id.txt";
        final String FILEPATH = "./" + FILENAME;

        // Simula que o próximo ID a ser gravado é 3
        String id_temp = Integer.toString(3);

        try (FileWriter fileWriter = new FileWriter(FILENAME);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Gravando o ID temporário: " + id_temp);
            bufferedWriter.write(id_temp);

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        String firstLine = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {
            firstLine = reader.readLine();

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.print("ID lido do arquivo: ");
        try { // Trata se o arquivo estiver vazio
            if (firstLine != null) {
                int idLido = Integer.parseInt(firstLine);
                System.out.println(idLido);
            } else {
                System.out.println("Arquivo vazio ou ID não encontrado. (Retorno: -1)");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido no arquivo. (Retorno: -1)");
            System.out.println("Detalhe do erro: " + e.getMessage());
        }


        // 7. ESTADO FINAL DO SISTEMA
        System.out.println("\n==================================================");
        System.out.println("          ESTADO FINAL DO SISTEMA");
        System.out.println("==================================================");

        System.out.println("\n--- Clientes ---");
        System.out.println("Joana Silva (Ativo?): " + clienteComum.isAtivo());
        System.out.println("Pedro Alves (Débito): R$ " + String.format("%.2f", clienteVIP.getDebito()));

        estoque.exibirEstoque();
        System.out.println("Total de vendas registradas: " + lojaPrincipal.getVendasRealizadas().size());
    }
}