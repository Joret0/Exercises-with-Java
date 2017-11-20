package Pr8Military2;

import Pr8Military2.interfaces.*;
import Pr8Military2.modules.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, ISoldier> soldiers = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if ("End".equals(line)) {
                print();
                break;
            }
            readData(line.split("\\s+"));
        }
    }

    private static void print() {
        for (ISoldier iSoldier : soldiers.values()) {
            System.out.println(iSoldier.toString().trim());
        }
    }

    private static void readData(String[] data) {
        String type = data[0];
        switch (type) {
            case "Private":
                ISoldier privateSoldier = new Private(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]));
                soldiers.put(Integer.parseInt(data[1]), privateSoldier);
                break;
            case "LeutenantGeneral":
                ILeutenantGeneral leutenantGeneralSoldier = new LeutenantGeneral(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]));
                addPrivates(leutenantGeneralSoldier, Arrays.copyOfRange(data, 5, data.length));
                soldiers.put(Integer.parseInt(data[1]), leutenantGeneralSoldier);
                break;
            case "Engineer":
                try {
                    IEngineer engineerSoldier = new Engineer(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), data[5]);
                    addRepairs(engineerSoldier, Arrays.copyOfRange(data, 6, data.length));
                    soldiers.put(Integer.parseInt(data[1]), engineerSoldier);
                } catch (IllegalArgumentException ignored) {
                }
                break;

            case "Commando":
                try {
                    ICommando commandoSoldier = new Commando(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), data[5]);
                    addMissions(commandoSoldier, Arrays.copyOfRange(data, 6, data.length));
                    soldiers.put(commandoSoldier.getId(), commandoSoldier);
                } catch (IllegalArgumentException ignored) {
                }
                break;
            case "Spy":
                ISpy spySoldier = new Spy(Integer.parseInt(data[1]), data[2], data[3], data[4]);
                soldiers.put(Integer.parseInt(data[1]), spySoldier);
                break;
        }
    }

    private static void addMissions(ICommando commandoSoldier, String[] strings) {
        for (int i = 0; i < strings.length; i += 2) {
            String codeName = strings[i];
            String state = strings[i + 1];
            try {
                commandoSoldier.addMission(new Mission(codeName, state));
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private static void addRepairs(IEngineer engineerSoldier, String[] strings) {
        for (int i = 0; i < strings.length; i += 2) {
            String partName = strings[i];
            int hours = Integer.parseInt(strings[i + 1]);
            IRepair part = new Repair(partName, hours);
            engineerSoldier.addRepair((Repair) part);
        }
    }

    private static void addPrivates(ILeutenantGeneral soldier, String[] strings) {
        for (String currentPrivateSoldier : strings) {
            int currentPrivateSoldierId = Integer.parseInt(currentPrivateSoldier);
            soldier.addPrivate((Private) soldiers.get(currentPrivateSoldierId));
        }
    }
}
