package ru.otus.hws.hw03;

public class HomeWorkOop {
    public static void main(String[] args) {

        int numRightAnswers = 0;
        int numWrongAnswers = 0;

        Question[] questions = createQuestionsArray(4);

        questions[0].setQuestion ("Не лает, не кусает, а в дом не пускает");
        questions[0].addAnswerVar("конь");
        questions[0].addAnswerVar("дверь");
        questions[0].addAnswerVar("замок");
        questions[0].addAnswerVar("велосипед");

        String[] answers1 = {"8", "4", "10", "6"};
        questions[1] = new Question("2 + 2 * 2 = ", answers1, 4);

        questions[2].setQuestion("Два брюшка, четыре ушка");
        String[] answers2 = {"свинья", "толстяк на коне", "подушка", "ножницы"};
        questions[2].setAnswersArray(answers2);
        questions[2].setRightAnswer(3);

        questions[3].setQuestion("Ёжики дома сидели, песню дружно они запели. Первый ёжик: \" Фыр-фыр-фыр \". Второй ёжик: \"Хыр-Хыр-Хыр\". Третий ёжик \"Цир-цир-цир\". Как запел четвёртый ёжик?");
        String[] answers3 = {"Арр - арр - арр", "Урр - урр - урр", "Ирр - ирр - ирр", "Чирр - Чирр - Чирр"};
        questions[3].setAnswersArray(answers3);
        questions[3].setRightAnswer(4);

        for (Question question : questions) {
            question.printQuestion();
            question.printAnswersVars();
            if (question.isUserRightOrNot()) {
                numRightAnswers++;
            }
        }
        numWrongAnswers = questions.length - numRightAnswers;
        System.out.println("Ваши результаты:");
        System.out.println("правильных ответов - " + numRightAnswers);
        System.out.println("неправильных ответов - " + numWrongAnswers);
    }

    private static Question[] createQuestionsArray(int numQuestions){
        Question[] questions = new Question[numQuestions];
        for (int i = 0; i < numQuestions; i++){
            questions[i] = new Question();
        }
        return questions;
    }
}
