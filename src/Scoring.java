import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Scoring {
	
	public void writing(int score, String n) throws IOException{
		
		// writing to file 
		
		FileWriter scores = new FileWriter("Scores.txt", true);
		PrintWriter outputFile = new PrintWriter(scores);
		outputFile.print(n + "\n");
		outputFile.print("Score:");
		outputFile.print(score + "\n");
		outputFile.close();
		
	}
	
}
