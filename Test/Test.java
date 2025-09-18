package scr;
package custom.scr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JoguinhoTest {

    //Joguinho

    @Test
    void testAtacarInimigoReduzVida() {
        Joguinho jogo = new Joguinho();
        int vidaInicial = jogo.getVidaInimigo();
        jogo.atacarInimigo();
        assertTrue(jogo.getVidaInimigo() < vidaInicial, "Vida do inimigo deve diminuir após ataque");
    }

    @Test
    void testDerrotarInimigoResetaVida() {
        Joguinho jogo = new Joguinho();
        while (jogo.getVidaInimigo() > 0) {
            jogo.atacarInimigo();
        }
        int novaVida = jogo.getVidaInimigo();
        assertEquals(25, novaVida, "Vida do próximo inimigo deve aumentar 5 pontos");
    }

    @Test
    void testUpgradeArma() {
        Joguinho jogo = new Joguinho();
        // Dar pontos suficientes
        while (jogo.getPontos() < 10) {
            jogo.atacarInimigo();
        }
        int danoAntes = jogo.getDanoArma();
        jogo.upgradeArma();
        assertTrue(jogo.getDanoArma() > danoAntes, "Dano da arma deve aumentar após upgrade");
    }

    @Test
    void testUpgradePontos() {
        Joguinho jogo = new Joguinho();
        while (jogo.getPontos() < 15) {
            jogo.atacarInimigo();
        }
        int pontosAntes = jogo.getPontos();
        String resposta = jogo.upgradePontos();
        assertTrue(resposta.contains("Agora você ganha"), "Deve permitir upgrade de pontos");
        assertTrue(jogo.getPontos() < pontosAntes, "Pontos devem ser descontados após upgrade");
    }

    @Test
    void testInicializacaoJogo() {
        Joguinho jogo = new Joguinho();
        assertEquals(0, jogo.getPontos());
        assertEquals(20, jogo.getVidaInimigo());
        assertEquals("Pistola", jogo.getNomeArma());
    }

    //Arma

    @Test
    void testInicializacaoArma() {
        Arma arma = new Arma("Pistola", "imagens/M1911.png", 1);
        assertEquals("Pistola", arma.getNome());
        assertEquals(1, arma.getDano());
        assertEquals("imagens/M1911.png", arma.getarmaImg());
    }

    @Test
    void testUpgradeArmaSimples() {
        Arma arma = new Arma("Pistola", "imagens/M1911.png", 1);
        arma.upgrade();
        assertEquals(2, arma.getDano());
    }

    @Test
    void testUpgradeArmaMultiplo() {
        Arma arma = new Arma("Pistola", "imagens/M1911.png", 1);
        arma.upgrade();
        arma.upgrade();
        arma.upgrade();
        assertEquals(4, arma.getDano());
    }

    // Inimigu

    @Test
    void testInicializacaoInimigo() {
        Inimigu inimigo = new Inimigu("imagens/zombie.png", 20);
        assertEquals(20, inimigo.getVida());
        assertEquals(20, inimigo.getVidaMaxima());
        assertEquals("imagens/zombie.png", inimigo.getCaminhoImagem());
    }

    @Test
    void testReceberDanoInimigo() {
        Inimigu inimigo = new Inimigu("imagens/zombie.png", 20);
        inimigo.receberDano(5);
        assertEquals(15, inimigo.getVida());
    }

    @Test
    void testVidaNaoNegativa() {
        Inimigu inimigo = new Inimigu("imagens/zombie.png", 20);
        inimigo.receberDano(25);
        assertEquals(0, inimigo.getVida());
    }

    @Test
    void testMultiplosAtaquesInimigo() {
        Inimigu inimigo = new Inimigu("imagens/zombie.png", 20);
        inimigo.receberDano(10);
        inimigo.receberDano(5);
        assertEquals(5, inimigo.getVida());
    }

    @Test
    void testVidaMaximaInimigo() {
        Inimigu inimigo = new Inimigu("imagens/zombie.png", 20);
        inimigo.receberDano(10);
        assertEquals(20, inimigo.getVidaMaxima());
    }
}
