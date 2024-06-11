import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class MainCharacter {
    public int timer = 0;
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


    public int worldY = 2852;
    public int worldX = 228;
    public int playerSpeed = 8;
    public Rectangle solidArea;
    public int sprite = 1;
    public int spriteTimer = 0;
    public boolean attacked = false;
    public boolean glitchedAtk = false;

    public boolean hasKey = false;


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
    public void attacking(){
        int curentWorldX = worldX;
        System.out.println(worldX);
        int curentWorldY = worldY;

        int solidWidth = solidArea.width;
        int solidHeight = solidArea.height;

        switch (direction) {
            case "u" -> {
                worldY -= slash.slashArea.height;
                break;
            }

            case "d" -> {
                worldY += slash.slashArea.height;
                break;
            }
            case "r" -> {
                worldX += slash.slashArea.width;
                break;
            }
            case "l" -> {
                worldX -= slash.slashArea.width;
                break;
            }
        }


            solidArea.width = slash.slashArea.width;
            solidArea.height = slash.slashArea.height;

            int index = gp.collision.entityCollision(this, gp.mobList);
            worldX = curentWorldX ;
            worldY = curentWorldY;
            solidArea.width = solidWidth;
            solidArea.height = solidHeight;
            if(index != -1){

                attackMob(index);

            }
            attacked = false;
        }

    public void GLITCHEDattacking(){
        int curentWorldX = worldX;
        int curentWorldY = worldY;

        int solidWidth = solidArea.width;
        int solidHeight = solidArea.height;

        switch (direction) {
            case "u" -> {
                curentWorldY -= slash.slashArea.height;
                break;
            }

            case "d" -> {
                curentWorldY += slash.slashArea.height;
                break;
            }
            case "r" -> {
                curentWorldX += slash.slashArea.width;
                break;
            }
            case "l" -> {
                curentWorldX -= slash.slashArea.width;
                break;
            }
        }
        if(currentHp < 5){
            currentHp ++;
        }


        solidArea.width = slash.slashArea.width;
        solidArea.height = slash.slashArea.height;

        int index = gp.collision.entityCollision(this, gp.mobList);
        worldX = curentWorldX ;

        worldY = curentWorldY;
        solidArea.width = solidWidth;
        solidArea.height = solidHeight;
        if(index != -1){

            attackMob(index);

        }
        attacked = false;
    }


    public void attackMob(int index){
        gp.mobList[index].attacked();
    }



    public void update(){



        spriteTimer ++;

        if(attacked ){
            attacking();
        }

        if(glitchedAtk ){
            GLITCHEDattacking();
        }


        attacked = false;
        glitchedAtk = false;


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


           int chestIndex = gp.collision.entityCollision(this, gp.chestList);

            int keyIndex = gp.collision.entityCollision(this, gp.keys);

            int doorIndex = gp.collision.entityCollision(this, gp.doors);

            contactDoor(doorIndex);
            contactKeys(keyIndex);
            contactChest(chestIndex);
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

        public void contactDoor(int index){
            if(index != -1 && hasKey){
                gp.doors[index].used();
            }
        }

        public void contactKeys(int index){
        if(index != -1) {
            gp.keys[index].used();
            hasKey = true;
        }
        }

        public void contactChest(int index){
        if(index != -1){
            gp.chestList[index].used();

            int random = (int)(Math.random()* 99) + 1;
            if(random <= 25){
                playerSpeed += 5;
            }else if(random <= 50){
               if(currentHp < 5) {
                   currentHp++;
               }
            }else if(random <= 75){
                if(currentHp > 1)
                    currentHp--;

            }else {

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
            if(move.basicAttack1 ) {
                attacked=true;
                slash.draw(g2,screenX,screenY);

            }

            if(move.basicAttack2) {
                glitchedAtk=true;
                slash.draw(g2,screenX,screenY);

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
