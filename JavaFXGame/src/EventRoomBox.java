import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
//this class creates a room with a random item, and lets us know whether that room actually contains the item, almost identical functionality to the treasurebox class
//hint: every room creates a Treasure
//but every room does NOT give the treasure to the player :)
public class EventRoomBox{
    int randomNum = ThreadLocalRandom.current().nextInt(0, 8 + 1);
    int randomNum2 = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    Random random = new Random();
    EventRoom[] EventRoom = new EventRoom[16];
    EventRoomBox(TreasureBox TreasureBox){

        EventRoom[0] = new EventRoom("Darker Dungeon", "You find yourself in a dark, cold room. The sound of dripping fills your ears, and cold metal rests against your wrist. You are chained to the wall.", 10, 15, 15, 20, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[1] = new EventRoom("Peaceful Glade", "You immediately shield your eyes as you enter. From darkness, to brightly lit grasslands. You find a comfortable camp, a chest that is obviously filled, and a lone door standing in front of you. There is no danger here adventurer, gather your spirits.", 0, 0, 0, 100, true, TreasureBox.treasure[randomNum]);

        EventRoom[2] = new EventRoom("Alchemical Testing Chamber", "A noxious fog hangs in the air here. Around you lie broken glass and splatters of bright green liquid stain the ground. In front of you is a an aged wooden door with a timer, and the first second just ticked.", 13, 20, 15, 60, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[3] = new EventRoom("Grand Arena", "A roar fills your ears, and as you look around, you realize that you are in a vast collisseum, and that roaring is the crowd filling the stands."
        		+ "Facing you now is a being that can only be described as a champion. Covered in gleaming silver and gilded armor, this foe will not fall easily.", 20, 30, 20, 1000, true, TreasureBox.treasure[randomNum]);

        EventRoom[4] = new EventRoom("Royal Bedchamber", "A soft padding makes its way underneath you as you fall through the door. You find yourself on a bed so large that it defies belief, and you hear a shrill scream from what you can only assume are the giant occupants of this bed. You have no choice, run.", 30, 15, 20, 100, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[5] = new EventRoom("Compression Hall", "You hear a grinding noise from above. As you look up, you see the cieilng closing in on you. Ahead of you lies the door, can you make it?", 20, 13, 16, 60, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[6] = new EventRoom("Spike Al-lee", "As you step through the door, you hear a quick sharp noise. Large needle like spikes pierce up through the floor directly ahead of you. You can see the door just down the hall, good luck adventurer.", 20, 13, 18, 200, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[7] = new EventRoom("Void", "Cold. The sensation hits you like a blacksmith's hammer. A vast emtpiness surrounds you, except for the door floating in front of you. Can you survive the biting cold?", 15, 30, 13, 250, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[8] = new EventRoom("Dojo of the Burning Fist", "A calmness settles over you as you step into a well craft temple, befit for a master.Speaking of master, there he stands. His presence overwhelming.Defeat the Master of the Burning Fist.", 20, 20, 20, 1200, true, TreasureBox.treasure[randomNum]);

        EventRoom[9] = new EventRoom("Temple of the Cyber God", "Your conciousness returns to you, but all you can see are numbers. You are surrounded by an endless number of 1's and 0's. Escape.", 16, 13, 15, 100, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[10] = new EventRoom("Librarian's Punishment Chamber", "Oh, now you've done it. You made too much noise going through that door, and you've made her mad. "
        		+ "You won't like her when she's angry, she turns into a giant poison spewing hydra. Good luck.", 26, 18, 20, 25, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[11] = new EventRoom("Mad Circus", "Clowns. You hate clowns, and you've just realized the door you came from was actually a very small car that opened into an endless sea of clowns. Can you cross the ocean of clowns and make it to the door?", 20, 26, 18, 300, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[12] = new EventRoom("Great Falls", "The roar of water reaches your ears as you exit through the door. Getting your bearings, you notice that you are heading toward a precarious drop. Can you survive the fall?", 26, 26, 20, 500, random.nextBoolean(), TreasureBox.treasure[randomNum]);

        EventRoom[13] = new EventRoom("Power Testing Chamber", "Exiting the door, you find yourself face to face with a punching bag. The bag has a mechanism that leads to a chest and the door nearby, it looks full.", 10, 30, 30, 50, true, TreasureBox.treasure[randomNum]);

        EventRoom[14] = new EventRoom("Speed Testing Track", "You find yourself on a track with 4 others, with artifacts of strange power, you hear a referee whistle. On your marks, get set, go! Can you beat the other competitors and win a prize or will this be the end for you?", 30, 10, 30, 50, true, TreasureBox.treasure[randomNum]);

        EventRoom[15] = new EventRoom("Fortitude Testing Site", "A wave of nausea hits you as you exit the door into a large crater. Surrounding the crater are impossibly high fences, and only now did you notice the barrels surrounding you, each one oozing a different color of glowing liquid. Can you last long enough for the exit to appear?", 30, 30, 10, 50, true, TreasureBox.treasure[randomNum]);


    }
    public EventRoom randomRoom(){
    	randomNum2 = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    	return EventRoom[randomNum2];
    }
}