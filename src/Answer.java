public class Answer {
    private String answerText;
    private boolean isCorrect;

    Answer(String answerText, boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public boolean getIsCorrect(){
        return this.isCorrect;
    }

    @Override
    public String toString() {
        return answerText;
    }
}
