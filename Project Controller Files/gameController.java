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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class gameController implements Initializable {
    @FXML private ImageView gameBoard, plyrDeckImage;
    @FXML private ImageView cardOne, cardTwo, cardThree, cardFour, cardFive, cardSix, cardSeven,cardEight;
    @FXML private ImageView oppCardOne, oppCardTwo, oppCardThree, oppCardFour, oppCardFive, oppCardSix, oppCardSeven,oppCardEight;
    @FXML private ImageView effectOne, effectTwo, effectThree, effectFour;
    @FXML private Label plyrPassLabel, oppPassLabel, roundLabel;
    boolean[] melee = new boolean[4];
    boolean[] ranged = new boolean[4];
    boolean[] oppMelee = new boolean[4];
    boolean[] oppRanged = new boolean[4];
    boolean plyrRoundPass, plyrTurnPass, mustWin;
    @FXML private Button endTurnButton,resultsButton, turnButton;
    @FXML private Label oppMeleeScore, oppRangeScore, plyrMeleeScore, plyrRangeScore, oppTotalScore, plyrTotalScore;
    @FXML private ImageView meleeOne, meleeTwo, meleeThree, meleeFour, oppMeleeOne, oppMeleeTwo, oppMeleeThree, oppMeleeFour;
    @FXML private ImageView rangedOne, rangedTwo, rangedThree,rangedFour, oppRangedOne, oppRangedTwo, oppRangedThree,oppRangedFour, oppBackDeck;
    @FXML private ImageView oppCharacter, playerCharacter;
    boolean cardOnePlayed, cardTwoPlayed, cardThreePlayed, cardFourPlayed, cardFivePlayed, cardSixPlayed, cardSevenPlayed, cardEightPlayed;
    int cardOneAttack, cardTwoAttack, cardThreeAttack,cardFourAttack,cardFiveAttack, cardSixAttack, cardSevenAttack, cardEightAttack;
    int oppCardOneAttack, oppCardTwoAttack, oppCardThreeAttack,oppCardFourAttack,oppCardFiveAttack,oppCardSixAttack,oppCardSevenAttack,oppCardEightAttack;
    int plyrMeleeNumber, plyrRangeNumber, plyrTotalNumber, oppMeleeNumber, oppRangeNumber, oppTotalNumber;
    String cardOneType, cardTwoType, cardThreeType, cardFourType, cardFiveType, cardSixType,cardSevenType, cardEightType;
    String oppCardOneType, oppCardTwoType, oppCardThreeType, oppCardFourType, oppCardFiveType, oppCardSixType, oppCardSevenType, oppCardEightType;
    boolean leftOver;
    Image blank, backOfCard, playedCardOne, playedCardTwo, playedCardThree, playedCardFour, playedCardFive, playedCardSix,playedCardSeven,playedCardEight;
    Image cardSixImage, cardSevenImage, cardEightImage, oppLeader,plyrLeader, plyrBackDeck;
    Image oppPlayedCardOne, oppPlayedCardTwo, oppPlayedCardThree, oppPlayedCardFour, oppPlayedCardFive,oppPlayedCardSix,oppPlayedCardSeven,oppPlayedCardEight;
    int oppHand, plyrPoints, oppPoints;
    int round;


    String playerChoice =characterSelectController.playerSelection;
    String oppChoice =characterSelectController.computerSelection;



    @Override
    public void initialize(URL location, ResourceBundle resources) throws NullPointerException {

        Card obj = new Card();
        gameBoard.setImage(obj.getTableImage());

        roundLabel.setText("ROUND:1");
        oppMeleeScore.setText("0");
        oppRangeScore.setText("0");
        plyrMeleeScore.setText("0");
        plyrRangeScore.setText("0");
        oppTotalScore.setText("0");
        plyrTotalScore.setText("0");
        blank = new Image("./Images/blank.jpg");
        if(playerChoice == "black"){
            plyrBackDeck = new Image("./Images/blackDeck.jpg");
            plyrLeader = new Image("./Images/Black_Leader.jpg");
           playerCharacter .setImage(plyrLeader);}
        if(playerChoice == "blue"){
            plyrBackDeck = new Image("./Images/blueDeck.jpg");
            plyrLeader = new Image("./Images/Blue_Leader.jpg");
            playerCharacter .setImage(plyrLeader);}
        if(playerChoice == "red"){
            plyrBackDeck = new Image("./Images/bossDeck.jpg");
            plyrLeader = new Image("./Images/Boss_Leader.jpg");
            playerCharacter .setImage(plyrLeader);}
        if(playerChoice == "green"){
            plyrBackDeck = new Image("./Images/greenDeck.jpg");
            plyrLeader = new Image("./Images/Green_Leader.jpg");
            playerCharacter .setImage(plyrLeader);}
        if(oppChoice == "black"){
        backOfCard = new Image("./Images/blackDeck.jpg");
        oppLeader = new Image("./Images/Black_Leader.jpg");
        oppCharacter.setImage(oppLeader);}
        if(oppChoice == "blue"){
            backOfCard = new Image("./Images/blueDeck.jpg");
            oppLeader = new Image("./Images/Blue_Leader.jpg");
            oppCharacter.setImage(oppLeader);}
        if(oppChoice == "green"){
            backOfCard = new Image("./Images/greenDeck.jpg");
            oppLeader = new Image("./Images/Green_Leader.jpg");
            oppCharacter.setImage(oppLeader);}
        if(oppChoice == "red"){
            backOfCard = new Image("./Images/bossDeck.jpg");
            oppLeader = new Image("./Images/Boss_Leader.jpg");
            oppCharacter.setImage(oppLeader);}


        Card plyrDeck[] = new Card[9];
        Card oppDeck[] = new Card[9];

        simulateGame game = new simulateGame(plyrDeck, oppDeck, playerChoice, oppChoice);


        cardOne.setImage(game.getCardImage(plyrDeck, 0));
        setCardOneStats(plyrDeck, 0);
        cardTwo.setImage(game.getCardImage(plyrDeck, 1));
        setCardTwoStats(plyrDeck, 1);
        cardThree.setImage(game.getCardImage(plyrDeck, 2));
        setCardThreeStats(plyrDeck, 2);
        cardFour.setImage(game.getCardImage(plyrDeck, 3));
        setCardFourStats(plyrDeck, 3);
        cardFive.setImage(game.getCardImage(plyrDeck, 4));
        setCardFiveStats(plyrDeck, 4);

        cardSix.setImage(blank);
        cardSixImage = game.getCardImage(plyrDeck, 5);
        setCardSixStats(plyrDeck, 5);
        cardSeven.setImage(blank);
        cardSevenImage = game.getCardImage(plyrDeck, 6);
        setCardSevenStats(plyrDeck, 6);
        cardEight.setImage(blank);
        cardEightImage = game.getCardImage(plyrDeck, 7);
        setCardEightStats(plyrDeck, 7);

        plyrDeckImage.setImage(plyrBackDeck);
        oppBackDeck.setImage(backOfCard);
        oppCardOne.setImage(backOfCard);
        oppCardTwo.setImage(backOfCard);
        oppCardThree.setImage(backOfCard);
        oppCardFour.setImage(backOfCard);
        oppCardFive.setImage(backOfCard);
        oppPlayedCardOne = oppDeck[0].getImage();
        setOppCardOneStats(oppDeck, 0);
        oppPlayedCardTwo = oppDeck[1].getImage();
        setOppCardTwoStats(oppDeck, 1);
        oppPlayedCardThree = oppDeck[2].getImage();
        setOppCardThreeStats(oppDeck, 2);
        oppPlayedCardFour = oppDeck[3].getImage();
        setOppCardFourStats(oppDeck, 3);
        oppPlayedCardFive = oppDeck[4].getImage();
        setOppCardFiveStats(oppDeck, 4);
        oppPlayedCardSix = oppDeck[5].getImage();
        setOppCardSixStats(oppDeck, 5);
        oppPlayedCardSeven = oppDeck[6].getImage();
        setOppCardSevenStats(oppDeck, 6);
        oppPlayedCardEight = oppDeck[7].getImage();
        setOppCardEightStats(oppDeck, 7);
        endTurnButton.setDisable(true);
        resultsButton.setDisable(true);



    }




    public int determineWinner(ActionEvent event) throws IOException{
        if(plyrPoints > oppPoints && round > 0){
            resetBoard();
            round =0;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FinalResultScreen.fxml"));
            Parent matchResult1 = loader.load();
            Scene roundScene = new Scene(matchResult1);
            MatchResultsController controller = loader.getController();

            controller.showResults("YOU WON THE MATCH");



            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(roundScene);
            window.show();
            return 1;
        }
        if(plyrPoints == oppPoints && round > 1){
            resetBoard();
            round =0;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FinalResultScreen.fxml"));
            Parent roundResult = loader.load();
            Scene roundScene = new Scene(roundResult);
            MatchResultsController controller = loader.getController();

            controller.showResults("MATCH ENDED IN A DRAW");



            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(roundScene);
            window.show();
            return 1;

        }
        if(oppPoints > plyrPoints && round > 0){
            resetBoard();
            round =0;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FinalResultScreen.fxml"));
            Parent roundResult = loader.load();
            Scene roundScene = new Scene(roundResult);
            MatchResultsController controller = loader.getController();

            controller.showResults("YOU LOST THE MATCH");



            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(roundScene);
            window.show();
            return 1;
        }
        return 0;

    }
    public void resetBoard(){
        turnButton.setText("YOUR TURN");
        plyrRoundPass = false;
        plyrTurnPass = false;
        plyrTotalNumber = 0;
        plyrMeleeNumber = 0;
        plyrRangeNumber = 0;
        oppMeleeNumber = 0;
        oppRangeNumber = 0;
        oppTotalNumber = 0;
        oppMeleeScore.setText("0");
        oppRangeScore.setText("0");
        plyrMeleeScore.setText("0");
        plyrRangeScore.setText("0");
        oppTotalScore.setText("0");
        plyrTotalScore.setText("0");
        plyrPassLabel.setText(null);
        oppPassLabel.setText(null);
        meleeOne.setImage(null);
        meleeTwo.setImage(null);
        meleeThree.setImage(null);
        meleeFour.setImage(null);
        oppMeleeOne.setImage(null);
        oppMeleeTwo.setImage(null);
        oppMeleeThree.setImage(null);
        oppMeleeFour.setImage(null);
        rangedOne.setImage(null);
        rangedTwo.setImage(null);
        rangedThree.setImage(null);
        rangedFour.setImage(null);
        oppRangedOne.setImage(null);
        oppRangedTwo.setImage(null);
        oppRangedThree.setImage(null);
        oppRangedFour.setImage(null);
        effectOne.setImage(null);
        effectTwo.setImage(null);
        effectThree.setImage(null);
        effectFour.setImage(null);
        endTurnButton.setDisable(true);
        resultsButton.setDisable(true);
        round++;
        roundLabel.setText("ROUND:1");

        if(round == 1){

            oppCardSix.setImage(backOfCard);
            oppCardSeven.setImage(backOfCard);
            cardSix.setImage(cardSixImage);
            cardSeven.setImage(cardSevenImage);
            roundLabel.setText("ROUND:2");

        }
        if(round == 2){

            oppCardEight.setImage(backOfCard);
            cardEight.setImage(cardEightImage);
            roundLabel.setText("ROUND:3");
        }
    }
    private void oppTurn() {
        if (plyrRoundPass == true && oppTotalNumber > plyrTotalNumber || (plyrTotalNumber - oppTotalNumber) > 12 && mustWin == false) {
            oppPassLabel.setText("Opponent Passes");
            return;
        }
        if(oppHand == 6 && round > 0){

            turnButton.setText("YOUR TURN");
            if (plyrRoundPass == true && oppTotalNumber > plyrTotalNumber || (plyrTotalNumber - oppTotalNumber) > 10 && mustWin == false) {
                oppPassLabel.setText("Opponent Passes");
                return;
            }
            oppCardSeven.setImage(blank);
            if (oppCardSevenType == "effectMelee") {
                plyrMeleeNumber = plyrMeleeNumber - 4;
                plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                plyrMeleeScore.setText(String.format("%d", plyrMeleeNumber));
                plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                effectThree.setImage(oppPlayedCardSeven);

            }
            if (oppCardSevenType == "effectRange") {
                plyrRangeNumber = plyrRangeNumber - 4;
                plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                plyrRangeScore.setText(String.format("%d", plyrRangeNumber));
                plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                effectFour.setImage(oppPlayedCardSeven);

            }
            if (oppCardSevenType == "melee") {
                oppMeleeNumber = oppMeleeNumber + oppCardSevenAttack;
                oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                oppMeleeScore.setText(String.format("%d", oppMeleeNumber));
                oppTotalScore.setText(String.format("%d", oppTotalNumber));

                if (oppMelee[0] == false) {
                    oppMeleeOne.setImage(oppPlayedCardSeven);
                    oppMelee[0] = true;
                } else if (oppMelee[1] == false) {
                    oppMeleeTwo.setImage(oppPlayedCardSeven);
                    oppMelee[1] = true;
                } else if (oppMelee[2] == false) {
                    oppMeleeThree.setImage(oppPlayedCardSeven);
                    oppMelee[2] = true;
                } else if(oppMelee[3] == false){
                    oppMeleeFour.setImage(oppPlayedCardSeven);
                    oppMelee[3] = true;
                }

            }
            if (oppCardSevenType == "range") {
                oppRangeNumber = oppRangeNumber + oppCardSevenAttack;
                oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                oppRangeScore.setText(String.format("%d", oppRangeNumber));
                oppTotalScore.setText(String.format("%d", oppTotalNumber));
                if (oppRanged[0] == false) {
                    oppRangedOne.setImage(oppPlayedCardSeven);
                    oppRanged[0] = true;
                } else if (oppRanged[1] == false) {
                    oppRangedTwo.setImage(oppPlayedCardSeven);
                    oppRanged[1] = true;
                } else if (oppRanged[2] == false) {
                    oppRangedThree.setImage(oppPlayedCardSeven);
                    oppRanged[2] = true;
                } else {
                    oppRangedFour.setImage(oppPlayedCardSeven);
                    oppRanged[3] = true;
                }
            }
            oppHand++;
            return;

        }

        if (oppHand > 6 && round > 1 && leftOver == false) {

            turnButton.setText("YOUR TURN");
            leftOver = true;
            oppCardEight.setImage(blank);
            if (oppCardEightType == "effectMelee") {
                plyrMeleeNumber = plyrMeleeNumber - 4;
                plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                plyrMeleeScore.setText(String.format("%d", plyrMeleeNumber));
                plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                effectThree.setImage(oppPlayedCardEight);

            }
            if (oppCardEightType == "effectRange") {
                plyrRangeNumber = plyrRangeNumber - 4;
                plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                plyrRangeScore.setText(String.format("%d", plyrRangeNumber));
                plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                effectFour.setImage(oppPlayedCardEight);
            }

            if (oppCardEightType == "melee") {
                oppMeleeNumber = oppMeleeNumber + oppCardEightAttack;
                oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                oppMeleeScore.setText(String.format("%d", oppMeleeNumber));
                oppTotalScore.setText(String.format("%d", oppTotalNumber));

                if (oppMelee[0] == false) {
                    oppMeleeOne.setImage(oppPlayedCardEight);
                    oppMelee[0] = true;
                } else if (oppMelee[1] == false) {
                    oppMeleeTwo.setImage(oppPlayedCardEight);
                    oppMelee[1] = true;
                } else if (oppMelee[2] == false) {
                    oppMeleeThree.setImage(oppPlayedCardEight);
                    oppMelee[2] = true;
                } else if (oppMelee[3] == false) {
                    oppMeleeFour.setImage(oppPlayedCardEight);
                    oppMelee[3] = true;
                }

            }
            if (oppCardEightType == "range") {
                oppRangeNumber = oppRangeNumber + oppCardEightAttack;
                oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                oppRangeScore.setText(String.format("%d", oppRangeNumber));
                oppTotalScore.setText(String.format("%d", oppTotalNumber));
                if (oppRanged[0] == false) {
                    oppRangedOne.setImage(oppPlayedCardEight);
                    oppRanged[0] = true;
                } else if (oppRanged[1] == false) {
                    oppRangedTwo.setImage(oppPlayedCardEight);
                    oppRanged[1] = true;
                } else if (oppRanged[2] == false) {
                    oppRangedThree.setImage(oppPlayedCardEight);
                    oppRanged[2] = true;
                } else {
                    oppRangedFour.setImage(oppPlayedCardEight);
                    oppRanged[3] = true;
                }
            }

            oppHand++;
            return;
        }


        if(oppHand >= 8 ){return;}

        try{Thread.sleep(1600);}
        catch(Exception e){}

        if(oppHand == 5 && round > 0){

            turnButton.setText("YOUR TURN");
            if (plyrRoundPass == true && oppTotalNumber > plyrTotalNumber || (plyrTotalNumber - oppTotalNumber) > 10 && mustWin == false) {
                oppPassLabel.setText("Opponent Passes");
                return;
            }
            oppCardSix.setImage(blank);
        if (oppCardSixType == "effectMelee") {
            plyrMeleeNumber = plyrMeleeNumber - 4;
            plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
            plyrMeleeScore.setText(String.format("%d", plyrMeleeNumber));
            plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
            effectThree.setImage(oppPlayedCardSix);

        }
        if (oppCardSixType == "effectRange") {
            plyrRangeNumber = plyrRangeNumber - 4;
            plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
            plyrRangeScore.setText(String.format("%d", plyrRangeNumber));
            plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
            effectFour.setImage(oppPlayedCardSix);
        }
            if (oppCardSixType == "melee") {
                oppMeleeNumber = oppMeleeNumber + oppCardSixAttack;
                oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                oppMeleeScore.setText(String.format("%d", oppMeleeNumber));
                oppTotalScore.setText(String.format("%d", oppTotalNumber));

                if (oppMelee[0] == false) {
                    oppMeleeOne.setImage(oppPlayedCardSix);
                    oppMelee[0] = true;
                } else if (oppMelee[1] == false) {
                    oppMeleeTwo.setImage(oppPlayedCardSix);
                    oppMelee[1] = true;
                } else if (oppMelee[2] == false) {
                    oppMeleeThree.setImage(oppPlayedCardSix);
                    oppMelee[2] = true;
                } else if(oppMelee[3] == false){
                    oppMeleeFour.setImage(oppPlayedCardSix);
                    oppMelee[3] = true;
                }

            }
            if (oppCardSixType == "range") {
                oppRangeNumber = oppRangeNumber + oppCardSixAttack;
                oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                oppRangeScore.setText(String.format("%d", oppRangeNumber));
                oppTotalScore.setText(String.format("%d", oppTotalNumber));
                if (oppRanged[0] == false) {
                    oppRangedOne.setImage(oppPlayedCardSix);
                    oppRanged[0] = true;
                } else if (oppRanged[1] == false) {
                    oppRangedTwo.setImage(oppPlayedCardSix);
                    oppRanged[1] = true;
                } else if (oppRanged[2] == false) {
                    oppRangedThree.setImage(oppPlayedCardSix);
                    oppRanged[2] = true;
                } else {
                    oppRangedFour.setImage(oppPlayedCardSix);
                    oppRanged[3] = true;
                }
            }

            oppHand++;
            return;

        }




        if (oppHand < 5 ) {

            turnButton.setText("YOUR TURN");

            if (plyrRoundPass == true && oppTotalNumber > plyrTotalNumber || (plyrTotalNumber - oppTotalNumber) > 10 && mustWin == false) {
                oppPassLabel.setText("Opponent Passes");
                return;
            }
            if (oppHand == 0) {
                oppCardOne.setImage(blank);
                if (oppCardOneType == "effectMelee") {
                    plyrMeleeNumber = plyrMeleeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrMeleeScore.setText(String.format("%d", plyrMeleeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectThree.setImage(oppPlayedCardOne);
                }
                if (oppCardOneType == "effectRange") {
                    plyrRangeNumber = plyrRangeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrRangeScore.setText(String.format("%d", plyrRangeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectFour.setImage(oppPlayedCardOne);
                }

                if (oppCardOneType == "melee") {
                    oppMeleeNumber = oppMeleeNumber + oppCardOneAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppMeleeScore.setText(String.format("%d", oppMeleeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));
                    oppMeleeOne.setImage(oppPlayedCardOne);
                    oppMelee[oppHand] = true;
                }

                if (oppCardOneType == "range") {
                    oppRangeNumber = oppRangeNumber + oppCardOneAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppRangeScore.setText(String.format("%d", oppRangeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));
                    oppRangedOne.setImage(oppPlayedCardOne);
                    oppRanged[oppHand] = true;
                }
                turnButton.setText("YOUR TURN");
            }
            if (oppHand == 1) {
                turnButton.setText("YOUR TURN");
                oppCardTwo.setImage(blank);
                if (oppCardTwoType == "effectMelee") {
                    plyrMeleeNumber = plyrMeleeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrMeleeScore.setText(String.format("%d", plyrMeleeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectThree.setImage(oppPlayedCardTwo);
                }
                if (oppCardTwoType == "effectRange") {
                    plyrRangeNumber = plyrRangeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrRangeScore.setText(String.format("%d", plyrRangeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectFour.setImage(oppPlayedCardTwo);
                }
                if (oppCardTwoType == "melee") {
                    oppMeleeNumber = oppMeleeNumber + oppCardTwoAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppMeleeScore.setText(String.format("%d", oppMeleeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));
                    if (oppMelee[0] == false) {
                        oppMeleeOne.setImage(oppPlayedCardTwo);
                        oppMelee[0] = true;
                    } else {
                        oppMeleeTwo.setImage(oppPlayedCardTwo);
                        oppMelee[1] = true;
                    }
                }

                if (oppCardTwoType == "range") {
                    oppRangeNumber = oppRangeNumber + oppCardTwoAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppRangeScore.setText(String.format("%d", oppRangeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));
                    if (oppRanged[0] == false) {
                        oppRangedOne.setImage(oppPlayedCardTwo);
                        oppRanged[0] = true;
                    } else {
                        oppRangedTwo.setImage(oppPlayedCardTwo);
                        oppRanged[1] = true;
                    }
                }

            }
            if (oppHand == 2) {
                turnButton.setText("YOUR TURN");
                oppCardThree.setImage(blank);
                if (oppCardThreeType == "effectMelee") {
                    plyrMeleeNumber = plyrMeleeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrMeleeScore.setText(String.format("%d", plyrMeleeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectThree.setImage(oppPlayedCardThree);
                }
                if (oppCardThreeType == "effectRange") {
                    plyrRangeNumber = plyrRangeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrRangeScore.setText(String.format("%d", plyrRangeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectFour.setImage(oppPlayedCardThree);
                }
                if (oppCardThreeType == "melee") {
                    oppMeleeNumber = oppMeleeNumber + oppCardThreeAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppMeleeScore.setText(String.format("%d", oppMeleeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));

                    if (oppMelee[0] == false) {
                        oppMeleeOne.setImage(oppPlayedCardThree);
                        oppMelee[0] = true;
                    } else if (oppMelee[1] == false) {
                        oppMeleeTwo.setImage(oppPlayedCardThree);
                        oppMelee[1] = true;
                    } else {
                        oppMeleeThree.setImage(oppPlayedCardThree);
                        oppMelee[2] = true;
                    }
                }

                if (oppCardThreeType == "range") {
                    oppRangeNumber = oppRangeNumber + oppCardThreeAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppRangeScore.setText(String.format("%d", oppRangeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));
                    if (oppRanged[0] == false) {
                        oppRangedOne.setImage(oppPlayedCardThree);
                        oppRanged[0] = true;
                    } else if (oppRanged[1] == false) {
                        oppRangedTwo.setImage(oppPlayedCardThree);
                        oppRanged[1] = true;
                    } else {
                        oppRangedThree.setImage(oppPlayedCardThree);
                        oppRanged[2] = true;
                    }
                }

            }
            if (oppHand == 3) {
                turnButton.setText("YOUR TURN");
                oppCardFour.setImage(blank);
                if (oppCardFourType == "effectMelee") {
                    plyrMeleeNumber = plyrMeleeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrMeleeScore.setText(String.format("%d", plyrMeleeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectThree.setImage(oppPlayedCardFour);
                }
                if (oppCardFourType == "effectRange") {
                    plyrRangeNumber = plyrRangeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrRangeScore.setText(String.format("%d", plyrRangeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectFour.setImage(oppPlayedCardFour);
                }
                if (oppCardFourType == "melee") {
                    oppMeleeNumber = oppMeleeNumber + oppCardFourAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppMeleeScore.setText(String.format("%d", oppMeleeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));

                    if (oppMelee[0] == false) {
                        oppMeleeOne.setImage(oppPlayedCardFour);
                        oppMelee[0] = true;
                    } else if (oppMelee[1] == false) {
                        oppMeleeTwo.setImage(oppPlayedCardFour);
                        oppMelee[1] = true;
                    } else if (oppMelee[2] == false) {
                        oppMeleeThree.setImage(oppPlayedCardFour);
                        oppMelee[2] = true;
                    } else {
                        oppMeleeFour.setImage(oppPlayedCardFour);
                        oppMelee[3] = true;
                    }
                }


                if (oppCardFourType == "range") {
                    oppRangeNumber = oppRangeNumber + oppCardFourAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppRangeScore.setText(String.format("%d", oppRangeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));
                    if (oppRanged[0] == false) {
                        oppRangedOne.setImage(oppPlayedCardFour);
                        oppRanged[0] = true;
                    } else if (oppRanged[1] == false) {
                        oppRangedTwo.setImage(oppPlayedCardFour);
                        oppRanged[1] = true;
                    } else if (oppRanged[2] == false) {
                        oppRangedThree.setImage(oppPlayedCardFour);
                        oppRanged[2] = true;
                    } else {
                        oppRangedFour.setImage(oppPlayedCardFour);
                        oppRanged[3] = true;
                    }
                }
            }
            if (oppHand == 4) {
                turnButton.setText("YOUR TURN");
                oppCardFive.setImage(blank);
                if (oppCardFiveType == "effectMelee") {
                    plyrMeleeNumber = plyrMeleeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrMeleeScore.setText(String.format("%d", plyrMeleeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectThree.setImage(oppPlayedCardFive);

                }
                if (oppCardFiveType == "effectRange") {
                    plyrRangeNumber = plyrRangeNumber - 4;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrRangeScore.setText(String.format("%d", plyrRangeNumber));
                    plyrTotalScore.setText(String.format("%d", plyrTotalNumber));
                    effectFour.setImage(oppPlayedCardFive);

                }
                if (oppCardFiveType == "melee") {
                    oppMeleeNumber = oppMeleeNumber + oppCardFiveAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppMeleeScore.setText(String.format("%d", oppMeleeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));

                    if (oppMelee[0] == false) {
                        oppMeleeOne.setImage(oppPlayedCardFive);
                        oppMelee[0] = true;
                    } else if (oppMelee[1] == false) {
                        oppMeleeTwo.setImage(oppPlayedCardFive);
                        oppMelee[1] = true;
                    } else if (oppMelee[2] == false) {
                        oppMeleeThree.setImage(oppPlayedCardFive);
                        oppMelee[2] = true;
                    } else if(oppMelee[3] == false){
                        oppMeleeFour.setImage(oppPlayedCardFive);
                        oppMelee[3] = true;
                    }

                }
                if (oppCardFiveType == "range") {
                    oppRangeNumber = oppRangeNumber + oppCardFiveAttack;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppRangeScore.setText(String.format("%d", oppRangeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));
                    if (oppRanged[0] == false) {
                        oppRangedOne.setImage(oppPlayedCardFive);
                        oppRanged[0] = true;
                    } else if (oppRanged[1] == false) {
                        oppRangedTwo.setImage(oppPlayedCardFive);
                        oppRanged[1] = true;
                    } else if (oppRanged[2] == false) {
                        oppRangedThree.setImage(oppPlayedCardFive);
                        oppRanged[2] = true;
                    } else {
                        oppRangedFour.setImage(oppPlayedCardFive);
                        oppRanged[3] = true;
                    }
                }

            }
            oppHand++;
        }
        //oppHand++;
        if(plyrRoundPass==true && oppHand < 5)
        {
            oppTurn();
        }
    }
    public void endTurn(ActionEvent event){
        if(plyrTurnPass == false)
        {
            plyrPassLabel.setText("You must play a card or End Round");
            return;
        } else{
            turnButton.setText(" ");

            oppTurn();
            plyrTurnPass = false;
            endTurnButton.setDisable(true);
        }


    }


    public void endRound(ActionEvent event)  {
        turnButton.setText(" ");
        plyrRoundPass = true;
        plyrPassLabel.setText("You Passed");
        oppTurn();
        resultsButton.setDisable(false);
    }
    public void getResults(ActionEvent event) throws IOException {
        turnButton.setText(" ");
        if(plyrTotalNumber > oppTotalNumber){
            plyrPoints++;
            mustWin = true;

        }
        if(oppTotalNumber > plyrTotalNumber){
            oppPoints++;

        }
        int i = determineWinner(event);
        if(i == 0) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ResultScreenView.fxml"));
            Parent roundResult = loader.load();
            Scene roundScene = new Scene(roundResult);
            ResultsController controller = loader.getController();

            controller.showResults(plyrTotalNumber, oppTotalNumber);

            resetBoard();



            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(roundScene);
            window.show();
        }
    }
    public void setOppCardOneStats(Card[] deck, int cardNumber){
        oppCardOneAttack = deck[cardNumber].getAttack();
        oppCardOneType = deck[cardNumber].getType();

    }
    public void setOppCardTwoStats(Card[] deck, int cardNumber){
        oppCardTwoAttack = deck[cardNumber].getAttack();
        oppCardTwoType = deck[cardNumber].getType();

    }
    public void setOppCardThreeStats(Card[] deck, int cardNumber){
        oppCardThreeAttack = deck[cardNumber].getAttack();
        oppCardThreeType = deck[cardNumber].getType();

    }
    public void setOppCardFourStats(Card[] deck, int cardNumber){
        oppCardFourAttack = deck[cardNumber].getAttack();
        oppCardFourType = deck[cardNumber].getType();

    }
    public void setOppCardFiveStats(Card[] deck, int cardNumber){
        oppCardFiveAttack = deck[cardNumber].getAttack();
        oppCardFiveType = deck[cardNumber].getType();

    }
    public void setOppCardSixStats(Card[] deck, int cardNumber){
        oppCardSixAttack = deck[cardNumber].getAttack();
        oppCardSixType = deck[cardNumber].getType();

    }
    public void setOppCardSevenStats(Card[] deck, int cardNumber){
        oppCardSevenAttack = deck[cardNumber].getAttack();
        oppCardSevenType = deck[cardNumber].getType();

    }
    public void setOppCardEightStats(Card[] deck, int cardNumber){
        oppCardEightAttack = deck[cardNumber].getAttack();
        oppCardEightType = deck[cardNumber].getType();

    }

    public void setCardOneStats(Card[] deck, int cardNumber){
        cardOneAttack = deck[cardNumber].getAttack();
        cardOneType = deck[cardNumber].getType();
        playedCardOne = cardOne.getImage();

    }





    @FXML private void cardOneSelect(MouseEvent event){

            playCard(cardOnePlayed,cardOne,cardOneType,playedCardOne, cardOneAttack,1);
        }

    public void setCardTwoStats(Card[] deck, int cardNumber){
        cardTwoAttack = deck[cardNumber].getAttack();
        cardTwoType = deck[cardNumber].getType();
        playedCardTwo = cardTwo.getImage();

    }
    @FXML private void cardTwoSelect(MouseEvent event) {
            playCard(cardTwoPlayed,cardTwo,cardTwoType,playedCardTwo, cardTwoAttack,2);
        }



    public void setCardThreeStats(Card[] deck, int cardNumber){
        cardThreeAttack = deck[cardNumber].getAttack();
        cardThreeType = deck[cardNumber].getType();
        playedCardThree = cardThree.getImage();

    }
    @FXML private void cardThreeSelect(MouseEvent event){

            playCard(cardThreePlayed,cardThree,cardThreeType,playedCardThree, cardThreeAttack,3);
        }

    public void setCardFourStats(Card[] deck, int cardNumber){
        cardFourAttack = deck[cardNumber].getAttack();
        cardFourType = deck[cardNumber].getType();
        playedCardFour = cardFour.getImage();

    }
    @FXML private void cardFourSelect(MouseEvent event){

            playCard(cardFourPlayed,cardFour,cardFourType,playedCardFour, cardFourAttack,4);
        }


    public void setCardFiveStats(Card[] deck, int cardNumber){
        cardFiveAttack = deck[cardNumber].getAttack();
        cardFiveType = deck[cardNumber].getType();
        playedCardFive = cardFive.getImage();

    }
    private void playCard(boolean cardPlayed,ImageView card,String cardType,Image cardImage, int cardAttack, int cardNum)
    {
        if(plyrTurnPass == true){
            return;
        }
        else if((cardPlayed == false && round >= 0 && cardNum < 6) ||(cardPlayed == false && round >= 1 && cardNum < 8) || (cardPlayed == false && round == 2 && cardNum ==8)) {
            endTurnButton.setDisable(false);
            Image blank = new Image("./Images/blank.jpg");
            plyrTurnPass = true;
            card.setImage(blank);
            int i =0;

                if (cardType == "effectMelee") {
                    oppMeleeNumber = oppMeleeNumber - 4;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppMeleeScore.setText(String.format("%d", oppMeleeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));
                    effectTwo.setImage(cardImage);
                    return;

                }
                if (cardType == "effectRange") {
                    oppRangeNumber = oppRangeNumber - 4;
                    oppTotalNumber = oppMeleeNumber + oppRangeNumber;
                    oppRangeScore.setText(String.format("%d", oppRangeNumber));
                    oppTotalScore.setText(String.format("%d", oppTotalNumber));
                    effectOne.setImage(cardImage);
                    return;

                }

            while (i < 4) {
                if (cardType == "melee" && melee[i] == false) {
                    plyrMeleeNumber = plyrMeleeNumber + cardAttack;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrMeleeScore.setText(String.format("%d",plyrMeleeNumber));
                    plyrTotalScore.setText(String.format("%d",plyrTotalNumber));

                    if (i == 0) {
                        meleeOne.setImage(cardImage);
                        cardPlayed = true;
                        melee[i] = true;
                        i = 10;
                    }
                    if (i == 1) {
                        meleeTwo.setImage(cardImage);
                        cardPlayed = true;
                        melee[i] = true;
                        i = 10;
                    }
                    if (i == 2) {
                        meleeThree.setImage(cardImage);
                        cardPlayed = true;
                        melee[i] = true;
                        i = 10;
                    }
                    if (i == 3) {
                        meleeFour.setImage(cardImage);
                        cardPlayed = true;
                        melee[i] = true;
                        i = 10;
                    }

                }
                if (cardType == "range" && ranged[i] == false) {
                    plyrRangeNumber = plyrRangeNumber + cardAttack;
                    plyrTotalNumber = plyrMeleeNumber + plyrRangeNumber;
                    plyrRangeScore.setText(String.format("%d",plyrRangeNumber));
                    plyrTotalScore.setText(String.format("%d",plyrTotalNumber));
                    if (i == 0) {
                        rangedOne.setImage(cardImage);
                        cardPlayed = true;
                        ranged[i] = true;
                        i = 10;

                    }
                    if (i == 1) {
                        rangedTwo.setImage(cardImage);
                        cardPlayed = true;
                        ranged[i] = true;
                        i = 10;

                    }
                    if (i == 2) {
                        rangedThree.setImage(cardImage);
                        cardPlayed = true;
                        ranged[i] = true;
                        i = 10;

                    }
                    if (i == 3) {
                        rangedFour.setImage(cardImage);
                        cardPlayed = true;
                        ranged[i] = true;
                        i = 10;

                    }

                }

                i++;

            }

        }

    }
    @FXML private void cardFiveSelect(MouseEvent event) {
        playCard(cardFivePlayed, cardFive, cardFiveType, playedCardFive, cardFiveAttack, 5);
    }

        @FXML private void cardSixSelect(MouseEvent event){
            playCard(cardSixPlayed,cardSix,cardSixType,playedCardSix, cardSixAttack,6);


        }
        @FXML private void cardSevenSelect(MouseEvent event){
            playCard(cardSevenPlayed,cardSeven,cardSevenType,playedCardSeven, cardSevenAttack,7);

        }

        @FXML private void cardEightSelect(MouseEvent event){
            playCard(cardEightPlayed,cardEight,cardEightType,playedCardEight, cardEightAttack,8);

        }


        public void setCardSixStats(Card[] deck, int cardNumber){
            cardSixAttack = deck[cardNumber].getAttack();
            cardSixType = deck[cardNumber].getType();
            playedCardSix = cardSixImage;

        }
        public void setCardSevenStats(Card[] deck, int cardNumber){
            cardSevenAttack = deck[cardNumber].getAttack();
            cardSevenType = deck[cardNumber].getType();
            playedCardSeven = cardSevenImage;

        }
        public void setCardEightStats(Card[] deck, int cardNumber){
            cardEightAttack = deck[cardNumber].getAttack();
            cardEightType = deck[cardNumber].getType();
            playedCardEight = cardEightImage;

        }


}
