package Pr5BorderControl;

public class Factory {

    static Inhabitable createInhabitant(String[] inhabitInfo) {
        Inhabitable inhabit = null;
        if (inhabitInfo.length == 2) {
            inhabit = new Robot(inhabitInfo[0], inhabitInfo[1]);
        } else if (inhabitInfo.length == 3) {
            inhabit = new Citizen(inhabitInfo[0], Integer.parseInt(inhabitInfo[1]), inhabitInfo[2]);
        }
        return inhabit;
    }
}
