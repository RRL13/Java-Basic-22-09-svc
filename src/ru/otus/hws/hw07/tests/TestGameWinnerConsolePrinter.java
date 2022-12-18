package ru.otus.hws.hw07.tests;

import ru.otus.hws.hw07.HomeWork;
import ru.otus.hws.hw07.game.GameWinnerConsolePrinter;
import ru.otus.hws.hw07.game.GameWinnerPrinter;
import ru.otus.hws.hw07.game.Player;

public class TestGameWinnerConsolePrinter implements GameWinnerPrinter {
    private String testWinnerFromPrinter = null;
    @Override
    public void printWinner(Player winner) {

        testWinnerFromPrinter = winner.getName();

    }

    public String getTestWinnerName(){
        return this.testWinnerFromPrinter;
    }
}
