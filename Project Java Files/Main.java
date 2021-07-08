import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


public class Main  extends Application {
    private static Scene scene1;
    private static Stage stage;

    public static void main(String[] args)
    {
        String cardSound = "C:\\Users\\gunot\\Music\\card.mp3";
        Media media = new Media(new File(cardSound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

     launch(args);


    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("CharacterSelectView.fxml"));
        Scene scene = new Scene(root);
        scene1 = scene;
        root =FXMLLoader.load(getClass().getResource("StartPageView.fxml"));
        scene = new Scene(root);
        primaryStage.setTitle("STRIFE");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static Scene getScene(){
        return scene1;
    }
    public static Stage getStage(){
        return stage;
    }
}
