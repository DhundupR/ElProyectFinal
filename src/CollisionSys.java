public class CollisionSys {
    private GamePanel gp;
    public int tile1,tile2;

    public int left,right,top,bot;public boolean til1 = false, til2 = false;

    public String dir = "";

    public int x[][];


    public CollisionSys(GamePanel gp){
        this.gp = gp;
    }



    public void tileChecker(MainCharacter character){
        dir = "";


        til1 = false;
        til2 = false;
        int leftWorld = (character.worldX + character.solidArea.x);
        int rightWorld = (character.worldX + character.solidArea.x + character.solidArea.width);
        int topWorld = (character.worldY + character.solidArea.y);
        int botWorld = (character.worldY + character.solidArea.y + character.solidArea.height);


        left = leftWorld/ gp.tileSize;
        right = rightWorld/gp.tileSize;
        top = topWorld/gp.tileSize;
        bot = botWorld/gp.tileSize;


        switch (character.direction) { //chooses sprite based of the current direction () gets changes in update()
            case "u" -> {
                top = (topWorld - character.playerSpeed)/gp.tileSize;
                tile1 = gp.manager.mapTile[left][top];
                tile2= gp.manager.mapTile[right][top];









                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "u";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "u";
                    til2 = true;
                    character.collide = true;

                }
                break;
            }
            case "d" -> {
                bot = (botWorld + character.playerSpeed)/gp.tileSize;
                tile1 = gp.manager.mapTile[left][bot];
                tile2= gp.manager.mapTile[right][bot];
                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "d";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "d";
                    til2 = true;
                    character.collide = true;
                }
                break;
            }
            case "l" -> {
                left = (leftWorld - character.playerSpeed)/gp.tileSize;

                tile1 = gp.manager.mapTile[left][top];
                tile2= gp.manager.mapTile[left][bot];
                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "l";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "l";
                    til2 = true;
                    character.collide = true;
                }
                break;
            }
            case "r" -> {
                right = (rightWorld + character.playerSpeed)/gp.tileSize;

                tile1 = gp.manager.mapTile[right][top];
                tile2= gp.manager.mapTile[right][bot];
                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "r";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "r";
                    til2 = true;
                    character.collide = true;
                }

                break;
            }
            default -> {
            }
        };




    }

    public void tileChecker(bats character){
        dir = "";


        til1 = false;
        til2 = false;
        int leftWorld = (character.worldX + character.rec.x);
        int rightWorld = (character.worldX + character.rec.x + character.rec.width);
        int topWorld = (character.worldY + character.rec.y);
        int botWorld = (character.worldY + character.rec.y + character.rec.height);


        left = leftWorld/ gp.tileSize;
        right = rightWorld/gp.tileSize;
        top = topWorld/gp.tileSize;
        bot = botWorld/gp.tileSize;


        switch (character.dir) { //chooses sprite based of the current direction () gets changes in update()
            case "u" -> {
                top = (topWorld - character.playerSpeed)/gp.tileSize;
                tile1 = gp.manager.mapTile[left][top];
                tile2= gp.manager.mapTile[right][top];









                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "u";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "u";
                    til2 = true;
                    character.collide = true;

                }
                break;
            }
            case "d" -> {
                bot = (botWorld + character.playerSpeed)/gp.tileSize;
                tile1 = gp.manager.mapTile[left][bot];
                tile2= gp.manager.mapTile[right][bot];
                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "d";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "d";
                    til2 = true;
                    character.collide = true;
                }
                break;
            }
            case "l" -> {
                left = (leftWorld - character.playerSpeed)/gp.tileSize;

                tile1 = gp.manager.mapTile[left][top];
                tile2= gp.manager.mapTile[left][bot];
                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "l";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "l";
                    til2 = true;
                    character.collide = true;
                }
                break;
            }
            case "r" -> {
                right = (rightWorld + character.playerSpeed)/gp.tileSize;

                tile1 = gp.manager.mapTile[right][top];
                tile2= gp.manager.mapTile[right][bot];
                if(gp.manager.tile[tile1].collision == true ){character.collide = true; til1 = true; dir = "r";} if( gp.manager.tile[tile2].collision == true ){
                    dir = "r";
                    til2 = true;
                    character.collide = true;
                }

                break;
            }
            default -> {
            }
        };




    }

    public int entityCollision(MainCharacter joe, bats[] monster){
        int index = -1;
        for(int i = 0; i < monster.length; i ++){
            if(monster[i] != null){
                joe.solidArea.x =  (joe.worldX + joe.solidArea.x);
                joe.solidArea.y =  (joe.worldY + joe.solidArea.y);

                monster[i].rec.x = monster[i].worldX + monster[i].rec.x;
                monster[i].rec.y = monster[i].worldY + monster[i].rec.y;

                switch (joe.direction) { //chooses sprite based of the current direction () gets changes in update()
                    case "u" -> {
                        joe.solidArea.y -= joe.playerSpeed;
                    }

                    case "d" -> {
                        joe.solidArea.y += joe.playerSpeed;

                    }
                    case "l" -> {
                        joe.solidArea.x -= joe.playerSpeed;

                    }
                    case "r" -> {
                        joe.solidArea.x += joe.playerSpeed;
                    }




                    }
                    if (joe.solidArea.intersects(monster[i].rec)){
                        joe.collide = true;
                        index=i;
                    }

                    joe.solidArea.x = joe.defaultX;
                    joe.solidArea.y = joe.defaultY;
                    monster[i].rec.x = monster[i].defaultX;
                    monster[i].rec.y = monster[i].defaultY;

            }


        }
        return index;
    }

    public int entityCollision(bats monster, MainCharacter joe) {
        int index = -1;
        joe.solidArea.x = (joe.worldX + joe.solidArea.x);
        joe.solidArea.y = (joe.worldY + joe.solidArea.y);

        monster.rec.x = monster.worldX + monster.rec.x;
        monster.rec.y = monster.worldY + monster.rec.y;

        switch (joe.direction) { //chooses sprite based of the current direction () gets changes in update()
            case "u" -> {
                joe.solidArea.y -= joe.playerSpeed;
            }

            case "d" -> {
                joe.solidArea.y += joe.playerSpeed;

            }
            case "l" -> {
                joe.solidArea.x -= joe.playerSpeed;

            }
            case "r" -> {
                joe.solidArea.x += joe.playerSpeed;
            }


        }
        if (monster.rec.intersects(joe.solidArea)) {
            monster.collide = true;
        }
        joe.solidArea.x = joe.defaultX;
        joe.solidArea.y = joe.defaultY;
        monster.rec.x = monster.defaultX;
        monster.rec.y = monster.defaultY;
        return index;




    }


}