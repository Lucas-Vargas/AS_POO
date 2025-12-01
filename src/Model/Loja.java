package Model;

import Model.user.Vendedor;
import java.util.ArrayList;
import java.util.List;

public class Loja {

    // --- Atributos ---
    private Estoque estoque;
    private List<Vendedor> vendedores;
    private List<Venda> vendasRealizadas;

    private String nome = "Loja Principal";
    private double receitaTotal;
    private boolean ativa = true;
    private static int proximoIdVenda = 1;

    // Construtor
    public Loja() {
        this.estoque = new Estoque();
        this.vendedores = new ArrayList<>();
        this.vendasRealizadas = new ArrayList<>();
        this.receitaTotal = 0.0;
    }

    // --- Getters e Setters ---

    // CORRIGIDO: Este método deve retornar o objeto Estoque
    public Estoque getEstoque() {
        return estoque; // <--- INSTRUÇÃO DE RETORNO AUSENTE CORRIGIDA
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
    }

    public double getReceita() {
        return receitaTotal;
    }

    public List<Venda> getVendasRealizadas() {
        return vendasRealizadas;
    }

    public static int getProximoIdVenda() {
        return proximoIdVenda;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    // --- Métodos de Lógica (Usados pelos Controllers) ---

    public void adicionarVendedor(Vendedor vendedor) {
        this.vendedores.add(vendedor);
    }

    /**
     * Registra uma venda, adiciona à lista e atualiza a receita total.
     */
    public void registrarVenda(Venda venda) {
        if (venda != null && venda.isExiste() && !venda.isDevolvido()) {
            this.vendasRealizadas.add(venda);
            this.receitaTotal += venda.getValor();
            proximoIdVenda++;
        }
    }

    /**
     * Ajusta a receita após exclusão ou devolução.
     */
    public void ajustarReceitaPorAcao(Venda venda, double valorParaAjuste) {
        this.receitaTotal += valorParaAjuste;
    }

    /**
     * Método de relatório.
     */
    public void resumo_loja() {
        System.out.println("--- RESUMO DA LOJA (" + this.nome + ") ---");
        System.out.println("Status: " + (this.ativa ? "ATIVA" : "INATIVA"));
        System.out.println("Receita Total: R$ " + String.format("%.2f", this.receitaTotal));
        System.out.println("Vendas Registradas: " + this.vendasRealizadas.size());
        System.out.println("------------------------------------");
    }
}