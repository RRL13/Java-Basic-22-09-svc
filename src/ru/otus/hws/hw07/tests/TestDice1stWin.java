package ru.otus.hws.hw07.tests;

import ru.otus.hws.hw07.game.Dice;

public class TestDice1stWin implements Dice {
    int numCall = 0;

    @Override
    public int roll() {
        if (numCall > 1) {
            numCall = 0;
        }
        numCall++;
        return 6 - numCall;
    }


}
