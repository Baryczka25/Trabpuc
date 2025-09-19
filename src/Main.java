package scr;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Jogo Clicker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Corrigindo: criando um JLabel
            JLabel lbl = new JLabel("Bem-vindo ao Joguinho!");
            lbl.setFont(new Font("Arial", Font.BOLD, 16));
            lbl.setHorizontalAlignment(SwingConstants.CENTER);

            frame.add(lbl, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
