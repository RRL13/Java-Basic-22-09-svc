package ru.otus.hws.hw07;


import ru.otus.hws.hw07.tests.Hw07GameTest01;
import ru.otus.hws.hw07.tests.Hw07GameTest02;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {
        System.out.println("\n\n----------------------\n\n");
        new Hw07GameTest01().testDiceRandom();
        new Hw07GameTest01().testDiceFrom1To6();
        System.out.println("\n\n---------------------\n\n");
        new Hw07GameTest02().testRight1stWinner();
        new Hw07GameTest02().testRight2ndWinner();
        new Hw07GameTest02().testRightDraw();


    }
    
}