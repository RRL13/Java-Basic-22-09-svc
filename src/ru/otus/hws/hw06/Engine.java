package ru.otus.hws.hw06;

public class Engine {

    private AnalogSignalIO engineRates = new AnalogSignalIO(10, 0, 100 ,true);
    private AnalogSignalIO fuelValvePos = new AnalogSignalIO(50, 0, 100, true);
    private AnalogSignalIO fuelValveSet = new AnalogSignalIO(20, 0 , 100 ,false);

    public AnalogSignalIO getEngineRates() {
        return engineRates;
    }


    public AnalogSignalIO getFuelValvePos() {
        return fuelValvePos;
    }

    public void setFuelValvePos(AnalogSignalIO fuelValvePos) {
        this.fuelValvePos = fuelValvePos;
    }

    public AnalogSignalIO getFuelValveSet() {
        return fuelValveSet;
    }

    public void setFuelValveSet(AnalogSignalIO fuelValveSet) {
        this.fuelValveSet = fuelValveSet;
    }

    public boolean startEngine() {
        boolean engineStarted = true;
        return engineStarted;
    }

    public boolean stopEngine() {
        while (fuelValvePos.getValue() > 0) {
            fuelValveSet.setValue(0);
        }
        boolean engineStopped = true;
        return engineStopped;
    }

    public boolean setEngineRates(int requiredRates) {
        int deltaRates = getEngineRates().getValue() - requiredRates;
        while (deltaRates < 0) {
            upEngineRates(deltaRates);
            System.out.println("поднять обороты!");
            deltaRates = getEngineRates().getValue() - requiredRates;
        }
        while (deltaRates > 0) {
            downEngineRates(deltaRates);
            System.out.println("снизить обороты!");
            deltaRates = getEngineRates().getValue() - requiredRates;
        }

        System.out.println("двигатель на заданном режиме");
        return true;

    }
    public void upEngineRates(int deltaRates) {
        for (int i = deltaRates; i < 0; i++) {
            this.fuelValvePos.setValue(this.fuelValvePos.getValue() + 1);

        }

        int imitationNewRates = this.getEngineRates().getValue() + deltaRates;
        this.engineRates.imitationSetValue(imitationNewRates);
    }
    public void downEngineRates(int deltaRates) {
        for (int i = deltaRates; i > 0; i--) {
            this.fuelValvePos.setValue(this.fuelValvePos.getValue() - 1);

        }

        int imitationNewRates = this.getEngineRates().getValue() + deltaRates;
        this.engineRates.imitationSetValue(imitationNewRates);

    }


}
