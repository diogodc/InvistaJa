/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tree.Branch;

import Modelo.Tree.Branch.Leaf.Leaf;

/**
 *
 * @author Rafael
 */
public class Branch<T extends Leaf> {

    private Branch _left;
    private Branch _right;
    private Branch _father;
    private Integer _level;
    private T _leaf;

    public Branch() {
        this._father = null;
        this._right = null;
        this._level = 0;
        this._leaf = null;
    }
    
    public Branch(T _leaf) {
        this._father = null;
        this._right = null;
        this._level = 0;
        this._leaf = _leaf;
    }
    
    public Branch(T _leaf, Integer _level) {
        this._father = null;
        this._right = null;
        this._level = _level;
        this._leaf = _leaf;
    }

    /**
     * @return the _left
     */
    public Branch getLeft() {
        return _left;
    }

    /**
     * @param _left the _left to set
     */
    public void setLeft(Branch _left) {
        this._left = _left;
    }

    /**
     * @return the _right
     */
    public Branch getRight() {
        return _right;
    }

    /**
     * @param _right the _right to set
     */
    public void setRight(Branch _right) {
        this._right = _right;
    }

    /**
     * @return the _father
     */
    public Branch getFather() {
        return _father;
    }

    /**
     * @param _father the _father to set
     */
    public void setFather(Branch _father) {
        this._father = _father;
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
     * @return the _leaf
     */
    public T getLeaf() {
        return _leaf;
    }

    /**
     * @param _leaf the _leaf to set
     */
    public void setLeaf(T _leaf) {
        this._leaf = _leaf;
    }
}
