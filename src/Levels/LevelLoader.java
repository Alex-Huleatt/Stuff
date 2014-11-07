/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Factories.FeatureFactory;
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

    private final LevelCache cached;
    private final byte[] feature_count;
    private final RandomAccessFile raf;

    public LevelLoader(int level) throws FileNotFoundException, IOException {
        raf = new RandomAccessFile(level + ".lvl", "r"); //create a new reader
        int num_chunks = raf.readByte(); //first byte of file is first 8 bits of number of level chunks
        num_chunks <<= 8;
        num_chunks = num_chunks | raf.readByte(); //second byte is second 8 bits of number of level chunks
        feature_count = new byte[num_chunks]; //create a new array for chunk-sizes
        for (byte i = 0; i < num_chunks; i++) { //for num_chunks, scan in the number of bytes for each chunk
            feature_count[i] = raf.readByte();
        }
        cached = new LevelCache(75);
    }

    public LevelChunk getChunk(int id) {
        if (cached.contains(id)) {
            return cached.get(id);
        } else {
            LevelChunk loaded = load(id);
            cached.add(id, loaded);
            return loaded;
        }
    }

    private LevelChunk load(int id) {
        int off = offset(id);
        try {
            raf.seek(off);
            byte[] feat = new byte[feature_count[id]];
            int[] neighbor_IDs = new int[8];
            for (int i = 0; i < 8; i++) {
                int nid = ((int) raf.readByte()) << 8;
                nid |= raf.readByte();
                neighbor_IDs[i] = nid;
                
            }
            for (int i = 0; i < feat.length; i++) {
                feat[i] = raf.readByte();
            }
            return new LevelChunk(id, neighbor_IDs, getFeatures(feat));
        } catch (IOException ex) {
            Logger.getLogger(LevelLoader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private int offset(int id) {
        int off = 2 + feature_count.length; //skip header bytes
        for (int i = 0; i < id; i++) {
            off += feature_count[i]*5 + 16; //+8 = 1 for each neighbor
        }
        return off;
    }

    private ArrayList<LevelFeature> getFeatures(byte[] arr) {
        if (arr.length % 5 != 0) {
            System.out.println("Level format wrong.");
        }
        ArrayList<LevelFeature> feat = new ArrayList<>();
        for (int i = 0; i < arr.length / 5; i++) {
            int index = i * 5;
            byte feat_id = arr[index];
            int x = arr[index + 1];
            x <<= 8;
            x |= arr[index + 2];
            int y = arr[index + 3];
            y <<= 8;
            y |= arr[index + 4];
            feat.add(FeatureFactory.makeFeature(feat_id, x, y));
        }

        return feat;
    }

}
