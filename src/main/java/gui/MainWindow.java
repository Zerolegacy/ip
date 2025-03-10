package gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import dynamis.Dynamis;
import dynamis.Ui;
/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Dynamis dynamis;
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    @FXML
    public void initialize() {
        Ui ui = new Ui();
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getDynamisDialog(ui.printWelcomeMessage(), dukeImage)
        );
    }

    /** Injects the Dynamis instance */
    public void setDynamis(Dynamis d) {
        dynamis = d;
        dialogContainer.getChildren().addAll(
                DialogBox.getDynamisDialog(dynamis.getResponse("list"), dukeImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Dynamis's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = dynamis.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDynamisDialog(response, dukeImage)
        );
        if (response.startsWith("Bye")) {
            Platform.exit();
        }
        userInput.clear();
    }
}
