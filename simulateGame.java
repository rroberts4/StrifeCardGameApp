import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class simulateGame {

    private Image cardImage;

    public simulateGame(Card blueDeck[], Card blackDeck[], String player, String opponent) {
        createDecks(blueDeck,blackDeck,player,opponent);
        shuffleDecks(blueDeck,blackDeck);


    }



    public Image getCardImage(Card[] deck, int cardNumber){

        return deck[cardNumber].getImage();

    }



    public  void createDecks(Card plyrDeck[],Card oppDeck[],String player, String opponent) {




        if(player == "blue"){
        cardImage = new Image("./Images/Blue/Blue_5_1.jpg");

        plyrDeck[0] = new Card(5,"melee",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_5_2.jpg");
        plyrDeck[1] = new Card(5,"melee",false,false,cardImage);  cardImage = new Image("./Images/Blue/Blue_6_1.jpg");
        plyrDeck[2] = new Card(6,"melee",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_10_1.jpg");
        plyrDeck[3] = new Card(10,"melee",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_4_1.jpg");
        plyrDeck[4] = new Card(4,"range",false,false,cardImage);  cardImage = new Image("./Images/Blue/Blue_6_2.jpg");
        plyrDeck[5] = new Card(6,"range",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_8_1.jpg");
        plyrDeck[6] = new Card(8,"range",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_10_2.jpg");
        plyrDeck[7] = new Card(10,"range",false,false,cardImage);
            cardImage = new Image("./Images/Fog_1.jpg");
            plyrDeck[8] = new Card(0, "effectRange", false, false, cardImage);

        }
        if(opponent == "blue"){
            cardImage = new Image("./Images/Blue/Blue_5_1.jpg");

            oppDeck[0] = new Card(5,"melee",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_5_2.jpg");
            oppDeck[1] = new Card(5,"melee",false,false,cardImage);  cardImage = new Image("./Images/Blue/Blue_6_1.jpg");
            oppDeck[2] = new Card(6,"melee",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_10_1.jpg");
            oppDeck[3] = new Card(10,"melee",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_4_1.jpg");
            oppDeck[4] = new Card(4,"range",false,false,cardImage);  cardImage = new Image("./Images/Blue/Blue_6_2.jpg");
            oppDeck[5] = new Card(6,"range",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_8_1.jpg");
            oppDeck[6] = new Card(8,"range",false,false,cardImage); cardImage = new Image("./Images/Blue/Blue_10_2.jpg");
            oppDeck[7] = new Card(10,"range",false,false,cardImage);
            cardImage = new Image("./Images/Fog_1.jpg");
            oppDeck[8] = new Card(0, "effectRange", false, false, cardImage);
        }
        if(player == "black") {
            cardImage = new Image("./Images/Black/Black_4_1.jpg");


            plyrDeck[0] = new Card(4, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_5_3.jpg");
            plyrDeck[1] = new Card(5, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_10_3.jpg");
            plyrDeck[2] = new Card(10, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_10_2.jpg");
            plyrDeck[3] = new Card(10, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_10_1.jpg");
            plyrDeck[4] = new Card(10, "range", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_6_1.jpg");
            plyrDeck[5] = new Card(6, "range", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_5_1.jpg");
            plyrDeck[6] = new Card(5, "range", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_5_2.jpg");
            plyrDeck[7] = new Card(5, "range", false, false, cardImage);
            cardImage = new Image("./Images/Fog_1.jpg");
            plyrDeck[8] = new Card(0, "effectRange", false, false, cardImage);

        }
        if(opponent == "black") {
            cardImage = new Image("./Images/Black/Black_4_1.jpg");


            oppDeck[0] = new Card(4, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_5_3.jpg");
            oppDeck[1] = new Card(5, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_10_3.jpg");
            oppDeck[2] = new Card(10, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_10_2.jpg");
            oppDeck[3] = new Card(10, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_10_1.jpg");
            oppDeck[4] = new Card(10, "range", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_6_1.jpg");
            oppDeck[5] = new Card(6, "range", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_5_1.jpg");
            oppDeck[6] = new Card(5, "range", false, false, cardImage);
            cardImage = new Image("./Images/Black/Black_5_2.jpg");
            oppDeck[7] = new Card(5, "range", false, false, cardImage);
            cardImage = new Image("./Images/Fog_1.jpg");
            oppDeck[8] = new Card(0, "effectRange", false, false, cardImage);
        }
        if(player == "green"){
        cardImage = new Image("./Images/Green/Green_5_1.jpg");


        plyrDeck[0] = new Card(5,"melee",false,false,cardImage); cardImage = new Image("./Images/Green/Green_5_2.jpg");
        plyrDeck[1] = new Card(5,"melee",false,false,cardImage); cardImage = new Image("./Images/Green/Green_6_1.jpg");
        plyrDeck[2] = new Card(6,"melee",false,false,cardImage); cardImage = new Image("./Images/Green/Green_10_1.jpg");
        plyrDeck[3] = new Card(10,"melee",false,false,cardImage); cardImage = new Image("./Images/Green/Green_4_1.jpg");
        plyrDeck[4] = new Card(4,"range",false,false,cardImage); cardImage = new Image("./Images/Green/Green_10_3.jpg");
        plyrDeck[5] = new Card(10,"range",false,false,cardImage); cardImage = new Image("./Images/Green/Green_3_1.jpg");
        plyrDeck[6] = new Card(3,"range",false,false,cardImage); cardImage = new Image("./Images/Green/Green_10_2.jpg");
        plyrDeck[7] = new Card(10,"range",false,false,cardImage);
            cardImage = new Image("./Images/Fog_1.jpg");
            plyrDeck[8] = new Card(0, "effectRange", false, false, cardImage);

        }
        if(opponent == "green"){
            cardImage = new Image("./Images/Green/Green_5_1.jpg");


            oppDeck[0] = new Card(5,"melee",false,false,cardImage); cardImage = new Image("./Images/Green/Green_5_2.jpg");
            oppDeck[1] = new Card(5,"melee",false,false,cardImage); cardImage = new Image("./Images/Green/Green_6_1.jpg");
            oppDeck[2] = new Card(6,"melee",false,false,cardImage); cardImage = new Image("./Images/Green/Green_10_1.jpg");
            oppDeck[3] = new Card(10,"melee",false,false,cardImage); cardImage = new Image("./Images/Green/Green_4_1.jpg");
            oppDeck[4] = new Card(4,"range",false,false,cardImage); cardImage = new Image("./Images/Green/Green_10_3.jpg");
            oppDeck[5] = new Card(10,"range",false,false,cardImage); cardImage = new Image("./Images/Green/Green_3_1.jpg");
            oppDeck[6] = new Card(3,"range",false,false,cardImage); cardImage = new Image("./Images/Green/Green_10_2.jpg");
            oppDeck[7] = new Card(10,"range",false,false,cardImage);
            cardImage = new Image("./Images/Frost_1.jpg");
            oppDeck[8] = new Card(0, "effectMelee", false, false, cardImage);
        }
        if(player == "red") {
            cardImage = new Image("./Images/Boss/Boss_6_3.jpg");

            plyrDeck[0] = new Card(6, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_4.jpg");
            plyrDeck[1] = new Card(6, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_5.jpg");
            plyrDeck[2] = new Card(6, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_10_1.jpg");
            plyrDeck[3] = new Card(10, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_10_2.jpg");
            plyrDeck[4] = new Card(10, "range", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_1.jpg");
            plyrDeck[5] = new Card(6, "range", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_2.jpg");
            plyrDeck[6] = new Card(6, "range", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_6.jpg");
            plyrDeck[7] = new Card(6, "range", false, false, cardImage);

            cardImage = new Image("./Images/Frost_1.jpg");
            plyrDeck[8] = new Card(0, "effectMelee", false, false, cardImage);
        }
        if(opponent == "red") {
            cardImage = new Image("./Images/Boss/Boss_6_3.jpg");

            oppDeck[0] = new Card(6, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_4.jpg");
            oppDeck[1] = new Card(6, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_5.jpg");
            oppDeck[2] = new Card(6, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_10_1.jpg");
            oppDeck[3] = new Card(10, "melee", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_10_2.jpg");
            oppDeck[4] = new Card(10, "range", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_1.jpg");
            oppDeck[5] = new Card(6, "range", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_2.jpg");
            oppDeck[6] = new Card(6, "range", false, false, cardImage);
            cardImage = new Image("./Images/Boss/Boss_6_6.jpg");
            oppDeck[7] = new Card(6, "range", false, false, cardImage);
            cardImage = new Image("./Images/Fog_1.jpg");
            oppDeck[8] = new Card(0, "effectRange", false, false, cardImage);

        }
    }

    private static void shuffleDecks(Card plyDeck[],Card oppDeck[]) {

        List<Card> plyrCardList = Arrays.asList(plyDeck);
        List<Card> oppCardList = Arrays.asList(oppDeck);


        Collections.shuffle(plyrCardList);
        Collections.shuffle(oppCardList);


        plyrCardList.toArray(plyDeck);
        oppCardList.toArray(oppDeck);

    }


}


