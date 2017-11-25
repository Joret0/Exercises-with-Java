package Pr8PetClinics;

import Pr8PetClinics.engines.PetEngine;
import Pr8PetClinics.io.ConsoleInputReader;
import Pr8PetClinics.io.ConsoleOutputWriter;
import Pr8PetClinics.manager.ClinicManager;
import Pr8PetClinics.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        ClinicManager gameManager = new ClinicManager();
        PetEngine engine = new PetEngine(inputReader, outputWriter, inputParser, gameManager);
        engine.run();
    }
}
