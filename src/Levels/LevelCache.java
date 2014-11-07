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
    private int cap;
    private int len;
    public LevelCache(int cap) {
        this.cache = new HashMap<>();
        this.prio = new HashMap<>();
        this.cap = cap;
        this.len = 0;
    }
    
    
    public boolean contains(int ID) {
        return cache.containsKey(ID);
    }
    
    public LevelChunk get(int ID) {
        for (Integer i : cache.keySet()) {
            prio.put(i, prio.get(i)+1);
        }
        prio.put(ID,0);
        return cache.get(ID);
    }
    
    public void add(int ID, LevelChunk lc) {
        if (len < cap) {
            cache.put(ID, lc);
            prio.put(ID, 0);
        } else {
            int max = 0;
            for (Integer i : prio.keySet()) {
                if (prio.get(i) > prio.get(max)) {
                    max = i;
                }
            }
            cache.remove(max);
            prio.remove(max);
            cache.put(ID, lc);
            prio.put(ID,0);
        }
    }
    
}
