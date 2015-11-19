/*
 *
 * @author archieg
 * @date 2015.11.19
 *
 */

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class JavaSpider {
    
    public static void main(String[] args) {
        
        String[] supportedOSs = { "mac os x" };
        String osName = System.getProperty("os.name").toLowerCase();
        
        if(!Arrays.asList(supportedOSs).contains(osName)) {
            
            JOptionPane.showMessageDialog(null, "Your OS '" + osName + "' is not supported", "OS Not Supported", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JFrame frame = new JFrame("Train Demo");
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setAlwaysOnTop(true);
        frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(new SpiderCanvas());
        frame.setVisible(true);
    }
}