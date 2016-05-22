/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Tree.Branches.Sap;

import java.util.Comparator;

/**
 *
 * @author Rafael
 */
public class Sap {

    private Long _Key;

    public Sap() {

    }

    public Sap(Long Key) {
        this._Key = Key;
    }

    public Long Key() {
        return this._Key;
    }

    public int compare(Sap sap) {
        return new compareStandard().compare(this, sap);
    }

    public boolean inPosition(Sap sap) {
        return this.compare(sap) == 0;
    }

    public boolean onLeft(Sap sap) {
        return this.compare(sap) < 0;
    }

    public boolean onRight(Sap sap) {
        return this.compare(sap) >= 0;
    }

    public static Comparator inOrder() {
        return (Comparator) new compareStandard();
    }

    public static class compareStandard
            implements Comparator<Sap> {

        @Override
        public int compare(Sap o1, Sap o2) {
            return o1.Key().compareTo(o2.Key());
        }
    }
}
