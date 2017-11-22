package customList;

import java.util.Collections;

public class CustomSorterClass {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        Collections.sort(customList.getList());
    }
}
