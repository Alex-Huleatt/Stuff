/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Levels;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Alex
 */
public class LevelLoader {
    private LevelCache cached;
    private byte[] chunk_sizes;
    private final RandomAccessFile raf;
    
    public LevelLoader(int level) throws FileNotFoundException, IOException {
        raf = new RandomAccessFile(level + ".lvl", "r");
        byte num_chunks = raf.readByte();
        chunk_sizes = new byte[num_chunks];
        for (byte i = 0; i < num_chunks; i++) {
            chunk_sizes[i] = raf.readByte();
        }
    }
    
}
