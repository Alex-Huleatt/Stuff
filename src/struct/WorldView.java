/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct;

import Functions.VectorFunctions;
import Main.Entity;
import java.util.ArrayList;

/**
 * This class is responsible for providing information to other entities.
 *
 * @author Alex
 */
public final class WorldView {

    private final ArrayList<Entity> all;
    private final int width;
    private final int height;

    public WorldView(ArrayList<Entity> all, int width, int height) {
        this.all = all;
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<Entity> entitiesInRange(Point p, double range) {
        ArrayList<Entity> e = new ArrayList<>();
        for (Entity a : all) {
            if (VectorFunctions.l2Norm(p, a.getPosition()) <= range) {
                e.add(a);
            }
        }
        return e;
    }

}
