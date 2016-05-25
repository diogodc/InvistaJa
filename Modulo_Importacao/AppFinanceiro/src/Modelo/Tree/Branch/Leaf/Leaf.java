/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tree.Branch.Leaf;
import java.awt.List;
import java.util.Comparator;
import java.util.Vector;

/**
 *
 * @author Rafael
 */
public interface Leaf<T extends Leaf> {
     /**
     * @return the _Key
     */
    public Object getKey();
    /**
     * @param _Key the _Key to set
     */
    public void setKey(Object _Key);

    public int compare(T o2);

    public boolean inPosition(T sap);

    public boolean onLeft(T sap);

    public boolean onRight(T sap);

    public static class compareStandard
            implements Comparator<Leaf> {    

        @Override
        public int compare(Leaf o1, Leaf o2) {
            return o1.compare(o2);
        }
    }
    
    public T Get(Vector model);

    public T Get (List model) ;
}
