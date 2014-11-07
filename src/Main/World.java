/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class World {

    private static final int TARGET_FPS = 60;
    private ArrayList<Entity> entities;
    
    public void run() {
        long c = System.currentTimeMillis();
        long old = System.currentTimeMillis();
        while (true) {
            while (c < old + 1000/TARGET_FPS) {
                c = System.currentTimeMillis();
            }
            update();
            render();
        }
    }
    
    private void update() {
        
    }
    
    private void render() {
        
    }
}
