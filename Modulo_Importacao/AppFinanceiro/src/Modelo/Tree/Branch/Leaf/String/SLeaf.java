/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tree.Branch.Leaf.String;

import Modelo.Tree.Branch.Leaf.Leaf;
import java.awt.List;
import java.util.Vector;

/**
 *
 * @author Rafael
 */
public class SLeaf implements Leaf<SLeaf> {

    private String _key;

    @Override
    public Object getKey() {
        return _key;
    }

    @Override
    public void setKey(Object _Key) {
        this._key = (String) _Key;
    }

    @Override
    public int compare(SLeaf o2) {
        String _Key_1 = String.valueOf(this.getKey());
        String _Key_2 = String.valueOf(o2.getKey());
        
        if(_Key_1.equals(_Key_2)){
            return 0;
        }        
        
        return _Key_1.compareTo(_Key_2);
    }

    @Override
    public boolean inPosition(SLeaf sap) {
        return this.compare(sap) == 0;
    }

    @Override
    public boolean onLeft(SLeaf sap) {
        return this.compare(sap) < 0;
    }

    @Override
    public boolean onRight(SLeaf sap) {
        return this.compare(sap) >= 0;
    }

    @Override
    public SLeaf Get(Vector model) {
        return null;
    }

    @Override
    public SLeaf Get(List model) {
       return null;
    }

    @Override
    public Vector parseVector() {
       return null;
    }

}
