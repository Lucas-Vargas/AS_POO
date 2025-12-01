package Model.user;

// Interface IVendedor para seguir o princípio da Programação para Interface.
public interface IVendedor {

    String getNome();
    String getCpf();
    double getSalario();

    void EditarDados(int[] codigos, String[] dados);
}
