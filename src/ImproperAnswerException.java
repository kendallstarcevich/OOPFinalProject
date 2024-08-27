/**
 * Custom exception class for handling improper answers in quiz questions.
 * Extends RuntimeException.
 * 
 * For Final "Online Quiz App" Project
 * 
 * Chat-GPT helped me with JavaDoc comments, I recorded this in the AI reflection on Blackboard.
 * 
 * @author Kendall Starcevich
 */
public class ImproperAnswerException extends RuntimeException {

    /**
     * Constructs an ImproperAnswerException with a default error message.
     * The error message indicates that the answer is not valid, and the user
     * must select an answer from the options provided.
     */
    public ImproperAnswerException() {
        super("This answer is not valid, you must select an answer from the options provided.");
    }
}
