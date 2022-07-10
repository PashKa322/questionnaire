// Класс, описывающий структура вопроса
public class Question {
    // Текст вопроса
    private String questionText;

    // Массив ответов на вопрос
    private Answer[] answers;

    //Конструктор клсса
    Question(String questionText) {
        this.questionText = questionText;
        answers = new Answer[0];
    }

    // Метод добавления нового ответа
    public void addAnswers(String textAnswer, boolean isCorrect) {
        Answer answer = new Answer(textAnswer, isCorrect);

        Answer[] newAnswers = new Answer[answers.length + 1];
        if (answers.length > 0) {
            for (int i = 0; i < answers.length; i++) {
                newAnswers[i] = answers[i];
            }
            newAnswers[answers.length] = answer;
            answers = newAnswers;
        } else {
            answers = new Answer[1];
            answers[0] = answer;
        }
    }

    //Метод получения количества правильных ответов на вопрос
    private int getCountCorrectAnswer(){
        int result = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].getIsCorrect()) {
                result += 1;
            }
        }
        return result;
    }

    // Метод проверки ответа
    public boolean checkAnswer(String numAnswer) {
        String[] array = (numAnswer.replaceAll("\\D+", " ").trim()).split(" ");
        int[] arrAnswers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrAnswers[i] = Integer.valueOf(array[i]);
        }
        int countCorrectAnswer = getCountCorrectAnswer();

        if (arrAnswers.length != countCorrectAnswer) {
            return false;
        }

        for (int i = 0; i < arrAnswers.length; i++) {
            if (!answers[arrAnswers[i] - 1].getIsCorrect()) {
                return false;
            }
        }
        return true;
    }

    // Метод превращения объекта в строку
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(questionText);
        stringBuilder.append("\n");
        for (int i = 0; i < answers.length; i++) {
            stringBuilder.append("    ").append(i + 1).append(") ");
            stringBuilder.append(answers[i]);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
