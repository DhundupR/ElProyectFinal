

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class Tester {
    public static JFrame window;

    public  void main(){






        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Rpg");
        System.out.println("osdhiohasfoh");
        GamePanel gamePanel = new GamePanel();


        window.add(gamePanel);






        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGame();







    }
}
