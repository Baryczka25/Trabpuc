package scr;

import javax.swing.*;


public class Inimigu {
    private int vida;
    private int vidaMaxima;
    private ImageIcon icone;

    public Inimigu(String caminhoImagem, int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        ImageIcon imgOriginal = new ImageIcon(caminhoImagem);
        this.icone = new ImageIcon(imgOriginal.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH));
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public ImageIcon getIcone() { return icone; }
}