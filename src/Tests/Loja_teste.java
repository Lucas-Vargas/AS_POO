package Tests;

import Model.Loja;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Loja_teste {

    @Test
    void deve_retornar_resumo_correto() {
        Loja loja = new Loja();
        loja.setNome("Loja Central");
        loja.setAtiva(true);

        String resumo = loja.resumo_loja();

        Assertions.assertTrue(resumo.contains("Nome: Loja Central"));
        Assertions.assertTrue(resumo.contains("Receita: 0.0"));
        Assertions.assertTrue(resumo.contains("Ativa: true"));
    }

    @Test
    void receita_nao_pode_ser_alterada_diretamente() {
        Loja loja = new Loja();
        Assertions.assertEquals(0.0, loja.getReceita(), 0.001);
    }
}
