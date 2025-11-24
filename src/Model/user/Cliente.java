package Model.user;

public class Cliente extends Pessoa {
    private String telefone;
    private String email;
    private double debito;

    public Cliente(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.debito = 0.0;
        this.ativo = true;
    }

    // ações
    @Override
    public void inativar() {
        this.setAtivo(false);
    }

    /**
     * Mapeamento de opções:
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
                    } catch (NumberFormatException e) {
                        // ignore or keep previous value
                    }
                    break;
                default:
                    // opção desconhecida -> ignorar
            }
        }
    }

    // getters e setters usados pelos testes
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public double getDebito() {
        return debito;
    }
}
