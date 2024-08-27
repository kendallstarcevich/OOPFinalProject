import java.util.List;
import java.util.Collections;

/**
 * This class represents a short answer question.
 * It implements the Question interface and overrides its methods.
 * 
 * For Final "Online Quiz App" Project
 * 
 * Chat-GPT helped me with JavaDoc comments, I recorded this in the AI reflection on Blackboard.
 * 
 * @author Kendall Starcevich
 */
public class ShortAnswerQuestion implements Question {

    protected String question;
    protected String correctAnswer;

    /**
     * Constructor for the ShortAnswerQuestion class.
     *
     * @param question The question text.
     * @param correctAnswer The correct answer to the question.
     */
    public ShortAnswerQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Returns the question text.
     *
     * @return The question text.
     */
    @Override
    public String getQuestion() {
        return question;
    }

    /**
     * Checks if the provided response is correct.
     *
     * @param response The user's response.
     * @return True if the response is correct, false otherwise.
     */
    @Override
    public boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(correctAnswer);
    }

    /**
     * Returns the index of the correct answer.
     * Since this is a short answer question and there are no choices, it always returns -1.
     *
     * @return -1 as there are no choices in a short answer question.
     */
    @Override
    public int getCorrectAnswerIndex() {
        return -1;
    }

    /**
     * Returns the choices for the question.
     * Since this is a short answer question, there are no choices, so it returns an empty list.
     *
     * I found that Collections can return an empty list from the website:
     * https://www.geeksforgeeks.org/java-collections-emptylist-method-with-examples/
     * 
     * @return An empty list as there are no choices in a short answer question.
     */
    @Override
    public List<String> getChoices() {
        return Collections.emptyList();
    }

    /**
     * Displays the correct answer.
     *
     * @return A string that displays the correct answer.
     */
    @Override
    public String displayCorrectAnswer() {
        return String.format("Incorrect. The correct answer is: "+correctAnswer);
    }

    /**
     * Returns a string representation of the question.
     *
     * @return The question text.
     */
    @Override
    public String toString() {
        return question;
    }
}