import java.util.Scanner;

// Класс описывающий Анкету
public class Start {
    // Вопросы класса
    private Question[] questions = new Question[0];

    // Метод получения всех вопросов
    private Question[] getQuestions(){
        return questions;
    }

    // Метод добавления нового вопроса
    private void addQuestion(String textQuestion) {
        Question question = new Question(textQuestion);

        Question[] newQuestions = new Question[questions.length + 1];
        if (questions.length > 0) {
            for (int i = 0; i < questions.length; i++) {
                newQuestions[i] = questions[i];
            }
            newQuestions[questions.length] = question;
            questions = newQuestions;
        } else {
            questions = new Question[1];
            questions[0] = question;
        }
    }

    // Метод создания новой анкеты
    private static void createForm(Start start) {
        System.out.println("Для прохождения теста создайте анкету");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество вопросов: ");
        int countQuestion = scanner.nextInt();

        for (int i = 0; i < countQuestion; i++) {
            System.out.println("Введите текст вопроса: ");
            scanner = new Scanner(System.in);
            start.addQuestion(scanner.nextLine());

            System.out.println("Введите количество ответов: ");
            scanner = new Scanner(System.in);
            int countAnswer = scanner.nextInt();

            for (int j = 0; j < countAnswer ; j++) {
                System.out.println("Введите текст ответа: ");
                scanner = new Scanner(System.in);
                String textAnswer = scanner.nextLine();

                System.out.println("Введите 1, если это ответ на вопрос, иначе 0: ");
                scanner = new Scanner(System.in);
                String isCorrectStr = scanner.next();
                boolean isCorrect;
                if (isCorrectStr.equals("1")) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }

                start.getQuestions()[i].addAnswers(textAnswer, isCorrect);
            }
        }
        System.out.println("Анкета готова");

        scanner = new Scanner(System.in);
        System.out.println("Если хотите посмотреть анкету напишите 1, иначе 0: ");
        if (scanner.nextInt() == 1) {
            for (int i = 0; i < start.getQuestions().length; i++) {
                System.out.format("вопрос %d) %s", i + 1, start.getQuestions()[i]);
            }
        }
    }

    // Метод начала прохождения анкеты
    private static int runForm(Start start) {
        Scanner scanner = new Scanner(System.in);
        int scores = 0;
        System.out.println("Переходим к прохождению анкеты.Представим, что анкету делали не вы");
        for (int i = 0; i < start.getQuestions().length ; i++) {
            System.out.format("вопрос %d) %s", i+1, start.getQuestions()[i]);

            System.out.println("Введите номер(а) верного ответа: ");
            scanner = new Scanner(System.in);

            if (start.getQuestions()[i].checkAnswer(scanner.nextLine())) {
                scores += 1;
            } else {
                scores -= 1;
            }

        }
        return scores;
    }



    // Метод main - запуск приложения
    public static void main(String[] args) {
        Start start = new Start();

        createForm(start);
        int scores = runForm(start);

        System.out.format("Ваш результат прохождения анкеты: %d", scores);
    }
}
