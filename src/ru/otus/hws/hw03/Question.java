package ru.otus.hws.hw03;

import java.util.Scanner;

class Question {
    private String question;
    private String[] answersArray = new String [0];
    private int rightAnswer = 0;

    public Question() {
    }

    public Question(String question) {
        this(question, 0, new String[0]);
    }

    public Question(String question, int rightAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
    }

    public Question(String question, int rightAnswer, String... answersArray) {
        this.question = question;
        this.answersArray = answersArray;
        this.rightAnswer = rightAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswersArray(String... newAnswersArray ){
        this.answersArray = newAnswersArray;
    }

    public String[] getAnswersArray() {
        return answersArray;
    }

    public int numAnswers(){
        return this.answersArray.length;
    }

    public void setRightAnswer(int rightAnswer){
        this.rightAnswer = rightAnswer;
    }

    public int getRightAnswer(){
        return rightAnswer;
    }

    public void addAnswerVar(String newAnswerVar) {
        this.answersArray = addElementInStringArray(answersArray, newAnswerVar);
    }

    public void printQuestion() {
        System.out.println("Внимание, вопрос: \n" + question);
    }

    public void printAnswersVars() {
        int i = 1;
        for (String answer : answersArray) {
            System.out.println(i++ + ". " + answer);
        }
    }

    public int whatUserSays(){
        return scanAnswerOk();
    }

    public boolean isUserRightOrNot(){
        return scanAnswerOk() == this.rightAnswer;
    }
    private int scanAnswerOk() {
        Scanner scanAnswer = new Scanner(System.in);
        int inputUserAnswer = 0;
        System.out.print("Введите ваш вариант ответа: ");
        if (scanAnswer.hasNextInt()) {
            inputUserAnswer = scanAnswer.nextInt();
            boolean isAnswerOk = (inputUserAnswer > 0 && inputUserAnswer <= answersArray.length);
            if (!isAnswerOk) {
                inputUserAnswer = -1;
                System.out.println("Вы не попали в диапазон ответов (от 1 до " + answersArray.length + " ). Засчитаем, как неверный ответ.");
            }

        } else {
            System.out.println("Вы ввели что-то непотребное. Засчитаем, как неверный ответ.");
        }
        return inputUserAnswer;
    }

    private static String[] addElementInStringArray(String[] inputStringArr, String newElementText){
        String[] returnStringArr = new String[(inputStringArr.length+1)];
        System.arraycopy(inputStringArr, 0, returnStringArr, 0, inputStringArr.length);
        returnStringArr[returnStringArr.length-1] = newElementText;
        return returnStringArr;
    }
}
