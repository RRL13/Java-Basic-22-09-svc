package ru.otus.hws.hw06;

public class BugHunter {
    public static void main(String[] args) throws AnalogException {

        AnalogSignalIO testOutput = new AnalogSignalIO(true);
        //System.out.println(testOutput.isInputSignal());
        //System.out.println(testOutput.isOutputSignal());
        testOutput.setAddress(200);
        System.out.println(testOutput.getAddress());
        System.out.println(testOutput.getValue());

        GasPumpingUnit gasPumpingUnit = new GasPumpingUnit();

        System.out.println(gasPumpingUnit.getEngine().getEngineRates().getValue());
        gasPumpingUnit.setPumpingUnitMode();
        System.out.println(gasPumpingUnit.getEngine().getEngineRates().getValue());
    }
}
