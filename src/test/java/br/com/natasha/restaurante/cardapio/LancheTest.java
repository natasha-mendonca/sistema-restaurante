package br.com.natasha.restaurante.cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LancheTest {

    @Test
    void precoNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Lanche("X-Teste", -5.0));
    }
}