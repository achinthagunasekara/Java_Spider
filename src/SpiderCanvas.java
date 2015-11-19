/*
 *
 * @author archieg
 * @date 2015.11.19
 *
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JComponent;

public class SpiderCanvas extends JComponent {

    private int lastXPos = 0;
    private int lastYPos = 0;

    public SpiderCanvas() {
        Thread animationThread;
        animationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    try {Thread.sleep(10);} catch (Exception ex) {}
                }
            }
        });
        animationThread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        Random rand = new Random();

        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int spiderWidth = 20;
        int spiderSpeed = 3;
        
        if(lastYPos == 0 || lastXPos == -spiderWidth) {
            lastYPos = rand.nextInt(windowWidth-0) + 0;
        }
        

        int xPos = lastXPos + spiderSpeed;

        if (xPos > windowWidth + spiderWidth) {
            xPos = -spiderWidth;
        }
System.out.println(xPos);
        Image img1 = Toolkit.getDefaultToolkit().getImage("images/spider.gif");
        gg.drawImage(img1, xPos, lastYPos, this);

        lastXPos = xPos;
    }
}