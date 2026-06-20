import view.MainFrame;
import javax.swing.*;

/**
 * Ponto de entrada do sistema da Clinica Veterinaria.
 * Tema 10 - Trabalho em Grupo - Programacao Visual com Java Swing.
 */
public class Main {
    public static void main(String[] args) {
        // Tenta usar o visual do sistema operacional
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Se nao funcionar, usa o visual padrao do Java mesmo
        }
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
