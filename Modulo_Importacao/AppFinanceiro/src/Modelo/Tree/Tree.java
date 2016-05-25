/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tree;

import Modelo.Tree.Branch.Branch;
import Modelo.Tree.Branch.Leaf.Leaf;


/**
 *
 * @author Rafael
 */
public class Tree<T extends Leaf> {

    private Branch<T> _trunk;

    public Tree() {
        this._trunk = null;
    }

    public boolean isEmpty() {
        return this._trunk == null;
    }

    public void add(T leaf) {
        Branch<T> _branch = new Branch(leaf);
        if (this.isEmpty()) {
            this._trunk = _branch;
        } else {
            this.add(this._trunk, _branch);
        }
    }

    protected void add(Branch<T> _father, Branch<T> _branch) {
        if (_branch.getLeaf().onLeft(_father.getLeaf())) {
            if (_father.getLeft() == null) {
                _branch.setLevel(_father.getLevel() + 1);
                _father.setLeft(_branch);

            } else {
                this.add(_father.getLeft(), _branch);
            }
        } else if (_father.getRight() == null) {
            _branch.setLevel(_father.getLevel() + 1);
            _father.setRight(_branch);
        } else {
            this.add(_father.getRight(), _branch);
        }
    }

    public void inOrder() {
        this.inOrder(this._trunk, "    ");
    }

    protected void inOrder(Branch<T> _branch, String predescessor) {
        if (_branch != null) {
            String _pred = " (LEVEL " + +_branch.getLevel() + ") ";
            this.inOrder(_branch.getLeft(), "(LEFT) " + _pred + predescessor + "      ");
            System.out.println("  " + predescessor + " (" + _branch.getLeaf().getKey() + ") ===== (LEVEL " + _branch.getLevel() + ") ");
            this.inOrder(_branch.getRight(), "(RIGHT) " + _pred + predescessor + "      ");
        }
    }

    public void preOrder() {
        this.preOrder(this._trunk, "");
    }

    protected void preOrder(Branch<T> _branch, String predescessor) {
        if (_branch != null) {
            Boolean child = false;
            System.out.println(predescessor + "Branch:  (LEVEL " + _branch.getLevel() + ")");
            if (_branch.getLeft() != null) {
                System.out.print(predescessor + "<(LEFT)");
                preOrder(_branch.getLeft(), predescessor + "========");
                child = true;
                if (predescessor == "") {
                    System.out.println("");
                }

                System.out.print(predescessor + ">");
            }

            if (_branch.getRight() != null) {

                if (child) {
                    System.out.print(predescessor + ",");
                }

                if (predescessor == "") {
                    System.out.println("");
                }

                System.out.print(predescessor + "<(RIGHT) ");
                preOrder(_branch.getRight(), predescessor + "========");

                if (predescessor == "") {
                    System.out.println("");
                }

                System.out.print(predescessor + "> ");

            }

        }
    }

    public void posOrder() {
        this.posOrder(this._trunk, "");
    }

    protected void posOrder(Branch<T> _branch, String predescessor) {
        if (_branch != null) {
            Boolean child = false;
            if (_branch.getLeft() != null) {
                System.out.print(predescessor + "<(LEFT)");
                preOrder(_branch.getLeft(), predescessor + "========");
                child = true;
                if (predescessor == "") {
                    System.out.println("");
                }

                System.out.print(predescessor + ">");
            }

            if (_branch.getRight() != null) {

                if (child) {
                    System.out.print(predescessor + ",");
                }

                if (predescessor == "") {
                    System.out.println("");
                }

                System.out.print(predescessor + "<(RIGHT) ");
                preOrder(_branch.getRight(), predescessor + "========");

                if (predescessor == "") {
                    System.out.println("");
                }

                System.out.print(predescessor + "> ");

            }

            System.out.println(predescessor + "Branch:  (LEVEL " + _branch.getLevel() + ")");
        }
    }
}
