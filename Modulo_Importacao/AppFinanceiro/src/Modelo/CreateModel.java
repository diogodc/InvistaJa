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
    private String _searchOption;
    private Object _search;

    public CreateModel(T model) {
        this._model = model;
        this._search = "";
    }

    public CreateModel(T model, String searchOption) {
        this._model = model;
        this._searchOption = searchOption;
        this._search = "";
    }

    public T Get(Vector model) {
        return (T) getModel().Get(model);
    }

    public T Get(List model) {
        return (T) getModel().Get(model);
    }

    /**
     * @return the _model
     */
    public T getModel() {
        return _model;
    }

    /**
     * @return the _searchOption
     */
    public String searchOption() {
        return _searchOption;
    }

    /**
     * @return the _search
     */
    public Object getSearch() {
        return _search;
    }

    /**
     * @param _search the _search to set
     */
    public void setSearch(Object _search) {
        this._search = _search;
    }

}
