import javax.swing.*;
import java.awt.*;

public class Joguinho {
    private int pontos = 0;
    private Arma arma;
    private Inimigu inimigo;
    private int pontosPorInimigo = 5;

    JLabel lblPontos;
    JProgressBar barraVida;

    public void criarGUI() {
        JFrame frame = new JFrame("Jogo Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLayout(new FlowLayout());

        lblPontos = new JLabel("Pontos: 0");
        JButton btnUpgrade = new JButton("Upgrade Arma (+1 de dano) - Custa 10");

        // arma
        arma = new Arma("Pistola", "imagens/M1911.png", 1);

        // inimigo
        inimigo = new Inimigu("imagens/zombie.png", 20);

        // barra de vida
        barraVida = new JProgressBar(0, inimigo.getVidaMaxima());
        barraVida.setValue(inimigo.getVida());
        barraVida.setStringPainted(true);

        JLabel lblInimigo = new JLabel(inimigo.getIcone());

        // botão para atacar
        JButton btnArma = new JButton(arma.getIcone());
        btnArma.setPreferredSize(new Dimension(100, 100));
        btnArma.setBorderPainted(false);
        btnArma.setContentAreaFilled(false);

        btnArma.addActionListener(e -> atacarInimigo());

        // upgrade da arma
        btnUpgrade.addActionListener(e -> upgradeArma());

        JButton btnUpgradePontos = new JButton("Upgrade pontos por inimigo (+2) - Custa 15");

        btnUpgradePontos.addActionListener(e -> {
            if (pontos >= 15) {
                pontos -= 15;
                pontosPorInimigo += 2; // aumenta pontos ganhos
                lblPontos.setText("Pontos: " + pontos);
                JOptionPane.showMessageDialog(null, "Agora você ganha " + pontosPorInimigo + " pontos por inimigo!");
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem pontos suficientes!");
            }
        });

        frame.add(btnUpgradePontos);


        frame.add(lblPontos);
        frame.add(barraVida);
        frame.add(lblInimigo);
        frame.add(new JLabel("Clique na arma para atirar:"));
        frame.add(btnArma);
        frame.add(btnUpgrade);
        frame.add(btnUpgradePontos);
        frame.setVisible(true);
    }

    private void atacarInimigo() {
        inimigo.receberDano(arma.getDano());
        if (inimigo.getVida() <= 0) {
            pontos += pontosPorInimigo; // agora usa o upgrade
            lblPontos.setText("Pontos: " + pontos);
            JOptionPane.showMessageDialog(null, "Inimigo derrotado!");

            // inimigo mais forte
            inimigo = new Inimigu("imagens/zombie.png", inimigo.getVidaMaxima() + 5);
            barraVida.setMaximum(inimigo.getVidaMaxima());
        }
        barraVida.setValue(inimigo.getVida());
        lblPontos.setText("Pontos: " + pontos);
    }

    private void upgradeArma() {
        if (pontos >= 10) {
            pontos -= 10;
            arma.upgrade();
            lblPontos.setText("Pontos: " + pontos);
            JOptionPane.showMessageDialog(null, arma.getNome() + " melhorada! Dano: " + arma.getDano());
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem pontos suficientes!");
        }
    }
}
