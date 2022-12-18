package ru.otus.hws.hw07.tests;


import ru.otus.hws.hw07.*;
import ru.otus.hws.hw07.Asertions.*;
import ru.otus.hws.hw07.game.*;

import java.util.ArrayList;

public class Hw07GameTest01 {
    private final Dice testDice = new DiceImpl();

    public void testDiceRandom() {
        String scenario = "V01.1. тест контроля получения разных значений выпадения костей";
        try {
            int numRolls = 10;
            ArrayList<Integer> actual = new ArrayList<Integer>(numRolls);

            for (int i = 0; i < numRolls; i++) {
                actual.add(testDice.roll());

            }

            Assertions.assertLastAndActual(actual, 10);

            System.out.println("Тест " + scenario + " пройден успешно");

        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceFrom1To6() {
        String scenario = "V01.2. тест получения значения выпавшей кости от 1 до 6";
        try {
            for (int i = 0; i < 5; i++) {
                int actual = testDice.roll();
                Assertions.assertInRange(actual, 1, 6);

            }

            System.out.println("Тест " + scenario + " пройден успешно");

        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
