package Pr8MilitaryElite;

import Pr8MilitaryElite.interfaces.Job;
import Pr8MilitaryElite.interfaces.PrivateImpl;
import Pr8MilitaryElite.interfaces.SpecialisedSoldierImpl;
import Pr8MilitaryElite.modules.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<PrivateImpl> privateSoldiers = new ArrayList<>();
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("End".equals(input[0])) {
                break;
            }

            switch (input[0]) {
                case "Private":
                    PrivateImpl privateSoldier = new Private(input[1], input[2], input[3], Double.parseDouble(input[4]));
                    privateSoldiers.add(privateSoldier);
                    System.out.println(privateSoldier);
                    break;
                case "LeutenantGeneral":
                    PrivateImpl leutenant = new LeutenantGeneral(input[1], input[2], input[3], Double.parseDouble(input[4]), privateSoldiers);
                    System.out.println(leutenant);
                    break;
                case "Engineer":
                    try {
                        SpecialisedSoldierImpl engineer = new Engineer(input[1], input[2], input[3], Double.parseDouble(input[4]),input[5], new HashSet<>());
                        for (int i = 6; i < input.length; i+=2) {
                            Job repair = new Repair(input[i], Integer.parseInt(input[i + 1]));
                            engineer.addJob(repair);
                        }
                        System.out.print(engineer);
                    } catch (IllegalArgumentException ex) {
                        continue;
                    }
                    break;
                case "Commando":
                    try {
                        SpecialisedSoldierImpl commando = new Commando(input[1], input[2], input[3], Double.parseDouble(input[4]), input[5], new HashSet<>());
                        for (int i = 6; i < input.length; i+=2) {
                            try {
                                Job mission = new Mission(input[i], input[i + 1]);
                                commando.addJob(mission);
                            } catch (IllegalArgumentException e) {
                                continue;
                            }
                        }
                        System.out.print(commando);
                    } catch (IllegalArgumentException ex) {
                        continue;
                    }
                    break;

            }


        }
    }
}
