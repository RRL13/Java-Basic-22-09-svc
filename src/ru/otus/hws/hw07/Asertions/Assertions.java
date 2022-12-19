package ru.otus.hws.hw07.Asertions;

import ru.otus.hws.hw07.game.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Assertions {


    public static void assertInRange(int expected, int lowLevel, int hiLevel) {
        if (expected > hiLevel) {
            throw new AssertionError(String.format("Expected %d > %d", expected, hiLevel));
        }
        if (expected < lowLevel) {
            throw new AssertionError(String.format("Expected %d < %d", expected, lowLevel));
        }
    }

    public static void assertLastAndActual(ArrayList actual, int numRolls) {

        Collections.sort(actual);
        if (actual.get(0) == actual.get(actual.size()-1)) {
            throw new AssertionError(String.format("Expected 1st = %d %d = %d", actual.size(), actual.get(0), actual.get(actual.size()-1)));
        }

    }

    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %d = %d", expected, actual));
        }
    }


    public static void assertEquals(long expected, long actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %d = %d", expected, actual));
        }
    }

    public static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
        }
    }

    public static void assertNotEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" != \"%s\"", expected, actual));
        }
    }
    public static void assertNotNull(String actual) {
        if (actual == null) {
            throw new AssertionError("Given code does not throw any exception");
        }
    }
    public static void assertEquals(Class<? extends Throwable> expected, Class<? extends Throwable> actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
        }
    }

    public static void assertThrows(Class<? extends Throwable> expected, Runnable code) {
        Throwable actual = null;
        try {
            code.run();
        } catch (Throwable e) {
            actual = e;
        }
        if (actual == null) {
            throw new AssertionError("Given code does not throw any exception");
        }

        if (!actual.getClass().equals(expected)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected.getSimpleName(), actual.getClass().getSimpleName()));
        }
    }

}
