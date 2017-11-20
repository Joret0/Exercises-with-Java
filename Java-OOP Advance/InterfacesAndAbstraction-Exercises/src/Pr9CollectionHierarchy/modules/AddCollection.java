package Pr9CollectionHierarchy.modules;

import Pr9CollectionHierarchy.interfaces.Addable;

import java.util.ArrayList;
import java.util.List;

public class AddCollection<T> implements Addable<T>{

    private List<T> list;

    public AddCollection() {
        this.list = new ArrayList<T>();
    }

    @Override
    public int add(T e) {
        this.list.add(e);
        return this.list.size() - 1;
    }
}
