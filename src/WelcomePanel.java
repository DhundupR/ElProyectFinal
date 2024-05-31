import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel implements ActionListener {

    private JTextField textField;
    private JButton Start;
    private JButton Quit;
    private JFrame enclosingFrame;
    private BufferedImage goomba;

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            goomba = ImageIO.read(new File("src/goomba.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        textField = new JTextField(10);
        Start = new JButton("Start");
        Quit = new JButton("Quit");

        add(Start);
        add(Quit);
        Start.addActionListener(this);
        Quit.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawString("Welcome To Dungeon:", 50, 30);
        g.drawImage(goomba, 200, 50, null);
        Start.setLocation(50, 50);
        Quit.setLocation(50, 100);
        Quit.setLocation(150, 100);
    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == Start) {
                String playerName = textField.getText();
                Tester f = new Tester();
                f.main();
                enclosingFrame.setVisible(false);
            } else {
                enclosingFrame.setVisible(false);

            }
        }
    }
}
