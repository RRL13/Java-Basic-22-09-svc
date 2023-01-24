package ru.otus.hws.hw06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EngineModel {
    private final Map<Double, Double> modelEngineSpeedByFuelValvePos = loadEngineModel("src/ru/otus/hws/hw06/EngineModel.txt");

    public EngineModel() throws IOException {
    }


    public static HashMap<Double, Double> loadEngineModel(String path) throws IOException {
        HashMap<Double, Double> modelEngineRatesByFuelValvePos = new HashMap<Double, Double>();
        try (
            FileReader f = new FileReader(path);
            BufferedReader br = new BufferedReader(f)) {
            String line = null;//br.readLine();

            int lineNumber = 0;
            double keyFuelValvePos = 0;
            double valueEngineSpeed;
            do {
                line = br.readLine();
                lineNumber ++;
                if (lineNumber % 2 !=0) {
                    keyFuelValvePos = Double.parseDouble(br.readLine());
                } else {
                    valueEngineSpeed = Double.parseDouble(br.readLine());
                    modelEngineRatesByFuelValvePos.put(keyFuelValvePos, valueEngineSpeed);
                }

            } while (line != null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return modelEngineRatesByFuelValvePos;
    }


}
