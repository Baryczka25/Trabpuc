package scr;

public class Inimigu {
    private int vida;
    private int vidaMaxima;
    private String caminhoImagem;

    public Inimigu(String caminhoImagem, int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.caminhoImagem = caminhoImagem;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public String getCaminhoImagem() { return caminhoImagem; }
}
