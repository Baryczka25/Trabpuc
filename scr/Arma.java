package scr;

public class Arma {
    private String nome;
    private int dano;
    private String armaImg;

    public Arma(String nome, String armaImg, int danoBase) {
        this.nome = nome;
        this.dano = danoBase;
        this.armaImg = armaImg;
    }

    public void upgrade() {
        dano++;
    }

    public int getDano() { return dano; }
    public String getNome() { return nome; }
    public String getarmaImg() { return armaImg; }
}
