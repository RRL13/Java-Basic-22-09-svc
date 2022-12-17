package ru.otus.hws.hw06;

public class Engine {

    private AnalogSignalIO engineSpeed = new AnalogSignalIO(10, 0, 100 ,true);
    private AnalogSignalIO fuelValvePos = new AnalogSignalIO(50, 0, 100, true);
    private AnalogSignalIO fuelValveSet = new AnalogSignalIO(20, 0 , 100 ,false);

    public AnalogSignalIO getEngineSpeed() {
        return engineSpeed;
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



    public boolean setEngineRates(int requiredSpeed) {
        int deltaSpeed = getEngineSpeed().getValue() - requiredSpeed;
        while (deltaSpeed < 0) {
            upEngineSpeed(deltaSpeed);
            System.out.println("поднять обороты!");
            deltaSpeed = getEngineSpeed().getValue() - requiredSpeed;
        }
        while (deltaSpeed > 0) {
            downEngineSpeed(deltaSpeed);
            System.out.println("снизить обороты!");
            deltaSpeed = getEngineSpeed().getValue() - requiredSpeed;
        }

        System.out.println("двигатель на заданном режиме");
        return true;

    }
    public void upEngineSpeed(int deltaSpeed) {
        for (int i = deltaSpeed; i < 0; i++) {
            this.fuelValvePos.setValue(this.fuelValvePos.getValue() + 1);

        }

        int imitationNewSpeed = this.getEngineSpeed().getValue() + deltaSpeed;
        this.engineSpeed.imitationSetValue(imitationNewSpeed);
    }
    public void downEngineSpeed(int deltaSpeed) {
        for (int i = deltaSpeed; i > 0; i--) {
            this.fuelValvePos.setValue(this.fuelValvePos.getValue() - 1);

        }

        int imitationNewSpeed = this.getEngineSpeed().getValue() + deltaSpeed;
        this.engineSpeed.imitationSetValue(imitationNewSpeed);

    }


}
