import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Objects;

public class Slash {
    public BufferedImage upSlash,downSlash,leftSlash,rightSlash;


    public GamePanel gp;
    public MainCharacter joe;
    public Rectangle slashArea;
    public int worldX,worldY;

    public int defaultX, defaultY;

    public Slash(GamePanel gp, MainCharacter joe){
        getSprite();
        slashArea = SlashRect();
        defaultX = slashArea.x;
        defaultY = slashArea.y;
        this.gp = gp;
        this.joe = joe;
    }

    public Rectangle SlashRect() {
        Rectangle rect = new Rectangle(40,40,50,50);
        return rect;
    }
    public void draw(Graphics g2,int x, int y){
         worldX = x;
         worldY = y;
        if(joe.direction.equals("u")){
            worldY -= 30;
            g2.drawImage(getImage(), worldX, worldY, 45, 20, null);
        } else if(joe.direction.equals("d")){
            worldY += 80;
            g2.drawImage(getImage(), worldX, worldY, 45, 20, null);
        }else if(joe.direction.equals("l")){
            worldX -= 30;
            g2.drawImage(getImage(), worldX, worldY, 20, 45, null);
        }else if(joe.direction.equals("r")){
            worldX += 80;
            g2.drawImage(getImage(), worldX, worldY, 20, 45, null);
        }



        //draws the sprite
    }

    public BufferedImage getImage(){
        BufferedImage current = null;
        if(joe.direction.equals("u")){
            current = upSlash;
        } else if(joe.direction.equals("d")){
            current = downSlash;
        }else if(joe.direction.equals("l")){
            current = leftSlash;
        }else if(joe.direction.equals("r")){
            current = rightSlash;
        }
        return current;
    }

    public void getSprite(){
        try{
            downSlash =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SlashSprites/downSlash.png"))));
            upSlash =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SlashSprites/up.png"))));
            leftSlash =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SlashSprites/leftSlash.png"))));
            rightSlash =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SlashSprites/rightSlash.png"))));

        }catch (Exception e ){
            System.out.println(e.getMessage());

        }
    }
}
