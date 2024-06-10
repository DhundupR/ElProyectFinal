import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class MainCharacter {
    public boolean collide = false;
    public BufferedImage images,up1,right1,left1,down1,up2,right2,left2,down2;
    private GamePanel gp;
    private Movement move;
    public String direction = "r";
    public int defaultX,defaultY;
    private final int maxHealth = 5;
    public int currentHp = maxHealth;
    public int godTimer;
    public boolean god = false;


    public int worldY = 100;
    public int worldX =100;
    public int playerSpeed = 8;
    public Rectangle solidArea;
    public int sprite = 1;
    public int spriteTimer = 0;
    public boolean attacked = false;


    public int playerX, playerY;


    public final int screenX;
    public final int screenY;
    public Slash slash = new Slash(gp,this);
    public MainCharacter(GamePanel gp, Movement move){
        this.gp = gp;
        this.move = move;

        getSprites();
        getImage();
        solidArea = playerRect();
        defaultX = solidArea.x;
        defaultY = solidArea.y;;
        screenX = gp.screenWidth/2 - gp.tileSize;
        screenY = gp.screenHeight/2 - gp.tileSize;

    }
    public Rectangle playerRect() {
        Rectangle rect = new Rectangle(8,16,32,32);
        return rect;
    }



    public void update(){


        spriteTimer ++;


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
           int index = gp.collision.entityCollision(gp.joe,gp.mobList);

           if(attacked){

               int indexAttack = gp.collision.slashAttack(gp.joe, gp.mobList);
               if(indexAttack != -1) {
                   gp.mobList[indexAttack].attacked();
               }
           }
            attacked = false;
           contactMon(index);


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
            if(spriteTimer  > 10){
                if(sprite == 1){
                    sprite =2;
                } else {
                    sprite =1;
                }
                spriteTimer=0;
            }


            }

        if(god =true){
            godTimer++;


            if(godTimer > 10) {

                godTimer = 0;
                god = false;
            }
        }
        }

        public void contactMon(int index){
            if(index != -1 && currentHp != 0 && god == false){

                currentHp -= 1;
                god = true;
            }
        }

        public void draw(Graphics g2) {
            BufferedImage image = getImage();

            g2.drawImage(image, screenX, screenY, 64, 64, null);
            if(move.basicAttack1) {
                attacked=true;
                slash.draw(g2,screenX,screenY);
                //draws the sprite
            }



        }

        public BufferedImage getImage(){
        BufferedImage playerImage = images;
            if(sprite == 1) {
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
            }else if(sprite ==2){
                switch (direction) {
                    case "u" -> {
                        return up2;
                    }
                    case "d" -> {
                        return down2;
                    }
                    case "r" -> {
                        return right2;
                    }
                    case "l" -> {
                        return left2;
                    }
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
            up2 = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("playerSprites/up2.png"))));
            right2 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("playerSprites/right2.png"))));
            left2 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("playerSprites/left2.png"))));
            down2 =  (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("playerSprites/down2.png"))));

        }catch (Exception e){

        }
    }
}
