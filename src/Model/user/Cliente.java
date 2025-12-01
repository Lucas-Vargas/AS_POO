package Model.user;

public class Cliente extends Pessoa implements ICliente {

    private String telefone;
    private String email;
    private double debito;

    public Cliente(String nome, String cpf, String telefone, String email) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.debito = 0.0;
        this.ativo = true;
    }

    @Override
    public void inativar() {
        this.setAtivo(false);
    }

    /**
     * Mapear opções de edição:
     * 1 = nome
     * 2 = cpf
     * 3 = telefone
     * 4 = email
     * 5 = debito (double)
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
                    this.telefone = alteracoes[i];
                    break;
                case 4:
                    this.email = alteracoes[i];
                    break;
                case 5:
                    try {
                        this.debito = Double.parseDouble(alteracoes[i]);
                    } catch (NumberFormatException ignored) {}
                    break;
                default:
                    // ignorar
            }
        }
    }

    // getters
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public double getDebito() { return debito; }

    // setters (se necessário)
    protected void setTelefone(String telefone) { this.telefone = telefone; }
    protected void setEmail(String email) { this.email = email; }
    protected void setDebito(double debito) { this.debito = debito; }
}
