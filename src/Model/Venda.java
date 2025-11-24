package Model;
import Model.user.Cliente;
import Model.Produto;
import Model.user.Vendedor;
//Para ler e escrever em um arquivo
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Venda {

    //variaveis
    private Cliente cliente;
    private Vendedor vendedor;
    private Produto[] produto;
    private double valor;
    private boolean devolvido, existe;
    private int id_venda, quant_parcelas;

    //constantes
    private final String FILENAME = "Venda_Id.txt";
    private final String FILEPATH = "./"+FILENAME;

    //construtor
    public Venda(Cliente cliente, Vendedor vendedor, Produto[] produtos, int quant_parcelas){
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produto = produtos != null ? produtos : new Produto[0];
        this.quant_parcelas = quant_parcelas;
        this.devolvido = false;
        this.existe = true;

        // diminuir estoque corretamente para todos produtos
        for(int i = 0; i < this.produto.length; i++) {
            if(this.produto[i] != null && this.produto[i].getEstoque() != null) {
                double q = this.produto[i].getEstoque().getQuantidade();
                if (q > 0) {
                    this.produto[i].getEstoque().setQuantidade(q - 1);
                }
            }
        }

        // calcular valor da venda
        this.valor = this.calcularValor(this.produto);

        // ajustar id (lê arquivo e incrementa)
        int id_temp = this.getIdFile();
        if(id_temp == -1){
            this.id_venda = 1;
            this.setIdFile(this.id_venda);
        }
        else{
            this.id_venda = id_temp + 1;
            this.setIdFile(this.id_venda);
        }

    }

    //metodos
    private int getIdFile(){
        String id_temp = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {
            id_temp = reader.readLine();
        } catch (IOException e) {
            // arquivo pode não existir ainda -> retornar -1
            return -1;
        }
        try{ //trata se o arquivo estiver vazio
            return Integer.parseInt(id_temp);
        } catch (NumberFormatException e) {
            return -1;
        }

    }// end method
    private void setIdFile(int id){
        String id_temp = Integer.toString(id);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILENAME))) {
            bufferedWriter.write(id_temp);
        } catch (IOException e) {
            System.err.println(":(" + e.getMessage());
        }
    }// end method
    private double calcularValor(Produto[] produtos){
        double count = 0;
        if (produtos == null) return 0;
        for (int i = 0; i < produtos.length; i++){
            if(produtos[i] != null){
                count += produtos[i].getPreco();
            } else {
                // produto nulo -> ignora
            }
        }
        return count;
    }
    public void excluir(){
        this.existe = false;
    }
    public void devolver(){
        if(!this.devolvido) {
            this.devolvido = true;
            for(int i = 0; i < produto.length; i++){
                if(produto[i] != null && produto[i].getEstoque() != null){
                    double q = produto[i].getEstoque().getQuantidade();
                    produto[i].getEstoque().setQuantidade(q + 1);
                }
            }
        }
    }

    // getters usados pelos testes
    public int getId_venda() {
        return id_venda;
    }
    public boolean isExiste() {
        return existe;
    }
    public boolean isDevolvido() {
        return devolvido;
    }
    public double getValor() {
        return valor;
    }
}
