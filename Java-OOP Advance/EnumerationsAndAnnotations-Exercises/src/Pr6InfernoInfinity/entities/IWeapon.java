package Pr6InfernoInfinity.entities;

public interface IWeapon extends Comparable<Weapon>{
    void add(int index, Gem gem);

    void remove(int index);

    String print();

    String getItemLevelFormattedOutput();

    int compareTo(Weapon o);
}
