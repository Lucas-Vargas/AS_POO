package Model.user;

public class Credenciado extends Cliente implements ICliente {

    private boolean possui_cartao;
    private double desconto_default;

    public Credenciado(String nome, String cpf, String telefone, String email, boolean possui_cartao, double desconto_default) {
        super(nome, cpf, telefone, email);
        this.possui_cartao = possui_cartao;
        this.desconto_default = desconto_default;
    }

    public double getDesconto_default() { return desconto_default; }
    public void criar_cartao() { this.possui_cartao = true; }
    public boolean isPossui_cartao() { return possui_cartao; }

    /**
     * Retorna um código fixo (pode ser sobrescrito para gerar códigos dinâmicos).
     */
    public int getCodigo() { return 101; }
}
