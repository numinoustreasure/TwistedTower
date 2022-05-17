

//this class creates the player object. i used a complex constructor to create the player, but i have another idea that may work better.
//i also used getters and setters for this class & the treasure class. i still don't quite know when to use private variables + getters/setters and just use public variables
//currently i make all member variables private until they become annoying to deal with.
//for example, the Treasure object "heldItem", has its own member functions, it's much easier to make this member public so i can use the member functions. i think this is fine because in the Treasure class,
//those variables are private.

public class Player{
    private String name;
    private int power, fortitude, speed, score;
    public Treasure heldItem;

    void setName(String name) {
        this.name = name;
    }

    void setPower(int power){
        this.power = (power + heldItem.getPower());
    }

    void setSpeed(int speed){
        this.speed = (speed + heldItem.getSpeed());
    }

    void setFortitude(int fortitude){
        this.fortitude = (fortitude + heldItem.getFortitude());
    }

    void setStartTreasure(int itemIndex, TreasureBox TreasureBox){
        this.heldItem = TreasureBox.treasure[itemIndex];
    }

    void setTreasure(Treasure treasure){
        this.heldItem = treasure;
    }

    void setScore(int score){
    	this.score = score;
    }

    void addToScore(int score){
    	this.score += score;
    }

    String getName(){return name;}

    int getScore(){ return score + heldItem.getValue();}

    int getPower(){return power;}

    int getSpeed(){return speed;}

    int getFortitude(){return fortitude;}

    Player(TreasureBox TreasureBox, String name, int power, int speed, int fortitude, String item){
        this.setName(name);
        int itemIndex = 0;
        switch(item){
            case "chainmail": itemIndex = 0; break;
            case "cloak": itemIndex = 2; break;
            case "staff": itemIndex = 1; break;
        }
        this.setStartTreasure(itemIndex, TreasureBox);
        this.setPower(10);
        this.setSpeed(10);
        this.setFortitude(10);
        this.setScore(0);
    }
}