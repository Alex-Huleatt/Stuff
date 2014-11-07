/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Display;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class Frame extends JFrame {
    
    private Panel panel;
    
    public Frame(int width, int height) {
        super();
        this.panel = new Panel();
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setSize(width, height);
        setVisible(true);
    }
    
}
