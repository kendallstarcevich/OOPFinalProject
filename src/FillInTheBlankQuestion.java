/**
 * A Fill in the Blank question implementation, extending the ShortAnswerQuestion class.
 * 
 * For Final "Online Quiz App" Project
 * 
 * Chat-GPT helped me with JavaDoc comments, I recorded this in the AI reflection on Blackboard.
 * 
 * @author Kendall Starcevich
 */
public class FillInTheBlankQuestion extends ShortAnswerQuestion {

    private String part1;
    private String part2;

    /**
     * Constructs a FillInTheBlankQuestion with the specified parts and correct answer.
     *
     * @param part1, The first part of the question.
     * @param part2, The second part of the question.
     * @param correctAnswer, The correct answer to the question.
     */
    public FillInTheBlankQuestion(String part1, String part2, String correctAnswer) {
        super(part1 + " _______ " + part2, correctAnswer);
        this.part1 = part1;
        this.part2 = part2;
    }

    /**
     * Retrieves the complete text of the Fill in the Blank question.
     *
     * @return The complete text of the Fill in the Blank question.
     */
    @Override
    public String getQuestion() {
        return part1 + " _______ " + part2;
    }

    /**
     * Retrieves the first part of the Fill in the Blank question.
     *
     * @return The first part of the Fill in the Blank question.
     */
    public String getPart1() {
        return part1;
    }

    /**
     * Retrieves the second part of the Fill in the Blank question.
     *
     * @return The second part of the Fill in the Blank question.
     */
    public String getPart2() {
        return part2;
    }
}
