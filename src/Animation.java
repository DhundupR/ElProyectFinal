import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Animation implements ActionListener {
    private ArrayList<BufferedImage> frames;
    private int currentFrame;
    private Timer timer;

    public Animation(ArrayList<BufferedImage> frames, int delay){
        this.frames = frames;
        currentFrame = 0;
        timer = new Timer(delay,this);
        timer.start();
    }
    public BufferedImage getActiveFrame(){
    return frames.get(currentFrame);
        }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof Timer){
            currentFrame = (currentFrame + 1) % frames.size(); //loops the animation
        }
    }
}

/* ArrayList<BufferedImage> run_animation = new ArrayList<>();
for(int i = 1; i <=8; i++){
    String filename = "fileName copy and paste later");

 */
