import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class MainCharacter {
    public boolean collide = false;
    public BufferedImage images,up1,right1,left1,down1;
    private GamePanel gp;
    private Movement move;
    public String direction = "r";


    public int worldY = 100;
    public int worldX =100;
    private int playerSpeed = 10;
    public Rectangle solidArea;


    public int playerX, playerY;


    public final int screenX;
    public final int screenY;
    public MainCharacter(GamePanel gp, Movement move){
        this.gp = gp;
        this.move = move;

        getSprites();
        getImage();
        solidArea = playerRect();
        screenX = gp.screenWidth/2 - gp.tileSize;
        screenY = gp.screenHeight/2 - gp.tileSize;

    }
    public Rectangle playerRect() {
        Rectangle rect = new Rectangle(16,16,gp.tileSize/2,gp.tileSize/2);
        return rect;
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

           gp.collision.tileChecker(this);

            if(!collide){
                switch (direction){
                    case "u" -> {
                        worldY -= playerSpeed;
                        break;
                    }

                    case "d" -> {
                        worldY += playerSpeed;
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

            g2.drawImage(image, screenX, screenY, 64, 64, null); //draws the sprite



        }

        public BufferedImage getImage(){
        BufferedImage playerImage = images;

            switch (direction) {
                case "u" -> {
                    return up1;
                }
                case "d" -> {
                    return down1;
                }
                case "r" -> {
                    return right1;
                }
                case "l" -> {
                    return left1;
                }
            }
            return null;
        }


    public void getSprites(){
        try{
            images = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("player.png"))));
            up1 = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("playerSprites/up1.png"))));
            right1 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("playerSprites/right1.png"))));
            left1 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("playerSprites/left1.png"))));
            down1 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("playerSprites/down1.png"))));

        }catch (Exception e){

        }
    }
}
