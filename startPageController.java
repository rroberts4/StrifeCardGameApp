import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class startPageController implements Initializable {

    public void start(ActionEvent event) throws IOException {

        try{Thread.sleep(1500);}
        catch(Exception e){}
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CharacterSelectView.fxml"));
        Parent game = FXMLLoader.load(getClass().getResource("CharacterSelectView.fxml"));
        Scene charScene = new Scene(game);


        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(charScene);
        window.show();
    }
    public void exit(ActionEvent event){
        System.exit(0);
    }


        @Override
        public void initialize (URL location, ResourceBundle resources){
        }

    }
