package ru.otus.hws.hw03;

class Questions {
    String question;
    String[] answersArray = new String[0];
    int rightAnswer;

    public Questions() {

    }

    public Questions(String question, String[] answersArray, int rightAnswer) {
        this.question = question;
        this.answersArray = answersArray;
        this.rightAnswer = rightAnswer;


    }

    public void printQuestion(){
        System.out.println("Внимание, вопрос: \n" + question);
    }
}
