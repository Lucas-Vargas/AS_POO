package Model.user;

public class Credenciado extends Cliente {
    private int codigo;
    private boolean possui_cartao;
    private double desconto_default;

    public Credenciado(String nome, String cpf, String telefone, String email,
                       int codigo, boolean possui_cartao, double desconto_default) {
        super(nome, cpf, telefone, email);
        this.codigo = codigo;
        this.possui_cartao = possui_cartao;
        this.desconto_default = desconto_default;
    }

    public void criar_cartao() {
        this.possui_cartao = true;
    }

    @Override
    public void inativar() {
        super.inativar();
    }

    // getters pedidos pelos testes
    public int getCodigo() {
        return codigo;
    }
    public boolean isPossui_cartao() {
        return possui_cartao;
    }
    public double getDesconto_default() {
        return desconto_default;
    }
}
