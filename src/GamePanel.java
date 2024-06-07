


import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class GamePanel extends JPanel implements Runnable {
    final int origTileSize = 16;
    final int scale = 4;
    final int tileSize = scale*origTileSize; // 64
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int worldMaxCol = 51;
    final int worldMaxRow = 51;
    public final int worldWidth =  tileSize * worldMaxCol;
    public final int worldHeight = tileSize * worldMaxRow;

    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public Movement move = new Movement();
    public MainCharacter joe =new MainCharacter(this,move);
    public CollisionSys collision = new CollisionSys(this);




    public Graphics2D g2;
    public Graphics g;


    double fps = 60;
    Thread gameThread; //Keeps the image running and has uses later like reset screen and other stuff.


    public TileManager manager;



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(move);
        this.setFocusable(true);
        this.manager = new TileManager(this);






    }




    public void paintComponent(Graphics g){


        super.paintComponent(g); //parent class is gamePlanner
        this.g = g;
        g2 = (Graphics2D) g; //extension of graphic (has special functions)

        manager.draw(g2);
        joe.draw(g2);









    }


    public void startGame(){ //innate the thread
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void update(){ //dont know why its opposite


    }




    @Override
    public void run() {
        double drawInter = 1000000000.0/fps;




        long lastTime = System.nanoTime();
        double timeCheck = 0;
        long currentTime;


        while(gameThread != null){ //keeps thing going until something occurs or breaks
            currentTime = System.nanoTime();
            timeCheck += (currentTime - lastTime)/ drawInter;
            lastTime = currentTime;


            if(timeCheck > 1){


               // Add update code for main Player
                joe.update();

                repaint();
                timeCheck--; //resets back to zero!
            }


        }


    }
}
