/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tree.Branches;

import Modelo.Tree.Branches.Sap.Sap;

/**
 *
 * @author Rafael
 * @param <T>
 */
public class Branches<T extends Sap> {

    public Branches _left;
    public Branches _right;
    public Branches _above;
    public Integer _level;
    public T _sap;

    public Branches() {
        this._above = null;
        this._left = null;
        this._right = null;
        this._level = 0;
        this._sap = null;
    }

    public Branches(Branches above) {
        this._above = above;
        this._left = null;
        this._right = null;
        this._level = 0;
        this._sap = null;
    }

    public Branches(Branches above, Integer level) {
        this._above = above;
        this._left = null;
        this._right = null;
        this._level = level;
        this._sap = null;
    }

    public Branches(Branches above, Integer level, T sap) {
        this._above = above;
        this._left = null;
        this._right = null;
        this._level = level;
        this._sap = sap;
    }    
   
    /**
     * @return the _left
     */
    public Branches getLeft() {
        return _left;
    }

    /**
     * @param _left the _left to set
     */
    public void setLeft(Branches _left) {
        this._left = _left;
    }

    /**
     * @return the _right
     */
    public Branches getRight() {
        return _right;
    }

    /**
     * @param _right the _right to set
     */
    public void setRight(Branches _right) {
        this._right = _right;
    }

    /**
     * @return the _above
     */
    public Branches getAbove() {
        return _above;
    }

    /**
     * @param _above the _above to set
     */
    public void setAbove(Branches _above) {
        this._above = _above;
    }

    /**
     * @return the _level
     */
    public Integer getLevel() {
        return _level;
    }

    /**
     * @param _level the _level to set
     */
    public void setLevel(Integer _level) {
        this._level = _level;
    }

    /**
     * @return the _sap
     */
    public T getSap() {
        return _sap;
    }

    /**
     * @param _sap the _sap to set
     */
    public void setSap(T _sap) {
        this._sap = _sap;
    }

}
