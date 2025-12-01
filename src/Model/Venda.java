package Model;

import Model.user.Cliente;
import Model.user.Vendedor;
import java.util.Arrays;

public class Venda {

    // --- Atributos ---
    private int id_venda;
    private Vendedor vendedor;
    private Cliente cliente;
    private Produto[] produtos;
    private double valor;
    private int quant_parcelas;
    private boolean devolvido;
    private boolean existe;

    // Construtor: Ordem (Vendedor, Cliente, Produtos, Valor)
    public Venda(Vendedor vendedor, Cliente cliente, Produto[] produtos, double valor) {
        // Assume que Loja.getProximoIdVenda() existe
        this.id_venda = Loja.getProximoIdVenda();
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.produtos = produtos;
        this.valor = valor;
        this.quant_parcelas = 1;
        this.devolvido = false;
        this.existe = true;
    }

    // --- Getters ---

    public int getId_venda() {
        return id_venda;
    }

    // ESTE É O MÉTODO QUE RESOLVE O ERRO 'cannot find symbol getVendedor()'
    public Vendedor getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public double getValor() {
        return valor;
    }

    public int getQuant_parcelas() {
        return quant_parcelas;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public boolean isExiste() {
        return existe;
    }

    // --- Setters (Usados pelos Controllers) ---

    public void setQuant_parcelas(int quant_parcelas) {
        this.quant_parcelas = quant_parcelas;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    // --- Método toString (Opcional) ---
    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id_venda +
                ", vendedor=" + vendedor.getNome() +
                ", cliente=" + cliente.getNome() +
                ", valor=" + valor +
                '}';
    }
}