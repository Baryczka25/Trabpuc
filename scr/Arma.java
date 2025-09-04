package scr;

import javax.swing.*;

public class Arma {
    private String nome;
    private int dano;
    private ImageIcon icone;

    public Arma(String nome, String caminhoImagem, int danoBase) {
        this.nome = nome;
        this.dano = danoBase;

        ImageIcon imgOriginal = new ImageIcon(caminhoImagem);
        this.icone = new ImageIcon(imgOriginal.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    }

    public void upgrade() {
        dano++; // cada upgrade aumenta o dano
    }

    public int getDano() { return dano; }
    public String getNome() { return nome; }
    public ImageIcon getIcone() { return icone; }
}