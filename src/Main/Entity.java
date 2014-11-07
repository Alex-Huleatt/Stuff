/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.awt.Graphics;
import struct.Point;
import struct.WorldView;
/**
 *
 * @author Alex
 */
public interface Entity {
    
    public Point getPosition();
    public void update(WorldView wv);
    public void drawSelf(Graphics g, int size, int x_offset, int y_offset);
    
}
