import java.util.Arrays;
import java.util.List;

/**
 * A True/False question implementation of the Question interface.
 * 
 * For Final "Online Quiz App" Project
 * 
 * Chat-GPT helped me with JavaDoc comments, I recorded this in the AI reflection on Blackboard.
 * 
 * @author Kendall Starcevich
 */
public class TrueFalseQuestion implements Question {
    private String question;
    private int correctAnswerIndex;

    /**
     * Constructs a TrueFalseQuestion with the given question and correct answer.
     *
     * @param question, The text of the True/False question.
     * @param correctAnswer, The correct answer to the question (True or False).
     */
    public TrueFalseQuestion(String question, boolean correctAnswer) {
        this.question = question;
        // Assign correctAnswerIndex based on the boolean value
        if (correctAnswer) {
            this.correctAnswerIndex = 0;
        } else {
            this.correctAnswerIndex = 1;
        }
    }

    /**
     * Retrieves the text of the True/False question.
     *
     * @return The text of the True/False question.
     */
    @Override
    public String getQuestion() {
        return question;
    }

    /**
     * Checks if the provided response is the correct answer to the question.
     *
     * @param response The user's response to the question.
     * @return True if the response is correct, otherwise false.
     */
    @Override
    public boolean checkAnswer(String response) {
        int userAnswerIndex;
        try {
            userAnswerIndex = Integer.parseInt(response) - 1;
        } catch (NumberFormatException e) {
            return false; // Handle the case where response is not a valid integer
        }
        return userAnswerIndex == correctAnswerIndex;
    }

    /**
     * Retrieves the list of choices for the True/False question (True, False).
     *
     * @return The list of choices for the True/False question.
     */
    @Override
    public List<String> getChoices() {
        return Arrays.asList("True", "False");
    }

    /**
     * Retrieves the index of the correct answer in the list of choices.
     *
     * @return The index of the correct answer.
     */
    @Override
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    /**
     * Provides a string representation of the correct answer.
     *
     * @return A message indicating the correct answer.
     */
    @Override
    public String displayCorrectAnswer() {
        return "Incorrect. The correct answer is: " + (getCorrectAnswerIndex() + 1) + "\n";
    }

    /**
     * Provides a string representation of the True/False question.
     *
     * @return The text of the True/False question.
     */
    @Override
    public String toString() {
        return question;
    }
}

