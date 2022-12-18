package ru.otus.hws.hw07.tests;


import ru.otus.hws.hw07.Asertions.Assertions;
import ru.otus.hws.hw07.game.*;

public class Hw07GameTest02  {
    private final Dice testDice1stWin = new TestDice1stWin();
    private final Dice testDice2ndWin = new TestDice2ndWin();
    private TestGameWinnerConsolePrinter testGameWinnerPrinter = new TestGameWinnerConsolePrinter();

    String player1stName = "1st";
    String player2ndName = "2nd";
    String winnerName = null;

    public void testRight1stWinner() {
        String scenario = "V02.1 тест возможностей победы где выиграл 1й участник";
        //GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        try {
            Game testGame = new Game(testDice1stWin, testGameWinnerPrinter);
            String realWinner = player1stName;
            testGame.playGame(new Player(player1stName), new Player(player2ndName));

            String winnerFromGame = testGameWinnerPrinter.getTestWinnerName();

            Assertions.assertEquals(realWinner, winnerFromGame);

            System.out.println("Тест " + scenario + " пройден успешно");


        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

    }

    public void testRight2ndWinner() {
        String scenario = "V02.2 тест возможностей победы где выиграл 2й участник";
        //GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        try {
            Game testGame = new Game(testDice2ndWin, testGameWinnerPrinter);
            String realWinner = player2ndName;
            testGame.playGame(new Player(player1stName), new Player(player2ndName));

            String winnerFromGame = testGameWinnerPrinter.getTestWinnerName();

            Assertions.assertEquals(realWinner, winnerFromGame);

            System.out.println("Тест " + scenario + " пройден успешно");


        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }



    }

    public void testRightDraw() {
        String scenario = "V02.3 тест на ничью";
        //GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        try {
            Game testGame = new Game(testDice2ndWin, testGameWinnerPrinter);

            testGame.playGame(new Player(player1stName), new Player(player2ndName));

            String winnerFromGame = testGameWinnerPrinter.getTestWinnerName();

            Assertions.assertNotNull(winnerFromGame);
            Assertions.assertNotEquals(winnerFromGame, player1stName);
            Assertions.assertNotEquals(winnerFromGame, player2ndName);

            System.out.println("Тест " + scenario + " пройден успешно");


        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }



    }
}
