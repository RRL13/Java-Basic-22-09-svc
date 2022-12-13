package ru.otus.hws.hw06;

public class AnalogException extends RuntimeException {

    public AnalogException(String message, int lowLevel, int hiLevel, int address, int value) {
        System.out.printf("Имитация записи логфайла. Ошибка:%s. Диапазон: от %d до %d. Адрес: %d. Значение: %d%n", message, lowLevel, hiLevel, address, value);
    }
}
