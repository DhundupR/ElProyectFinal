import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class HealthBar {
    public BufferedImage hp1,hp2,hp3,hp4,hp5,hp6;
    public BufferedImage currentImage;
    public GamePanel gp;
    public HealthBar(GamePanel gp){
        getSprites();
        this.gp = gp;
        currentImage = hp6;
    }
    public BufferedImage getImage(){
        BufferedImage image = null;
        if(gp.joe.currentHp == 5){
            image = hp6;
        } else if(gp.joe.currentHp == 4){
            image = hp5;
        }else if(gp.joe.currentHp == 3){
            image = hp4;
        }else if(gp.joe.currentHp == 2){
            image = hp3;
        }else if(gp.joe.currentHp == 1){
            image = hp2;
        }else if(gp.joe.currentHp == 0){
            image = hp1;
        } else {

        }
        return image;
    }

    public void draw(Graphics g2){


        g2.drawImage(currentImage, -5, -55, 400, 200, null); //draws the sprite
    }
    public void update(){
        currentImage = getImage();
    }

    public void getSprites(){
        try{
            hp1 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/healthSprites/hp1.png"))));
            hp2 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/healthSprites/hp2.png"))));
            hp3 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/healthSprites/hp3.png"))));
            hp4 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/healthSprites/hp4.png"))));
            hp5 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/healthSprites/hp5.png"))));
            hp6 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/healthSprites/hp6.png"))));
        }catch (Exception e ){
            System.out.println(e.getMessage());



        }
    }



}
