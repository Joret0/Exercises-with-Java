package Pr5BorderControl;

import java.util.List;

public class City {

    private List<Inhabitable> inhabitables;

    public City(List<Inhabitable> inhabitables) {
        this.inhabitables = inhabitables;
    }

    public void addInhabit(Inhabitable inhabitable) {
        this.inhabitables.add(inhabitable);
    }

    public void printFakeId(String fakeIds) {
        for (Inhabitable inhabitable : inhabitables) {
            String subId = inhabitable.getId().substring(inhabitable.getId().length() - fakeIds.length());
            if (fakeIds.equals(subId)) {
                System.out.println(inhabitable.getId());
            }
        }
    }
}
