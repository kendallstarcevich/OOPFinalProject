/**
 * An interface representing a generic quiz question.
 * 
 * For Final "Online Quiz App" Project
 * 
 * Chat-GPT helped me with JavaDoc comments, I recorded this in the AI reflection on Blackboard.
 * 
 * @author Kendall Starcevich
 */
import java.util.List;

interface Question {

    /**
     * Retrieves the text of the question.
     *
     * @return The text of the question.
     */
    String getQuestion();

    /**
     * Checks if the provided response is the correct answer to the question.
     *
     * @param response The user's response to the question.
     * @return True if the response is correct, otherwise false.
     */
    boolean checkAnswer(String response);

    /**
     * Retrieves the index of the correct answer in the list of choices.
     *
     * @return The index of the correct answer.
     */
    int getCorrectAnswerIndex();

    /**
     * Retrieves the list of choices for the question.
     *
     * @return The list of choices for the question.
     */
    List<String> getChoices();

    /**
     * Provides a string representation of the correct answer.
     *
     * @return A message indicating the correct answer.
     */
    String displayCorrectAnswer();

    /**
     * Provides a string representation of the question.
     *
     * @return The text of the question.
     */
    String toString();
}
