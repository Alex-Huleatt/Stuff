/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Levels;

import java.util.ArrayList;
import struct.Point;

/**
 * Represents a discrete portion of a level.
 * @author Alex
 */
public class LevelChunk {
    private final int ID;
    private final byte[] neighbor_IDs;
    private Point posn;
    private ArrayList<LevelFeature> features;
    
    public LevelChunk(int ID, byte[] neighbor_IDs, ArrayList<LevelFeature> features) {
        this.ID = ID;
        this.neighbor_IDs = neighbor_IDs;
        this.features = features;   
    }
    
    
}
