package Pr6BirthdayCelebrations;


import java.util.List;

public class City {

    private List<Inhabitable> inhabitantList;

    public City(List<Inhabitable> inhabitantList) {
        this.inhabitantList = inhabitantList;
    }

    public void printFakeId(String fakeIds) {
        for (Inhabitable inhabitable : inhabitantList) {
            String subId = inhabitable.getId().substring(inhabitable.getId().length() - fakeIds.length());
            if (fakeIds.equals(subId)) {
                System.out.println(inhabitable.getId());
            }
        }
    }

    public void printYear(String year) {
        for (Inhabitable inhabitant : inhabitantList) {
            String subYear = inhabitant.getYear().substring(inhabitant.getYear().length() - year.length());
            if (subYear.equals(year)) {
                System.out.println(inhabitant.getYear());
            }
        }
    }

    public void addInhabit(Inhabitable inhabitant) {
        this.inhabitantList.add(inhabitant);
    }
}
