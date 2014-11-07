/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Main.Entity;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class ListFunctions {

    public static void filterOut(ArrayList<Entity> e, Class<?> cls) {
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).getClass().equals(cls)) {
                e.remove(i);
                i--;
            }
        }
    }
}
