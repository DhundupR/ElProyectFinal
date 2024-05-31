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
        System.out.println("No you ");
        this.gp = gp;
        tile =  new Tile[16];
        mapTile = new int[960][580];
        loadMap();
        getTileImage();
    }


    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("src/mainDungeon.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            int row = 0; int col = 0;
            while(row < 960  && col < 580){
                String line = reader.readLine();
                while(col < 580){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);


                    mapTile[col][row] = num;
                    col ++;
                }
                if(col == 960){
                    col = 0;
                    row++;
                }
            }
            reader.close();
        }catch (Exception e){


        }
    }

    public void loadNewMap(String x){
        try {
            InputStream is = getClass().getResourceAsStream(x);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            int row = 0; int col = 0;
            while(row < 960  && col < 580){
                String line = reader.readLine();
                while(col < 580){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);


                    mapTile[col][row] = num;
                    col ++;
                }
                if(col == 580){
                    col = 0;
                    row++;
                }
            }
            reader.close();
        }catch (Exception e){


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
        int x = 0;
        int y = 0;
        while (col < 580 && row < 960){
            int num = mapTile[col][row];
            g2.drawImage(tile[num].image, x, y, gp.tileSize,gp.tileSize,null);
            col++;
            x+= gp.tileSize;
            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y+= gp.tileSize;
            }
        }
















    }
}

