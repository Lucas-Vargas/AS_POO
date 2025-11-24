package Model;

public class Loja {
    private int id_loja;
    private double receita = 0.0;
    private String nome;
    private boolean ativa;

    public double getReceita() {
        return receita;
    }
    // manter setReceita privado (conforme design), mas implemento caso precise internamente
    private void setReceita(double receita) {
        this.receita = receita;
    }

    public String resumo_loja(){
        return "Nome: "+this.nome+"\nReceita: "+this.receita+"\nAtiva: "+this.ativa;
    }

    // getters/setters usados pelos testes e pelo model
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    public String getNome() {
        return nome;
    }
    public boolean isAtiva() {
        return ativa;
    }
}
