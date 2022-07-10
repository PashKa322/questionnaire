//Класс, описывающий структура ответа
public class Answer {
    // Текст вопроса
    private String answerText;

    //Флаг правильности ответа
    private boolean isCorrect;

    // Конструктор класса
    Answer(String answerText, boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    // Метод получения поля isCorrect
    public boolean getIsCorrect(){
        return this.isCorrect;
    }

    // Метод превращения объекта в строку
    @Override
    public String toString() {
        return answerText;
    }
}
