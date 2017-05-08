package Pr8.PokemonTrainer;


import java.util.List;

public class Trainer {
    private String name;
    private int numberBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, int numberBadges, List<Pokemon> pokemons) {
        this.name = name;
        this.numberBadges = numberBadges;
        this.pokemons = pokemons;
    }

    public String getName() {
        return this.name;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getNumberBadges() {
        return this.numberBadges;
    }

    public void setNumberBadges(int numberBadges) {
        this.numberBadges = numberBadges;
    }

    public String toString() {
        return String.format("%s %d %d", this.name, this.numberBadges, this.pokemons.size());
    }
}
