import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ResultsController implements Initializable {

    @FXML private Label messageResult, scoreResult;
    @Override
    public void initialize(URL location, ResourceBundle resources) {



        }
    public void showResults(int plyrScore, int oppScore){
        if(plyrScore == oppScore) {
            messageResult.setText("Round Ended In A Draw");

            scoreResult.setText(String.format("You: %d - Computer: %d ",plyrScore,oppScore));
        }
        if(plyrScore > oppScore) {
            messageResult.setText("You Won The Round");

            scoreResult.setText(String.format("You: %d - Computer: %d ",plyrScore,oppScore));
        }
        if(plyrScore < oppScore) {
            messageResult.setText("You Lost The Round");

            scoreResult.setText(String.format("You: %d - Computer: %d ",plyrScore,oppScore));
        }

    }
    public void changeScreen(ActionEvent event) throws IOException {



        Stage window =characterSelectController.getStage();
        window.setScene(characterSelectController.getScene());
        window.show();
    }


    }

