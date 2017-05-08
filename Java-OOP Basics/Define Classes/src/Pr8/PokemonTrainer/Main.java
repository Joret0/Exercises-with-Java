package Pr8.PokemonTrainer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Trainer> trainers = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("Tournament")) {
            String[] info = input.split("\\s+");
            String trainerName = info[0];
            String pokemonName = info[1];
            String pokemonElement = info[2];
            int pokemonHealth = Integer.parseInt(info[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            boolean trainerNotExist = true;
            for (Trainer trainer : trainers) {
                if (trainer.getName().equals(trainerName)) {
                    trainer.getPokemons().add(pokemon);
                    trainerNotExist = false;
                    break;
                }
            }
            if (trainerNotExist) {
                int numberBadges = 0;
                List<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(pokemon);
                Trainer trainer = new Trainer(trainerName, numberBadges, pokemons);
                trainers.add(trainer);
            }
            input = reader.readLine();
        }

        input = reader.readLine();
        while (!input.equals("End")) {
            String element = input;
            for (Trainer trainer : trainers) {
                boolean hasNotPokemon = true;
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if (pokemon.getElement().equals(element)) {
                        int badges = trainer.getNumberBadges();
                        badges++;
                        trainer.setNumberBadges(badges);
                        hasNotPokemon = false;
                        break;
                    }
                }
                if (hasNotPokemon) {
                    for (int i = 0; i < trainer.getPokemons().size(); i++) {
                        int health = trainer.getPokemons().get(i).getHealth() - 10;
                        if (health <= 0) {
                            trainer.getPokemons().remove(i);
                        } else {
                            trainer.getPokemons().get(i).setHealth(health);
                        }
                    }
                }
            }

            input = reader.readLine();
        }

        trainers.sort(Comparator.comparing(Trainer::getNumberBadges).reversed());
        trainers.stream().forEach(System.out::println);
    }
}
