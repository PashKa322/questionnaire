import java.util.ArrayList;

public class Question {
    private String questionText;
    private Answer[] answers;

    Question(String questionText) {
        this.questionText = questionText;
        answers = new Answer[0];
    }

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

    private int getCountCorrectAnswer(){
        int result = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].getIsCorrect()) {
                result += 1;
            }
        }
        return result;
    }

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
