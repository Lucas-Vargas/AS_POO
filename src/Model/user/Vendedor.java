package Model.user;
import Model.Loja;

public class Vendedor extends Pessoa {

    private double comissao, salario;
    private Loja loja;

    public Vendedor(String nome, String cpf, double comissao, double salario, Loja loja) {
        this.nome = nome;
        this.cpf = cpf;
        this.ativo = true;
        this.comissao = comissao;
        this.salario = salario;
        this.loja = loja;
    }

    @Override
    public void inativar() {
        this.setAtivo(false);
    }

    /**
     * 1 = nome
     * 2 = cpf
     * 3 = comissao
     * 4 = salario
     */
    @Override
    public void EditarDados(int[] opcoes, String[] alteracoes) {
        if (opcoes == null || alteracoes == null) return;
        int n = Math.min(opcoes.length, alteracoes.length);
        for (int i = 0; i < n; i++) {
            switch (opcoes[i]) {
                case 1:
                    this.setNome(alteracoes[i]);
                    break;
                case 2:
                    this.setCpf(alteracoes[i]);
                    break;
                case 3:
                    try {
                        this.comissao = Double.parseDouble(alteracoes[i]);
                    } catch (NumberFormatException ignored) {}
                    break;
                case 4:
                    try {
                        this.salario = Double.parseDouble(alteracoes[i]);
                    } catch (NumberFormatException ignored) {}
                    break;
                default:
                    // ignorar
            }
        }
    }

    protected void EditarLoja(Loja loja){
        this.loja = loja;
    }

    // getters usados nos testes
    public double getComissao() {
        return comissao;
    }
    public double getSalario() {
        return salario;
    }
    public Loja getLoja() {
        return loja;
    }
    // nome, cpf e ativo já têm getters na classe Pessoa
}
