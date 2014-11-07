/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Functions;

import java.util.ArrayList;
import struct.Point;

/**
 *
 * @author Alex
 */
public class VectorFunctions {
    
    public static Point normalize(Point p) {
        double m = magnitude(p);
        return new Point(p.x/m,p.y/m);
    }
    
    public static double magnitude(Point p) {
        return Math.sqrt(p.x*p.x+p.y*p.y);
    }
    
    public static double l2Norm(Point p1, Point p2) {
        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    
    
    private ArrayList<Point> bresenham(Point p1, Point p2) {
        ArrayList<Point> del = new ArrayList<>();
        int x1 = (int) p1.x;
        int y1 = (int) p1.y;
        int x2 = (int) p2.x;
        int y2 = (int) p2.y;
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;
        while (true) {
            del.add(new Point(x1,y1));

            int e2 = err << 1;
            if (e2 > -dy) {
                err = err - dy;
                x1 = x1 + sx;
            }
            if (x1 == x2 && y1 == y2) {
                break;
            }

            if (e2 < dx) {
                err = err + dx;
                y1 = y1 + sy;
            }
            if (x1 == x2 && y1 == y2) {
                break;
            }
        }
        del.add(p2);
        return del;
    }
}
