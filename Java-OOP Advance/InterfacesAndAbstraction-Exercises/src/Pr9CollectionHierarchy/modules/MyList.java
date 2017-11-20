package Pr9CollectionHierarchy.modules;

import Pr9CollectionHierarchy.interfaces.Removable;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> implements Removable<T>{
    private List<T> list;

    public MyList() {
        this.list = new ArrayList<T>();
    }

    @Override
    public int add(T e) {
        this.list.add(0, e);
        return 0;
    }

    @Override
    public T remove() {
        return this.list.remove(0);
    }
}
