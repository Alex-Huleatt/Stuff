/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Levels;

import java.util.HashMap;

/**
 *
 * @author Alex
 */
public class LevelCache {
    private HashMap<Integer,LevelChunk> cache;
    private HashMap<Integer, Integer> prio;
    public LevelCache() {
        this.cache = new HashMap<>();
        this.prio = new HashMap<>();
    }
    
    
    public boolean contains(int ID) {
        return cache.containsKey(ID);
    }
    
    public LevelChunk get(int ID) {
        return cache.get(ID);
    }
    
    public void add(int ID, LevelChunk lc) {
        
    }
    
}
