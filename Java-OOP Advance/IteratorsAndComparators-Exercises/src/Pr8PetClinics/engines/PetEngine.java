package Pr8PetClinics.engines;

import Pr8PetClinics.io.ConsoleInputReader;
import Pr8PetClinics.io.ConsoleOutputWriter;
import Pr8PetClinics.manager.ClinicManager;
import Pr8PetClinics.utilities.InputParser;

import java.util.List;

public class PetEngine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private ClinicManager manager;

    public PetEngine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, ClinicManager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.manager = manager;
    }

    public void run() {
        int n = Integer.parseInt(this.inputReader.readLine());
        String inputLine = this.inputReader.readLine();

        for (int i = 0; i < n; i++) {
            List<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
            inputLine = this.inputReader.readLine();
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case "Create":
                if (commandParams.remove(0).equals("Pet")) {
                    this.manager.createPet(commandParams.get(0), Integer.parseInt(commandParams.get(1)), commandParams.get(2));
                } else {
                    this.outputWriter.writeLine(this.manager.createClinic(commandParams.get(0), Integer.parseInt(commandParams.get(1))));
                }
                break;
            case "Add":
                this.outputWriter.writeLine(this.manager.add(commandParams.get(0), commandParams.get(1)));
                break;
            case "Release":
                this.outputWriter.writeLine(this.manager.release(commandParams.get(0)));
                break;
            case "HasEmptyRooms":
                this.outputWriter.writeLine(this.manager.hasEmptyRooms(commandParams.get(0)));
                break;
            case "Print":
                if (commandParams.size() == 1) {
                    this.outputWriter.writeLine(this.manager.printClinic(commandParams.get(0)));
                } else {
                    this.outputWriter.writeLine(this.manager.printClinicsRoom(commandParams.get(0), Integer.parseInt(commandParams.get(1))));
                }
                break;
        }
    }
}
