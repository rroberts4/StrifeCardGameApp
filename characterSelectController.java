import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class characterSelectController implements Initializable {
    private static Scene scene1;
    private static Stage stage;
    public static String playerSelection;
    public static String computerSelection;
    @FXML private ImageView black, red, blue, green;
    @FXML private Label selectLabel, redLabel, blueLabel, blackLabel, greenLabel;
    @FXML private Button startButton;
    private Image blackSelected = new Image("./Images/Black_Leader2.jpg");
    private Image greenSelected = new Image("./Images/Green_Leader2.jpg");
    private Image redSelected = new Image("./Images/Boss_Leader2.jpg");
    private Image blueSelected = new Image("./Images/Blue_Leader2.jpg");
    int selectionNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectLabel.setText("(Select Your Character)");
        startButton.setDisable(true);


    }

    @FXML private void redSelection(MouseEvent event) {
        if(selectionNumber>1){ return; }
        if((selectionNumber % 2) == 0){
            playerSelection = "red";
            red.setDisable(true);
            red.setImage(redSelected);
            redLabel.setText("Player");


        }
        if((selectionNumber % 2) == 1){
            computerSelection = "red";
            selectLabel.setText("(Press Start)");
            red.setDisable(true);
            red.setImage(redSelected);
            redLabel.setText("Opponent");
            startButton.setDisable(false);
        }
        selectionNumber++;
    }
    @FXML private void blueSelection(MouseEvent event) {
        if(selectionNumber>1){ return; }
        if((selectionNumber % 2) == 0){
            playerSelection = "blue";
            selectLabel.setText("(Select Your Opponent)");
            blue.setDisable(true);
            blue.setImage(blueSelected);
            blueLabel.setText("Player");
        }
        if((selectionNumber % 2) == 1){
            computerSelection = "blue";
            selectLabel.setText("(Press Start)");
            blue.setDisable(true);
            blue.setImage(blueSelected);
            blueLabel.setText("Opponent");
            startButton.setDisable(false);
        }
        selectionNumber++;
    }
    @FXML private void greenSelection(MouseEvent event) {
        if(selectionNumber>1){ return; }
        if((selectionNumber % 2) == 0){
            playerSelection = "green";
            green.setDisable(true);
            green.setImage(greenSelected);
            greenLabel.setText("Player");
            selectLabel.setText(" -> (Select Your Opponent)");
        }
        if((selectionNumber % 2) == 1){
            computerSelection = "green";
            green.setDisable(true);
            green.setImage(greenSelected);
            greenLabel.setText("Opponent ");
            selectLabel.setText("-> (Press Start)");
            startButton.setDisable(false);
        }
        selectionNumber++;
    }
    @FXML private void blackSelection(MouseEvent event) {
        if(selectionNumber>1){ return; }
        if((selectionNumber % 2) == 0){
            playerSelection = "black";
            black.setDisable(true);

            black.setImage(blackSelected);
            blackLabel.setText("Player");
            selectLabel.setText("(Select Your Opponent)");
        }
        if((selectionNumber % 2) == 1){
            computerSelection = "black";
            black.setDisable(true);
            black.setImage(blackSelected);
            blackLabel.setText("Opponent");
            selectLabel.setText("(Press Start)");
            startButton.setDisable(false);
        }
        selectionNumber++;
    }
    public static Stage getStage(){
        return stage;
    }
    public static Scene getScene(){
        return scene1;
    }
    public void startGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GwentView.fxml"));
        Parent strife = loader.load();
        Scene game = new Scene(strife);
      //  gameController controller = loader.getController();

        //controller.assignDeck(playerSelection, computerSelection);





        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene1 = game;
        stage =window;
        window.setScene(game);
        window.show();
    }

}
