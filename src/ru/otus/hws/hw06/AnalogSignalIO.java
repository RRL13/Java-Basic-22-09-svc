package ru.otus.hws.hw06;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class AnalogSignalIO {

    private int address = 0;
    private int lowLevel = 0;
    private int hiLevel = 100;

    private boolean isInputSignal;
    private boolean isOutputSignal = !isInputSignal;

    public int getAddress() {
        return address;
    }

    private int value = 0;

    public void setAddress(int address) {
        this.address = address;
    }

    public int getLowLevel() {
        return lowLevel;
    }

    public void setLowLevel(int lowLevel) {
        this.lowLevel = lowLevel;
    }

    public int getHiLevel() {
        return hiLevel;
    }

    public void setHiLevel(int hiLevel) {
        this.hiLevel = hiLevel;
    }

    public boolean isInputSignal() {
        return isInputSignal;
    }

    public void setInputSignal(boolean inputSignal) {
        isInputSignal = inputSignal;
    }

    public boolean isOutputSignal() {
        return isOutputSignal;
    }

    public void imitationSetValue(int value){
        this.value = value;
    }

    public int getValue() {
        value = getValueFromChannel(address);
        return value;
    }

    public void setValue(int value) {
        if (this.isOutputSignal){
            this.value = value;
        }
    }


    AnalogSignalIO(int address, int lowLevel, int hiLevel, boolean isInputSignal) {
        this.address = address;
        this.lowLevel = lowLevel;
        this.hiLevel = hiLevel;
        this.isInputSignal = isInputSignal;
        this.isOutputSignal = !isInputSignal;


    }

    AnalogSignalIO(boolean isInputSignal) {
        this(0, 0, 100, isInputSignal);
    }

    AnalogSignalIO() {
        this(0, 0, 100, true);
    }

    private int getValueFromChannel(int address) {
        // здесь должна быть функция получения ззначения из канала, но я заменил её на рандомайзер
        //прибавляю к bound адрес, как элемент ошибки (выход значения за диапазон будем считать ошибкой)
        int lastValue = this.value;

        Random random = new Random();

        try {
            value = random.nextInt(100 + address);

            if (value < lowLevel || value > hiLevel) {
                value = lastValue;
                throw new AnalogException("Значение вне диапазона", lowLevel, hiLevel, address, value);

            }

        } catch (NullPointerException | AnalogException e) {
            System.out.println(e.getMessage());
            return lowLevel;
        }
        finally {
            ;
        }



        return value;
    }

    private void setValueToChannel(int value, int address) {
        // здесь должна быть функция записи значения в канал
    }

}
