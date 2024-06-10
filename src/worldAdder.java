public class worldAdder {
    public GamePanel gp;

    public worldAdder(GamePanel gp){
        this.gp = gp;
    }

    public void setMonster(){
//        gp.mobList[0]= new bats(gp);
//        gp.mobList[0].worldX = 200;
//        gp.mobList[0].worldY = 90;
        gp.mobList[1]= new bats(gp);
        gp.mobList[1].worldX = 110;
       gp.mobList[1].worldY = 310;
    }
}
