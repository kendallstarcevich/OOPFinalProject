import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class for the Online Quiz App. Responsible for creating the GUI and
 * starting the quiz.
 *
 * Currently, I have one question created of each type to show the capabilites of the app
 * in my "Debugging Quiz"
 * 
 * Chat-GPT helped me with JavaDoc comments, I recorded this in the AI reflection on Blackboard.
 * 
 * For Final "Online Quiz App" Project
 *
 * @author Kendall Starcevich
 */
public class Main extends Application {

    private Label quizLabel;
    private Quiz quiz;
    private static TextArea outputTextArea; // this, and other implentations of 
    // outputTextArea was found from Chat-GPT, as documented in my Quiz.java file and the learning
    //reflection.

    /**
     * The main entry point for the application.
     *
     * @param primaryStage The primary stage for the application.
     */
    @Override
    public void start(Stage primaryStage) {
        // Sample questions
        List<Question> debuggingQuestions = new ArrayList<>();
        debuggingQuestions.add(new MultipleChoiceQuestion("Which programming language is this code written in?",
                List.of("Java", "Python", "C++", "JavaScript"), 1));
        debuggingQuestions.add(new TrueFalseQuestion("The sky is blue.", true));
        debuggingQuestions.add(new ShortAnswerQuestion("What is the capital of Iowa?", "Des Moines"));
        debuggingQuestions.add(new FillInTheBlankQuestion("The NFL QB","won the 2023 SuperBowl.","Patrick Mahomes"));

        quiz = new Quiz(debuggingQuestions, "Debugging Quiz");

        quizLabel = new Label("Welcome to the Online Quiz App!");
        quizLabel.setFont(new Font(20));

        Label instructionsLabel = new Label("Enter the number of the answer. Type the answer if no options given.");

        Button startButton = new Button("Start Quiz");
        startButton.setOnAction(new StartButtonClickHandler());

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(new ExitButtonClickHandler());

        outputTextArea = new TextArea(); 

        VBox vbox = new VBox(10, quizLabel, instructionsLabel, startButton, exitButton, outputTextArea);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));

        Scene quizScene = new Scene(vbox, 400, 300);

        primaryStage.setTitle("Online Quiz App");
        primaryStage.setScene(quizScene);
        primaryStage.show();
    }

    /**
     * Retrieves user input using a dialog prompt.
     *
     * @param prompt The prompt message displayed to the user.
     * @return The user's input as a String.
     */
    public static String getUserInput(String prompt) {
        TextInputDialog answer = new TextInputDialog();
        answer.setHeaderText(null);
        answer.setContentText(prompt);
        return answer.showAndWait().orElse(""); //was not working with just return answer, GitHub Copilot suggested this.
    }

    /**
     * Updates the outputTextArea in the GUI with the provided message.
     *
     * @param message The message to be displayed in the outputTextArea.
     */
    public static void updateOutput(String message) {
        outputTextArea.appendText(message + "\n");
    }

    /**
     * The main method to launch the application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Event handler for the Start Quiz button click.
     */
    class StartButtonClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Start the quiz when the button is clicked
            quiz.takeQuiz();
        }
    }

    /**
     * Event handler for the Exit button click. 
     */
    class ExitButtonClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Close the application
            System.exit(0); //I found this from the stackoverflow post:
            //https://stackoverflow.com/questions/8632705/how-to-close-a-gui-when-i-push-a-jbutton

        }
    }
}