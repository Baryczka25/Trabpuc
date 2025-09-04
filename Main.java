import javax.swing.*;
import java.awt.*;

public class Main {
    private int pontos = 0;
    private int pontosPorClique = 1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().criarGUI());
    }

    private void criarGUI() {
        JFrame frame = new JFrame("Jogo Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel lblPontos = new JLabel("Pontos: 0");
        JButton btnUpgrade = new JButton("Upgrade (+1 por clique) - Custa 10");

        ImageIcon iconeOriginal = new ImageIcon("imagens/M1911.png"); // use PNG
        Image tamanhocerto = iconeOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon pistol = new ImageIcon(tamanhocerto);


        // botão-imagem de pontos
        JButton btnClicar = new JButton(pistol);
        btnClicar.setPreferredSize(new Dimension(100, 100));
        btnClicar.setBorderPainted(false);
        btnClicar.setContentAreaFilled(false);

        btnClicar.addActionListener(e -> {
            pontos += pontosPorClique;
            lblPontos.setText("Pontos: " + pontos);
        });

        // botão de upgrade
        btnUpgrade.addActionListener(e -> {
            if (pontos >= 10) {
                pontos -= 10;
                pontosPorClique++;
                lblPontos.setText("Pontos: " + pontos);
                btnUpgrade.setText("Upgrade (+1 por clique) - Custa 10");
            } else {
                JOptionPane.showMessageDialog(frame, "Você não tem pontos suficientes!");
            }
        });

        frame.add(lblPontos);
        frame.add(btnClicar);
        frame.add(btnUpgrade);

        frame.setVisible(true);
    }
}
