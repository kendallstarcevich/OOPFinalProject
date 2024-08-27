import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

/**
 * JUnit tests for the Quiz application.
 * 
 * For Final "Online Quiz App" Project
 * 
 * Chat-GPT helped me with JavaDoc comments, I recorded this in the AI reflection on Blackboard.
 * 
 * @author Kendall Starcevich
 */
public class QuizTester {

    /**
     * Tests the getQuestion method of the MultipleChoiceQuestion class.
     */
    @Test
    public void getQuestionTest() {
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(
                "What is the capital of France?",
                List.of("Berlin", "Madrid", "Paris", "Rome"),
                3);
        assertEquals(question1.getQuestion(), "What is the capital of France?");
    }

    /**
     * Tests the checkAnswer method of the MultipleChoiceQuestion class.
     */
    @Test
    public void checkAnswerTest() {
        MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(
                "What is the capital of France?",
                List.of("Berlin", "Madrid", "Paris", "Rome"),
                3);
        assertTrue(question1.checkAnswer("3"));
    }

    /**
     * Tests the checkAnswer method of the ShortAnswerQuestion class, specifically makes sure that it is not case sensitive.
     */
    @Test
    public void checkWrittenAnswerTest() {
        ShortAnswerQuestion question1 = new ShortAnswerQuestion("What is the capital of France?", "Paris");
        assertTrue(question1.checkAnswer("PAriS"));
    }


    /**
     * Tests the getQuestion() method of the FillInTheBlankQuestion class. Makes sure that it prints correctly with the blank.
     */
    @Test
    public void checkFillInTheBlankQuestion(){
        FillInTheBlankQuestion question1 = new FillInTheBlankQuestion("The city","is the capital of Iowa.","Des Moines");
        assertEquals("The city _______ is the capital of Iowa.", question1.getQuestion());
    }

    /**
     * Tests the displayCorrectAnswer() function of the ShortAnswerQuestion class. I wanted to make sure 
     * that this method was inherited even though I did not specifically write it in, I just extended the class.
     */
    @Test
    public void checkgetFillInTheBlankAnswer(){
        FillInTheBlankQuestion question1 = new FillInTheBlankQuestion("The city","is the capital of Iowa.","Des Moines");
        assertEquals("Incorrect. The correct answer is: "+"Des Moines", question1.displayCorrectAnswer());
    }
}
