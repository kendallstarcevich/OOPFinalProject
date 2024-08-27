import java.util.List;

/**
 * A Multiple Choice question implementation of the Question interface.
 * 
 * For Final "Online Quiz App" Project
 * 
 * Chat-GPT helped me with JavaDoc comments, I recorded this in the AI reflection on Blackboard.
 * 
 * @author Kendall Starcevich
 */
class MultipleChoiceQuestion implements Question {
    protected String question;
    protected List<String> choices;
    protected int correctAnswerIndex;

    /**
     * Constructs a MultipleChoiceQuestion with the given question, choices, and correct answer index.
     *
     * @param question, The text of the multiple-choice question.
     * @param choices, The list of choices for the question.
     * @param correctAnswerIndex, The index of the correct answer in the choices list.
     */
    public MultipleChoiceQuestion(String question, List<String> choices, int correctAnswerIndex) {
        this.question = question;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    /**
     * Retrieves the text of the multiple-choice question.
     *
     * @return The text of the multiple-choice question.
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
            userAnswerIndex = Integer.parseInt(response);
        } catch (NumberFormatException e) {
            return false; // Handle the case where response is not a valid integer
        }
        return userAnswerIndex == correctAnswerIndex;
    }

    /**
     * Retrieves the list of choices for the multiple-choice question.
     *
     * @return The list of choices for the multiple-choice question.
     */
    @Override
    public List<String> getChoices() {
        return choices;
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
        return "Incorrect. The correct answer is: " + getCorrectAnswerIndex() + "\n";
    }

    /**
     * Provides a string representation of the multiple-choice question.
     *
     * @return The text of the multiple-choice question.
     */
    @Override
    public String toString() {
        return question;
    }
}
