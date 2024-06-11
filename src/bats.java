import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class bats {
    public BufferedImage animation1,animation2;
    public int playerSpeed;
    public GamePanel gp;
    public int worldY = 0;
    public int worldX =0;

    public String dir = "1";
    public Rectangle rec;
    public int actionTimer= 0;
    public int spriteTimer = 0;
    public int sprite = 1;
    public int maxHp = 3;
    public int currentHp;
    public boolean collide;
    public int defaultX, defaultY;


    public bats(GamePanel gp){
        getSprites();
        this.gp = gp;
        playerSpeed = 2;
        rec = batRect();
        defaultX = rec.x;
        defaultY = rec.y;;
        currentHp = maxHp;


    }
    public void draw(Graphics g2){


        int screenX = worldX - gp.joe.worldX + gp.joe.screenX;
        int screenY = worldY - gp.joe.worldY + gp.joe.screenY;
        BufferedImage image = getImage();

        g2.drawImage(image, screenX, screenY, 64, 64, null); //draws the sprite
    }
    public Rectangle batRect() {
        Rectangle rect = new Rectangle(3,8,32,32);
        return rect;
    }

    public void attacked(){
        currentHp --;
    }

    public void update(){


        action();

        collide = false;

        gp.collision.tileChecker(this);
        gp.collision.entityCollision(this,gp.joe);

        if(!collide){
            switch (dir){
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
        spriteTimer++;
        if(spriteTimer  > 10){
            if(sprite == 1){
                sprite =2;
            } else {
                sprite =1;
            }
            spriteTimer=0;
        }
    }

    public void action(){

        actionTimer ++;
        if(actionTimer > 70){
            int random = (int)(Math.random()* 99) + 1;
            if(random <= 25){
                dir = "u";
            }else if(random <= 50){
                dir = "d";
            }else if(random <= 75){
                dir = "r";
            }else {
                dir = "l";
            }
            actionTimer =0;
        }
    }

    public BufferedImage getImage() {
        BufferedImage playerImage = animation1;
        if(sprite == 1) {
            return animation1;

        }else if(sprite ==2){
            return animation2;

        } else{
            return null;
        }
    }

    public void getSprites(){
        try{
            animation1 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/batSprites/an1.png"))));
            animation2 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/batSprites/an2.png"))));

        }catch (Exception e ){
                System.out.println(e.getMessage());

        }
    }
}
