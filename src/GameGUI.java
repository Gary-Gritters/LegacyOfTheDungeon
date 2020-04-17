<<<<<<< HEAD
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
=======
import javax.swing.*;
import java.awt.*;

/**************************************************
 * This class runs the actual GUI and sets it's size.
 * 
 * @author GG
 * @version 1.0
 ***************************************************/

public class GameGUI {
	
	/*************************************************
	 * This is the main method which runs the GUI.
	 * @param args
	 *************************************************/
	
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
>>>>>>> ea38c8f96f57262456c3421e342859f72eeb73ec
