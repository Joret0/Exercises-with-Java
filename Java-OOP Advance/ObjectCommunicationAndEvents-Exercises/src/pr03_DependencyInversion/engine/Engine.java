package pr03_DependencyInversion.engine;

import pr03_DependencyInversion.calculator.Calculator;
import pr03_DependencyInversion.strategies.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable{
    private static final String MODE = "mode";
    private BufferedReader in;
    private Calculator calculator;


    public Engine(Calculator calculator) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.calculator = calculator;
    }

    @Override
    public void run() {
        try {
            String line = in.readLine();
            while (true) {
                if ("End".equals(line)) break;
                String[] data = line.split(" ");

                if (data[0].equals(MODE))
                    this.changeStrategy(data);
                else
                    this.performCalculation(data);

                line = in.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void performCalculation(String[] data) {
        System.out.println(this.calculator.performCalculation(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
    }

    private void changeStrategy(String[] data) {
        Strategy strategy = null;
        switch (data[1]) {
            case "+":
                strategy = new AdditionStrategy();
                break;
            case "-":
                strategy = new SubtractionStrategy();
                break;
            case "*":
                strategy = new MultiplicationStrategy();
                break;
            case "/":
                strategy = new DivisionStrategy();
                break;
        }
        this.calculator.changeStrategy(strategy);
    }
}
