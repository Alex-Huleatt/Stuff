/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Factories;

import Main.Entity;

/**
 *
 * @author Alex
 */
public final class EntityFactory {
    public static Entity make(String type) {
        switch (type) {
            //Insert types here
            default: return null;
        }
    }
    
}
