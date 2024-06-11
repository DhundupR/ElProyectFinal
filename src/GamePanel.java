


import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class GamePanel extends JPanel implements Runnable {
    public bats[] mobList= new bats[80];
    public Chest[] chestList = new Chest[20];
    public Key[] keys = new Key[5];

    public Door[] doors = new Door[5];
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
    public HealthBar health = new HealthBar(this);




    public Graphics2D g2;
    public Graphics g;


    double fps = 60;
    Thread gameThread; //Keeps the image running and has uses later like reset screen and other stuff.


    public TileManager manager;
    public worldAdder world;



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(move);
        this.setFocusable(true);
        this.manager = new TileManager(this);
        world = new worldAdder(this);
        world.setMonster();
        world.setChest();
        world.setKeys();
        world.addDoor();







    }

    public void endGameScreen(){
        int x;
        int y;
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0,screenWidth,screenHeight);

        String text = "Game Over";

        g2.setColor(Color.black);
        x = 1000;
        y= tileSize *5;

        g2.drawString(text,x,y);

        g2.setColor(Color.white);

    }






    public void paintComponent(Graphics g){


        super.paintComponent(g); //parent class is gamePlanner
        this.g = g;
        g2 = (Graphics2D) g; //extension of graphic (has special functions)

        manager.draw(g2);
        if(joe.currentHp == 0 || doors[0] == null){
            endGameScreen();
        } else {

            for (int i = 0; i < mobList.length; i++) {

                if (mobList[i] != null) {
                    if (mobList[i].currentHp == 0) {
                        mobList[i] = null;
                    }
                    mobList[i].draw(g2);
                }
            }

            for (int i = 0; i < chestList.length; i++) {

                if (chestList[i] != null) {
                    if (chestList[i].currentUses == 0) {
                        chestList[i] = null;
                    }
                    chestList[i].draw(g2);
                }
            }

            for (int i = 0; i < keys.length; i++) {

                if (keys[i] != null) {
                    if (keys[i].currentUses == 0) {
                        keys[i] = null;
                    }
                    keys[i].draw(g2);
                }
            }

            for (int i = 0; i < doors.length; i++) {

                if (doors[i] != null) {
                    if (doors[i].currentUses == 0) {
                        doors[i] = null;
                    }
                    doors[i].draw(g2);
                }
            }
            joe.draw(g2);
            health.draw(g2);


        }
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
                for(int i = 0; i < mobList.length; i++){
                    if(mobList[i] != null){
                        mobList[i].update();
                    }
                }
                health.update();


                repaint();
                timeCheck--; //resets back to zero!
            }


        }


    }
}
