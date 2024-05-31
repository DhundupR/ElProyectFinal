import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class MainCharacter {
    public BufferedImage images;
    private GamePanel gp;
    private Movement move;
    private String direction;


    private int worldY = 1000;
    private int worldX =1000;
    private int playerSpeed = 5;
    private Rectangle solidArea;
    private boolean collide;
    private int playerX, playerY;

    private final int screenX = gp.screenWidth/2;
    private final int screenY = gp.screenHeight/2;
    public MainCharacter(GamePanel gp, Movement move){
        this.gp = gp;
        this.move = move;
        getSprites();
    }

    public void update(){
        if(move.upPressed == true || move.downPressed ==true || move.rightPressed == true|| move.leftPressed == true){
            if(move.upPressed) {
                direction = "u";
            }
             else if(move.downPressed) {
                direction = "d";
            }
            else if(move.rightPressed) {
                direction = "r";
            }
            else if(move.leftPressed) {
                direction = "l";
            }

            collide = false;

            if(!collide){
                switch (direction){
                    case "u" -> {
                        worldY += playerSpeed;
                        break;
                    }

                    case "d" -> {
                        worldY -= playerSpeed;
                        break;
                    }
                    case "r" -> {
                        worldX += playerSpeed;
                        break;
                    }
                    case "l" -> {
                        worldX -= playerSpeed;
                        break;
                    }

                }
            }

            }
        }

        public void draw(Graphics g2) {
            BufferedImage image = getImage();
            try {
                image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("player.png"))));
            } catch (Exception e){

            }
            g2.drawImage(image, playerX, playerY, 64, 64, null); //draws the sprite



        }

        public BufferedImage getImage(){
            BufferedImage playerImage = null;
            switch (direction) {
                case "u" -> {
                    return playerImage;
                }
                case "d" -> {
                    return playerImage;
                }
                case "r" -> {
                    return playerImage;
                }
                case "l" -> {
                    return playerImage;
                }
            }
            return null;
        }


    public void getSprites(){
        try{

        }catch (Exception e){

        }
    }
}
