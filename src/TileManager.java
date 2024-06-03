import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.ArrayList;

//https://www.youtube.com/watch?v=FcdrA1LVmGY
//https://weblog.jamisbuck.org/2011/1/17/maze-generation-aldous-broder-algorithm
public class TileManager {
    GamePanel gp;
    public BufferedImage floor,wall;
    public Tile [] tile ;
    int mapTile[][];






    public TileManager(GamePanel gp){

        this.gp = gp;
        tile =  new Tile[16];
        mapTile = new int[gp.worldMaxCol][gp.worldMaxRow];

        getTileImage();
        loadMap();


    }


    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("src/mainDungeon");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            int row = 0; int col = 0;
            while(row < gp.worldMaxRow  && col < gp.worldMaxCol){
                String line = reader.readLine();
                while(col < gp.worldMaxCol){

                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);



                    mapTile[col][row] = num;
                    col ++;
                }
                if(col == gp.worldMaxCol){

                    col = 0;
                    row++;

                }
            }
            reader.close();
        }catch (NullPointerException e ){
            System.out.println("WWWWWWWHHHHHHHHHHHYYYYYYYYYYYY");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void getTileImage(){
        try {






            tile[0] = new Tile();
            tile[0].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tile/wall.png"))));
            tile[0].collision = false;
            tile[1] = new Tile();
            tile[1].image = (ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("tile/floor.png"))));
            tile[1].collision = false;










        } catch (IOException e) {
            e.printStackTrace(); //catches it if there's an error
        }
    }






    public void draw(Graphics2D g2) {
        int col =0;
        int row =0;

        while (col < gp.worldMaxCol  && row < gp.worldMaxRow){
            int num = mapTile[col][row];

            int worldX = gp.tileSize * col;
            int worldY = gp.tileSize * row;
            int screenX = worldX - gp.joe.worldX + gp.joe.screenX;
            int screenY = worldY - gp.joe.worldY + gp.joe.screenY;
            g2.drawImage(tile[num].image, screenX, screenY, gp.tileSize,gp.tileSize,null);
            col++;

            if(col == gp.worldMaxCol){
                col = 0;
                row++;
            }
        }
















    }
}

