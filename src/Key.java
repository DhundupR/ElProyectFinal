import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Key {
    public BufferedImage Key;
    public GamePanel gp;
    public int worldY = 0;
    public int worldX =0;

    public int currentUses = 1;


    public Rectangle rec;

    public boolean collide;
    public int defaultX, defaultY;


    public Key(GamePanel gp){
        getSprites();
        this.gp = gp;
        rec = batRect();
        defaultX = rec.x;
        defaultY = rec.y;;



    }

    public void used(){

        currentUses --;
    }
    public void draw(Graphics g2){


        int screenX = worldX - gp.joe.worldX + gp.joe.screenX;
        int screenY = worldY - gp.joe.worldY + gp.joe.screenY;
        BufferedImage image = Key;

        g2.drawImage(image, screenX, screenY, 70, 50, null); //draws the sprite
    }
    public Rectangle batRect() {
        Rectangle rect = new Rectangle(3,8,150,300);
        return rect;
    }

    public void getSprites(){
        try{
            Key =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/key.png"))));


        }catch (Exception e ){
            System.out.println(e.getMessage());

        }

    }
}