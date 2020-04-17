import javax.swing.*;
import java.awt.*;

public class GameGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Legacy of the Dungeon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        frame.getContentPane().add(panel);

        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(800, 637));
        frame.pack();
        frame.setVisible(true);
    }
}
