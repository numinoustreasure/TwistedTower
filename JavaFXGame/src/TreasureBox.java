//i created a class to create a static array of treasures used in the game, these will NEVER be modified during runtime.
//i wasn't sure if there was a better way to do this, but it seems to work quite well and it makes my main program cleaner


public class TreasureBox{
    final Treasure[] treasure = new Treasure[9];
    TreasureBox(){

        treasure[0] = new Treasure("Aspiring Squire's Chainmail",
        "An aging chainmail wrought from red iron found locally... Actually, that's just rust. You still feel confidence in its heft, +3FTD.",
        0, 0, 3, 10);

        treasure[1] = new Treasure("Fledgling Adept's Staff",
        "A staf that tingles against your fingers, you just know you could start a fire with this. You feel more powerful while wielding it, +3POW.",
        3, 0, 0, 10);

        treasure[2] = new Treasure("Delinquent's Cloak",
        "A cloak pieced together from patchwork leather that smells of old rat. You feel lighter while wearing this, +3SPD.",
        0, 3, 0, 10);

        treasure[3] = new Treasure("Master's Gloves",
        "These gloves radiate the burning power of fire, and just wearing them ehances your physique enough to take on the strongest of foes.+12POW/+6SPD/+6FTD",
        12, 6, 6, 500);

        treasure[4] = new Treasure("Knight's Heraldric Shield",
        "A towering shield of incomprehensible weight. You could stop the breath of two dragons at the same time with this. +4POW/-2SPD/+16FTD",
        4, (-2), 16, 500);

        treasure[5] = new Treasure("Norman's Favorite Lute",
        "Ah, a well worn lute made of the finest enchanted mahogany. You don't know how to play this, you did learn that strumming it makes you lighter. +2POW/+8SPD/+0FTD",
        0, 3, 0, 60);
        treasure[6] = new Treasure("Robin's Hood",
        "This really seems like a regular cloth hood, but you could've swore that the arrows you fire swerve to hit their target. +6POW/+2SPD/+0FTD",
        6, 2, 0, 120);

        treasure[7] = new Treasure("Shard of the Void Dragon",
        "This universe was created for you to stomp under your heel. Power fills you til the cup floweth over. All weakness except hubris has been purged from your body. +20POW/+20SPD/+20FTD",
        20, 20, 20, 4000);

        treasure[8] = new Treasure("Sword of All Jacks",
        "You aren't the greatest swordsman, but it really feels like just wearing this sword makes you a little bit better at everything. +4POW/+4SPD/+4FTD",
        4, 4, 4, 150);

    }
}

