package Tests;

import Model.Estoque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Estoque_teste {

    @Test
    void deve_guardar_nome_e_local() {
        Estoque meuEstoque = new Estoque();
        meuEstoque.setNome("Estoque Principal");
        meuEstoque.setLocal("Armazem A");
        Assertions.assertEquals("Estoque Principal", meuEstoque.getNome());
        Assertions.assertEquals("Armazem A", meuEstoque.getLocal());
    }

    @Test
    void deve_atualizar_quantidade() {
        Estoque meuEstoque = new Estoque();
        meuEstoque.setQuantidade(50.0);
        meuEstoque.setQuantidade(meuEstoque.getQuantidade() + 20.0);
        Assertions.assertEquals(70.0, meuEstoque.getQuantidade(), 0.001);
        meuEstoque.setQuantidade(meuEstoque.getQuantidade() - 10.0);
        Assertions.assertEquals(60.0, meuEstoque.getQuantidade(), 0.001);
    }
}
