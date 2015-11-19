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
import javax.swing.JComponent;

public class SpiderCanvas extends JComponent {

    private int lastXPos = 0;

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

        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int spiderWidth = 20;
        int spiderSpeed = 3;

        int xPos = lastXPos + spiderSpeed;

        if (xPos > windowWidth + spiderWidth) {
            xPos = -spiderWidth;
        }

        Image img1 = Toolkit.getDefaultToolkit().getImage("images/spider.gif");
        //gg.setColor(Color.RED);
        //gg.fillRect(x, h/2 + trainH, trainW, trainH);
        gg.drawImage(img1, xPos, windowHeight/2, this);

        lastXPos = xPos;
    }
}