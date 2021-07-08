import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    private int attack;
    private String type;
    private boolean buff, debuff;
    private Image image;
    private Image table;

    public Card(){
        setTable();
    }
    public Card(int attack, String type, boolean buff, boolean debuff, Image image) {
        setAttack(attack);
        setType(type);
        setBuff(buff);
        setDebuff(debuff);
        setImage(image);
        setTable();


    }



    private void setTable(){
        table = new Image("./Images/table.jpg");
    }
    public Image getTableImage(){

        return table;

    }


    public int getAttack() {
        //Effect Cards are non-Attacking Cards
        if(type == "effect"){
            return 0;
        }
        //Card attack has been doubled due to a buff
        else if(buff){
            return attack * 2;
        }
        //Card attack has been lowered due to debuff
        else if(debuff){
            return 1;
        }
        else{
            return attack;
        }

    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getType() {
        return type;
    }
    public static List<String> getValidType()
    {
        return Arrays.asList("melee","range","effectMelee","area","effectRange");
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBuff() {
        return buff;
    }

    public void setBuff(boolean buff) {
        this.buff = buff;
    }

    public boolean isDebuff() {
        return debuff;
    }

    public void setDebuff(boolean debuff) {
        this.debuff = debuff;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
