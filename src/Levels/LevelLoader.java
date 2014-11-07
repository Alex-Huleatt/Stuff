/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Levels;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class LevelLoader {
    private LevelCache cached;
    private byte[] chunk_sizes;
    private final RandomAccessFile raf;
    
    public LevelLoader(int level) throws FileNotFoundException, IOException {
        raf = new RandomAccessFile(level + ".lvl", "r"); //create a new reader
        byte num_chunks = raf.readByte(); //first byte of file is number of level chunks
        chunk_sizes = new byte[num_chunks]; //create a new array for chunk-sizes
        for (byte i = 0; i < num_chunks; i++) { //for num_chunks, scan in the number of bytes for each chunk
            chunk_sizes[i] = raf.readByte();
        }
    }
    
    public LevelChunk getChunk(int id) {
        if (cached.contains(id)) return cached.get(id);
        else {
            LevelChunk loaded = load(id);
            cached.add(id, loaded);
            return loaded;
        }
    }
    
    private LevelChunk load(int id) {
        int off = offset(id);
        try {
            raf.seek(off);
            byte[] feat = new byte[chunk_sizes[id]];
            byte[] neighbor_IDs = new byte[4];
            for (int i = 0; i < 4; i++) {
                neighbor_IDs[i] = raf.readByte();
            }
            for (int i = 0; i < feat.length; i++) {
                feat[i] = raf.readByte();
            }
            return new LevelChunk(id, neighbor_IDs, getFeatures(feat));
        } catch (IOException ex) {
            Logger.getLogger(LevelLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
    private int offset(int id) {
        int off = 1 + chunk_sizes.length; //skip header bytes
        for (int i = 0; i < id; i++) {
            off += chunk_sizes[i] + 4; //+4 for each neighbor
        }
        return off;
    }
    
    private ArrayList<LevelFeature> getFeatures(byte[] arr) {
        
        
        return null;
    }
    
}
