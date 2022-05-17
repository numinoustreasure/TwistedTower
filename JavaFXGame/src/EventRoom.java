//this class is testing the usage of public variables and no setters/getters.
//it feels exposed like this.
public class EventRoom{
	private
    String name, description;
    int power, speed, fortitude;
    int score;
    boolean hasItem;
    Treasure reward;
    public
    String getName(){return name;}
    String getDescription(){return description;}

    int getPower(){return power;}
    int getSpeed(){return speed;}
    int getFortitude(){return fortitude;}
    int getScore(){return score;}
    Treasure getReward(){return reward;}

    EventRoom(String name, String description, int power, int speed, int fortitude, int score, boolean hasItem, Treasure reward){
        this.name = name;
        this.description = description;
        this.power = power;
        this.speed = speed;
        this.fortitude = fortitude;
        this.score = score;
        this.hasItem = hasItem;
        this.reward = reward;
    }
    boolean skillCheck(String type, Player player){
        if (type == "power"){
            if(this.power > player.getPower()){
                return false;
            }
            else if (this.power < player.getPower()){
                return true;
            }
        }

        else if (type == "fortitude"){

            if(this.fortitude > player.getFortitude()){
                return false;
            }
            else if (this.fortitude < player.getFortitude()){
                return true;
            }
        }

        else if (type == "speed"){
                if(this.speed > player.getSpeed()){
                    return false;
                }
                else if(this.speed < player.getSpeed()){
                    return true;
                }

            }
        return true;

    }

}