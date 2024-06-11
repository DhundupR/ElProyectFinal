import java.security.PublicKey;

public class worldAdder {
    public GamePanel gp;

    public worldAdder(GamePanel gp){
        this.gp = gp;
    }

    public void addDoor(){
     gp.doors[0] = new Door(gp);
     gp.doors[0].worldX = 1404;
     gp.doors[0].worldY = 924;
    }

    public void setKeys(){
     gp.keys[0] = new Key(gp);

     gp.keys[0].worldX = 2900;
     gp.keys[0].worldY = 2948;
    }

    public void setChest(){
     gp.chestList[0] = new Chest(gp);
     gp.chestList[0].worldX = 2252;
     gp.chestList[0].worldY = 2940;

     gp.chestList[1] = new Chest(gp);
     gp.chestList[1].worldX = 2660;
     gp.chestList[1].worldY = 2772;

     gp.chestList[2] = new Chest(gp);
     gp.chestList[2].worldX = 2660;
     gp.chestList[2].worldY = 2844;

     gp.chestList[3] = new Chest(gp);
     gp.chestList[3].worldX = 2660;
     gp.chestList[3].worldY = 3000;

     gp.chestList[4] = new Chest(gp);
     gp.chestList[4].worldX = 2660;
     gp.chestList[4].worldY = 3100;

     gp.chestList[5] = new Chest(gp);
     gp.chestList[5].worldX = 3092;
     gp.chestList[5].worldY = 2772;

     gp.chestList[6] = new Chest(gp);
     gp.chestList[6].worldX = 3092;
     gp.chestList[6].worldY = 2844;

     gp.chestList[7] = new Chest(gp);
     gp.chestList[7].worldX = 3092;
     gp.chestList[7].worldY = 3000;

     gp.chestList[8] = new Chest(gp);
     gp.chestList[8].worldX = 3092;
     gp.chestList[8].worldY = 3100;

    }

    public void setMonster(){
      gp.mobList[0]= new bats(gp);
        gp.mobList[0].worldX = 200;
        gp.mobList[0].worldY = 90;
        gp.mobList[1]= new bats(gp);
        gp.mobList[1].worldX = 110;
       gp.mobList[1].worldY = 310;

        gp.mobList[2]= new bats(gp);
        gp.mobList[2].worldX = 300;
        gp.mobList[2].worldY = 310;

        gp.mobList[4]= new bats(gp);
        gp.mobList[4].worldX = 100;
        gp.mobList[4].worldY = 200;

        gp.mobList[3]= new bats(gp);
        gp.mobList[3].worldX = 204;
        gp.mobList[3].worldY = 900;

        gp.mobList[5]= new bats(gp);
        gp.mobList[5].worldX = 332;
        gp.mobList[5].worldY = 828;

        gp.mobList[6]= new bats(gp);
        gp.mobList[6].worldX = 260;
        gp.mobList[6].worldY = 1500;

        gp.mobList[6]= new bats(gp);
        gp.mobList[6].worldX = 260;
        gp.mobList[6].worldY = 1500;

        gp.mobList[7]= new bats(gp);
        gp.mobList[7].worldX = 220;
        gp.mobList[7].worldY = 1800;

        gp.mobList[9]= new bats(gp);
        gp.mobList[9].worldX = 116;
        gp.mobList[9].worldY = 2844;

        gp.mobList[8]= new bats(gp);
        gp.mobList[8].worldX = 372;
        gp.mobList[8].worldY = 2076;

        gp.mobList[10]= new bats(gp);
        gp.mobList[10].worldX = 668;
        gp.mobList[10].worldY = 212;

        gp.mobList[11]= new bats(gp);
        gp.mobList[11].worldX = 1036;
        gp.mobList[11].worldY = 124;

        gp.mobList[12]= new bats(gp);
        gp.mobList[12].worldX = 1020;
        gp.mobList[12].worldY = 668;

        gp.mobList[13]= new bats(gp);
        gp.mobList[13].worldX = 756;
        gp.mobList[13].worldY = 844;

        gp.mobList[14]= new bats(gp);
        gp.mobList[14].worldX = 860;
        gp.mobList[14].worldY = 2316;

        gp.mobList[15]= new bats(gp);
        gp.mobList[15].worldX = 860;
        gp.mobList[15].worldY = 2316;

        gp.mobList[16]= new bats(gp);
        gp.mobList[16].worldX = 860;
        gp.mobList[16].worldY = 2316;


        gp.mobList[17]= new bats(gp);
        gp.mobList[17].worldX = 756;
        gp.mobList[17].worldY = 1556;

        gp.mobList[18]= new bats(gp);
        gp.mobList[18].worldX = 756;
        gp.mobList[18].worldY = 1556;

        gp.mobList[19]= new bats(gp);
        gp.mobList[19].worldX = 756;
        gp.mobList[19].worldY = 1556;

       gp.mobList[20]= new bats(gp);
       gp.mobList[20].worldX = 852;
       gp.mobList[20].worldY = 2900;

       gp.mobList[21]= new bats(gp);
       gp.mobList[21].worldX = 852;
       gp.mobList[21].worldY = 2900;

       gp.mobList[22]= new bats(gp);
       gp.mobList[22].worldX = 852;
       gp.mobList[22].worldY = 2900;

       gp.mobList[23]= new bats(gp);
       gp.mobList[23].worldX = 1580;
       gp.mobList[23].worldY = 2948;


     gp.mobList[24]= new bats(gp);
     gp.mobList[24].worldX = 1580;
     gp.mobList[24].worldY = 2948;

     gp.mobList[25]= new bats(gp);
     gp.mobList[25].worldX = 1580;
     gp.mobList[25].worldY = 2948;

     gp.mobList[26]= new bats(gp);
     gp.mobList[26].worldX = 1580;
     gp.mobList[26].worldY = 2948;

     gp.mobList[27]= new bats(gp);
     gp.mobList[27].worldX = 1580;
     gp.mobList[27].worldY = 2372;

     gp.mobList[28]= new bats(gp);
     gp.mobList[28].worldX = 1580;
     gp.mobList[28].worldY = 2372;

     gp.mobList[29]= new bats(gp);
     gp.mobList[29].worldX = 1580;
     gp.mobList[29].worldY = 2372;

     gp.mobList[30]= new bats(gp);
     gp.mobList[30].worldX = 2260;
     gp.mobList[30].worldY = 2188;

     gp.mobList[31]= new bats(gp);
     gp.mobList[31].worldX = 2260;
     gp.mobList[31].worldY = 2188;

     gp.mobList[32]= new bats(gp);
     gp.mobList[32].worldX = 2260;
     gp.mobList[32].worldY = 2188;

     gp.mobList[33]= new bats(gp);
     gp.mobList[33].worldX = 2260;
     gp.mobList[33].worldY = 2188;

     gp.mobList[34]= new bats(gp);
     gp.mobList[34].worldX = 2260;
     gp.mobList[34].worldY = 2188;

     gp.mobList[35]= new bats(gp);
     gp.mobList[35].worldX = 2268;
     gp.mobList[35].worldY = 444;

     gp.mobList[36]= new bats(gp);
     gp.mobList[36].worldX = 2268;
     gp.mobList[36].worldY = 444;

     gp.mobList[37]= new bats(gp);
     gp.mobList[37].worldX = 2268;
     gp.mobList[37].worldY = 444;

     gp.mobList[38]= new bats(gp);
     gp.mobList[38].worldX = 2252;
     gp.mobList[38].worldY = 1278;

     gp.mobList[39]= new bats(gp);
     gp.mobList[39].worldX = 2252;
     gp.mobList[39].worldY = 1278;

     gp.mobList[40]= new bats(gp);
     gp.mobList[40].worldX = 2252;
     gp.mobList[40].worldY = 1278;

     gp.mobList[41]= new bats(gp);
     gp.mobList[41].worldX = 2252;
     gp.mobList[41].worldY = 1278;

     gp.mobList[42]= new bats(gp);
     gp.mobList[42].worldX = 2888;
     gp.mobList[42].worldY = 247;

     gp.mobList[43]= new bats(gp);
     gp.mobList[43].worldX = 2888;
     gp.mobList[43].worldY = 247;

     gp.mobList[44]= new bats(gp);
     gp.mobList[44].worldX = 2888;
     gp.mobList[44].worldY = 247;

     gp.mobList[45]= new bats(gp);
     gp.mobList[45].worldX = 2888;
     gp.mobList[45].worldY = 247;

     gp.mobList[50]= new bats(gp);
     gp.mobList[50].worldX = 2888;
     gp.mobList[50].worldY = 1410;

     gp.mobList[46]= new bats(gp);
     gp.mobList[46].worldX = 2888;
     gp.mobList[46].worldY = 1410;

     gp.mobList[47]= new bats(gp);
     gp.mobList[47].worldX = 2888;
     gp.mobList[47].worldY = 1410;

     gp.mobList[48]= new bats(gp);
     gp.mobList[48].worldX = 2888;
     gp.mobList[48].worldY = 1410;

     gp.mobList[49]= new bats(gp);
     gp.mobList[49].worldX = 2888;
     gp.mobList[49].worldY = 1410;

     gp.mobList[51]= new bats(gp);
     gp.mobList[51].worldX = 2888;
     gp.mobList[51].worldY = 2082;

     gp.mobList[52]= new bats(gp);
     gp.mobList[52].worldX = 2888;
     gp.mobList[52].worldY = 2082;

     gp.mobList[53]= new bats(gp);
     gp.mobList[53].worldX = 2888;
     gp.mobList[53].worldY = 2082;

     gp.mobList[54]= new bats(gp);
     gp.mobList[54].worldX = 2888;
     gp.mobList[54].worldY = 2082;

     gp.mobList[55]= new bats(gp);
     gp.mobList[55].worldX = 2888;
     gp.mobList[55].worldY = 2082;

     gp.mobList[56]= new bats(gp);
     gp.mobList[56].worldX = 2888;
     gp.mobList[56].worldY = 2082;

     gp.mobList[57]= new bats(gp);
     gp.mobList[57].worldX = 1532;
     gp.mobList[57].worldY = 1260;

     gp.mobList[58]= new bats(gp);
     gp.mobList[58].worldX = 1532;
     gp.mobList[58].worldY = 1260;

     gp.mobList[59]= new bats(gp);
     gp.mobList[59].worldX = 1532;
     gp.mobList[59].worldY = 1260;

     gp.mobList[60]= new bats(gp);
     gp.mobList[60].worldX = 1532;
     gp.mobList[60].worldY = 1260;

     gp.mobList[61]= new bats(gp);
     gp.mobList[61].worldX = 1532;
     gp.mobList[61].worldY = 1828;

     gp.mobList[62]= new bats(gp);
     gp.mobList[62].worldX = 1532;
     gp.mobList[62].worldY = 1828;

     gp.mobList[63]= new bats(gp);
     gp.mobList[63].worldX = 1532;
     gp.mobList[63].worldY = 1828;




    }
}
