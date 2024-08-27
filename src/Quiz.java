import java.util.List;

/**
 * Represents a quiz that consists of a list of questions.
 *
 *  For Final "Online Quiz App" Project
 * 
 * I found the Main.updateOutput() method from Chat-GPT, I recorded this in the AI reflection on Blackboard.
 * Chat-GPT helped me with JavaDoc comments, I recorded this in the AI reflection on Blackboard.
 * 
 * @author Kendall Starcevich
 */
public class Quiz {
    private List<Question> questions;
    private int score;
    private String name;

    /**
     * Constructs a Quiz with the specified list of questions and a name.
     *
     * @param questions, The list of questions in the quiz.
     * @param name, The name or title of the quiz.
     */
    public Quiz(List<Question> questions, String name) {
        this.questions = questions;
        this.score = 0;
        this.name = name;
    }

    /**
     * Retrieves the name or title of the quiz.
     *
     * @return The name or title of the quiz.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name or title of the quiz.
     *
     * @param name The name or title of the quiz.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the list of questions in the quiz.
     *
     * @return The list of questions in the quiz.
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Sets the list of questions in the quiz.
     *
     * @param questions The list of questions in the quiz.
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Retrieves the current score of the quiz.
     *
     * @return The current score of the quiz.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the quiz.
     *
     * @param score The score of the quiz.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Takes the quiz, displaying questions and collecting user responses.
     */
    public void takeQuiz() {
        Main.updateOutput(name);
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            Main.updateOutput("Question " + (i + 1) + ": " + currentQuestion.getQuestion());

            List<String> choices = currentQuestion.getChoices();
            for (int j = 0; j < choices.size(); j++) {
                Main.updateOutput((j + 1) + ". " + choices.get(j));
            }

            String response = Main.getUserInput("Your answer:");

            if (currentQuestion.checkAnswer(response)) {
                Main.updateOutput("Correct!\n");
                score++;
            } else {
                Main.updateOutput(currentQuestion.displayCorrectAnswer());
            }
        }
        Main.updateOutput("Quiz complete. Your score: " + score + "/" + questions.size());
        double percentage = (score * 100 / questions.size());
        Main.updateOutput("That is a " + percentage + "%");
        if (percentage >= 90) {
            Main.updateOutput("Great job!");
        } else if (percentage >= 80) {
            Main.updateOutput("Good job!");
        } else if (percentage >= 70) {
            Main.updateOutput("Almost there!");
        } else if (percentage >= 60) {
            Main.updateOutput("I know you can do better!");
        } else {
            Main.updateOutput("You might need to study more!");
        }
    }
}
