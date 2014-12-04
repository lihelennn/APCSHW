import java.util.*;
import java.io.*;

public class Driver{
    public static void main (String[]args) throws FileNotFoundException{
	Random Rseed = new Random();
	int row = 0;
	int col = 0;
	int seed = Rseed.nextInt();
	int AnswerKey = 0;
	int place = 0;
	if (args.length >= 1){
	    row = Integer.parseInt(args[0]);
	    if (args.length >= 2){
		col = Integer.parseInt(args[1]);
		if (args.length >= 3){
		    seed = Integer.parseInt(args[2]);
		    if (args.length == 4){
			AnswerKey = Integer.parseInt(args[3]);
		    }
		}
	    }
	}
	if (row == 0){
	    row = 10; //default;
	}
	if (col == 0){
	    col = 10; //default;
	}
	if (row < 0 || col < 0 || row >= 40 || col >= 40){
	    System.out.println("Your row/col input is either less than 0 or wayyy too large. Or maybe you don't have an input for row/col. Bad Bad Bad!!");
	}
	else{
	    WordGrid test1 = new WordGrid(row, col, seed);
	    test1.setSeed(seed);
	    if (AnswerKey == 1){
		test1.loadWordsFromFiles("words.txt", false);
	    }else{
		test1.loadWordsFromFiles("words.txt", true);
	    }
	    System.out.println("Find these words:\n" + test1.wordsInPuzzle());
	    System.out.println(test1);
	}
    }
}
