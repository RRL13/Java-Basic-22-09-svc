package ru.otus.hws.hw02;

import java.util.Scanner;

public class HomeWorkIfElse {

    public static void main(String[] args) {
        int numCorrectAnswers = 0;
        int numWrongAnswers = 0;
        String[] questions = new String[]{
                "Не лает, не кусает, а в дом не пускает",
                "2 + 2 * 2 = ",
                "Два брюшка, четыре ушка",
                "Ёжики дома сидели, песню дружно они запели. Первый ёжик: \" Фыр-фыр-фыр \". Второй ёжик: \"Хыр-Хыр-Хыр\". Третий ёжик \"Цир-цир-цир\". Как запел четвёртый ёжик?"
        };
        String[][] answers = new String[][]{
                {"Кошка", "Замок", "Дверь", "Собака"},
                {"8", "4", "10", "6"},
                {"свинья", "толстяк на коне", "подушка", "ножницы"},
                {"Арр - арр - арр", "Урр - урр - урр", "Ирр - ирр - ирр", "Чирр - Чирр - Чирр"}
        };
        int[] correctAnswers = new int[]{2, 4, 3, 4};

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            int numberAnswer = 0;
            for (String answerPrint : answers[i]) {
                System.out.println(++numberAnswer + ": " + answerPrint+ ";");
            }

            if (scanAnswerOk() == correctAnswers[i]) {
                numCorrectAnswers++;
            } else {
                numWrongAnswers++;
            }
        }

        System.out.println("Правильных ответов: " + numCorrectAnswers);
        System.out.println("Ошибок:" + numWrongAnswers);


    }

    private static int scanAnswerOk() {
        Scanner scanAnswer = new Scanner(System.in);
        boolean isAnswerOk = false;
        int answer = 0;
        System.out.println("Ваш вариант ответа");
        while (!isAnswerOk) {
            System.out.print("(введите цифру от 1 до 4): ");
            answer = scanAnswer.nextInt();
            isAnswerOk = (answer == 1 || answer == 2 || answer == 3 || answer == 4);
        }

        return answer;
    }
}
