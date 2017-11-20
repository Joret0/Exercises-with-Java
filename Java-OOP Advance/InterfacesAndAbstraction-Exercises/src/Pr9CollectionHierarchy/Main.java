package Pr9CollectionHierarchy;

import Pr9CollectionHierarchy.interfaces.Addable;
import Pr9CollectionHierarchy.interfaces.Removable;
import Pr9CollectionHierarchy.modules.AddCollection;
import Pr9CollectionHierarchy.modules.AddRemoveCollection;
import Pr9CollectionHierarchy.modules.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split("\\s+");
        int count = Integer.parseInt(reader.readLine());

        Addable<String> addCollection = new AddCollection<>();
        Removable<String> addRemoveCollection = new AddRemoveCollection<>();
        Removable<String> myList = new MyList<>();

        executeAdd(addCollection, strings);
        executeAdd(addRemoveCollection, strings);
        executeAdd(myList, strings);

        executeRemove(addRemoveCollection, count);
        executeRemove(myList, count);
    }

    private static void executeRemove(Removable<String> collection, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void executeAdd(Addable<String> collection, String[] strings) {
        for (String string : strings) {
            System.out.print(collection.add(string) + " ");
        }
        System.out.println();
    }
}
