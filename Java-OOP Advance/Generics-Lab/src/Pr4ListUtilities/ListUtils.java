package Pr4ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> T getMin(List<T> list) {
        checkIfTheListIsEmpty(list);
        list = list.stream().sorted().collect(Collectors.toList());
        return list.get(0);
    }

    public static <T> T getMax(List<T> list) {
        checkIfTheListIsEmpty(list);
        list = list.stream().sorted().collect(Collectors.toList());
        return list.get(list.size() - 1);
    }

    private static <T> void checkIfTheListIsEmpty(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException("Empty list!");
        }
    }

    //05. Null Finder

    public static <T> List<Integer> getNullIndices(List<T> list) {
        checkIfTheListIsEmpty(list);
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    //06. Generic Flat Method

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source) {
        for (List<? extends T> ts : source) {
            destination.addAll(ts);
        }
    }

    //07. Generic Add All Method

    public static <T> void addAll(List<? super T> destination, List<? extends T> sourse) {
        destination.addAll(sourse);
    }
}
