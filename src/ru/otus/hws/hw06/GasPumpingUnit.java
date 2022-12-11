package ru.otus.hws.hw06;

import java.io.IOException;
import java.util.Scanner;

public class GasPumpingUnit {
    private final Engine engine = new Engine();
    private final GasPump gasPump = new GasPump();

    public Engine getEngine() {
        return engine;
    }

    public GasPump getGasPump(){
        return gasPump;
    }

    public boolean emergencyStop() throws AnalogException {
        while (!engine.stopEngine()) ;
        return true;
    }

    public boolean setPumpingUnitMode() {
        Scanner scanner = new Scanner(System.in);

        int currentEngineRates = engine.getEngineRates().getValue();

        System.out.println("Текущие обороты двигателя: " + currentEngineRates);
        System.out.print("Ведите задание на обороты: ");
        try {
            int userRequiredRates = scanner.nextInt();
        }
        catch (Exception e) {

            System.out.println("1 " + e.getCause());

        }



        System.out.println("двигатель на заданном режиме");
        return true;

    }
}
