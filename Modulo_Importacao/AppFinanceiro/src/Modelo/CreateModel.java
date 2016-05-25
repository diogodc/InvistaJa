/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import Modelo.Tree.Branch.Leaf.Leaf;
import java.awt.List;
import java.util.Vector;

/**
 *
 * @author Rafael
 * @param <T>
 */
public class CreateModel<T extends Leaf> {

    private final T _model;

    public CreateModel(T model) {
        this._model = model;
    }

    public T Get(Vector model) {
        return (T) _model.Get(model);
    }

    public T Get(List model) {
        return (T) _model.Get(model);
    }

}
