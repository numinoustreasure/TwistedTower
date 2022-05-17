
import java.io.*;

public class Mapper{


	static void toFile(Player player) throws IOException{
	  Writer output = null;
	  File file = new File("HiScore.txt");
	  output = new BufferedWriter(new FileWriter(file, true));
	  output.write("\n"+Integer.toString(player.getScore())+" "+player.getName());
	  output.close();
  }
}