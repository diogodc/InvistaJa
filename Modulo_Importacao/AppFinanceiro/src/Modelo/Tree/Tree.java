/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tree;

import Modelo.Tree.Branches.Branches;
import Modelo.Tree.Branches.Sap.Sap;

/**
 *
 * @author Rafael
 */
public class Tree< T extends Sap> {

    private Branches<T> _trunk;

    public Tree() {
        this._trunk = null;
    }

    public boolean isEmpty() {
        return this._trunk == null;
    }

    public void add(T sap) {
        Branches<T> _branches = new Branches(null, 0, sap);
        if (this.isEmpty()) {
            this._trunk = _branches;
        } else {
            this.add(this._trunk, _branches);
        }
    }

    protected void add(Branches _above, Branches _branches) {
        if (_branches.getSap().onLeft(_above.getSap())) {
            if (_above.getLeft() == null) {
                _branches.setLevel(_above.getLevel() + 1);
                _above.setLeft(_branches);

            } else {
                this.add(_above.getLeft(), _branches);
            }
        } else {
            if (_above.getRight() == null) {
                _branches.setLevel(_above.getLevel() + 1);
                _above.setRight(_branches);
            } else {
                this.add(_above.getRight(), _branches);
            }
        }
    }

    public T search(Long Key) {
        return this.search(this._trunk, new Sap(Key));
    }

    protected T search(Branches<T> _branches, Sap _search) {
        T sap = null;

        if (_branches != null) {
            if (_branches.getSap().inPosition(_search)) {
                sap = _branches.getSap();
            } else if (_branches.getSap().onLeft(_search)) {
                sap = (T) this.search(_branches.getLeft(), _search);
            } else if (_branches.getSap().onRight(_search)) {
                sap = (T) this.search(_branches.getRight(), _search);
            }
        }

        return sap;
    }

    public void inOrder() {
        this.inOrder(this._trunk, "    ");
    }

    protected void inOrder(Branches _branches, String predescessor) {
        if (_branches != null) {
            String _pred = " (LEVEL " + +_branches.getLevel() + ") ";
            this.inOrder(_branches.getLeft(), "(LEFT) " + _pred + predescessor + "      ");
            System.out.println("  " + predescessor + " (" + _branches.getSap().Key() + ") ===== (LEVEL " + _branches.getLevel() + ") ");
            this.inOrder(_branches.getRight(), "(RIGHT) " + _pred + predescessor + "      ");
        }
    }

}
