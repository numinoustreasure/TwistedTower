public class Treasure {
    private String name, description;
    private int power, speed, fortitude, value;
    void setName(String name) {
        this.name = name;
    }
    void setDescription(String description){
        this.description = description;
    }
    void setPower(int power){
        this.power = power;
    }
    void setSpeed(int speed){
        this.speed = speed;
    }
    void setFortitude(int fortitude){
        this.fortitude = fortitude;
    }
    void setValue(int value){
    	this.value = value;
    }
    String getName(){return name;}

    String getDescription(){return description;}

    int getValue(){return value;}
    int getPower(){return power;}
    int getSpeed(){return speed;}
    int getFortitude(){return fortitude;}
    Treasure(String name, String description, int power, int speed, int fortitude, int value){
        this.setName(name);
        this.setDescription(description);
        this.setPower(power);
        this.setSpeed(speed);
        this.setFortitude(fortitude);
        this.setValue(value);
    }
}