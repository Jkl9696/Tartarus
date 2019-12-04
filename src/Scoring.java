import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Scoring {
	
	public void writing(int score) throws IOException{
		
		// writing to file 
		
		FileWriter scores = new FileWriter("Scores.txt", true);
		PrintWriter outputFile = new PrintWriter(scores);
		outputFile.print("Player 1 Score:");
		outputFile.print(score + "\n");
		outputFile.close();
		
	}
	
}
