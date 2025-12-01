package Model.user;

// Interface ICliente para seguir o princípio da Programação para Interface.
public interface ICliente {

    String getNome();
    String getCpf();
    boolean isAtivo();
    void inativar();

    void EditarDados(int[] codigos, String[] dados);

    double getDebito();
}
