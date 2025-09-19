package src;


public class Joguinho {
    private int pontos = 0;
    private Arma arma;
    private Inimigu inimigo;
    private int pontosPorInimigo = 5;

    public Joguinho() {
        arma = new Arma("Pistola", "imagens/M1911.png", 1);
        inimigo = new Inimigu("imagens/zombie.png", 20);
    }

    public String atacarInimigo() {
        inimigo.receberDano(arma.getDano());
        if (inimigo.getVida() <= 0) {
            pontos += pontosPorInimigo;
            inimigo = new Inimigu("imagens/zombie.png", inimigo.getVidaMaxima() + 5);
            return "Inimigo derrotado! Vida inimigo resetada.";
        }
        return "Inimigo recebeu dano. Vida restante: " + inimigo.getVida();
    }

    public String upgradeArma() {
        if (pontos >= 10) {
            pontos -= 10;
            arma.upgrade();
            return "Arma melhorada! Dano atual: " + arma.getDano();
        }
        return "Pontos insuficientes para upgrade da arma!";
    }

    public String upgradePontos() {
        if (pontos >= 15) {
            pontos -= 15;
            pontosPorInimigo += 2;
            return "Agora você ganha " + pontosPorInimigo + " pontos por inimigo!";
        }
        return "Pontos insuficientes para upgrade!";
    }

    public int getPontos() { return pontos; }
    public int getVidaInimigo() { return inimigo.getVida(); }
    public int getVidaMaximaInimigo() { return inimigo.getVidaMaxima(); }
    public int getDanoArma() { return arma.getDano(); }
    public String getCaminhoImagemInimigo() { return inimigo.getCaminhoImagem(); }
    public String getNomeArma() { return arma.getNome(); }
    public String getarmaImg() { return arma.getarmaImg(); }
}
