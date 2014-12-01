import java.util.*;
import java.io.*;

public class WordGrid{
    private char[][]data;
    private int rows;
    private int cols;
    public ArrayList<String> wordsPuzzle = new ArrayList<String>();

   
    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	int placeR = 0;
	int placeC = 0;
	data = new char[rows][cols];
	this.rows = rows;
	this.cols = cols;
	while (placeR < rows){
	    while (placeC < cols){
		data[placeR][placeC] = '_';
		placeC += 1;
	    }
	    placeR += 1;
	    placeC = 0;
	}
    }


    private int getRows(){
	return rows;
    }

    private int getCols(){
	return cols;
    }


    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	int placeR = 0;
	int placeC = 0;
	while (placeR < rows){
	    while (placeC < cols){
		data[placeR][placeC] = ' ';
		placeC += 1;
	    }
	    placeR += 1;
	    placeC = 0;
	}
    }
    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	int placeR = 0;
	int placeC = 0;
	String str = "";
	while (placeR < rows){
	    while (placeC < cols){
		str += data[placeR][placeC] + " ";
		placeC += 1;
	    }
	    placeR += 1;
	    str += "\n";
	    placeC = 0;
	}
	return str;
    }


  

    public boolean checkWord(String word, int row, int col, int dy, int dx){
	if (dy == 0 && dx == 0){
	    return false;
	}else{
	    if (row < 0 || col < 0){
		return false;
	    }else{
		if (col + (dx * word.length()) < 0 || col + (dx * word.length()) >= cols || row + (dy * word.length()) < 0 || row + (dy * word.length()) >= rows){
		    return false;
		}else{
		    return true;
		}
	    }
	}
    }

    public boolean addWord(String word, int row, int col, int dy, int dx){
	int place = 0;
	int origRow = row;
	int origCol = col;
	if (checkWord(word, row, col, dy, dx) == true){
	    while (place < word.length()){
		if (data[row][col] == word.charAt(place) || data[row][col] == '_'){
		    place = 0;
		    while (col < cols && row < rows && place < word.length()){
			if (data[row][col] == word.charAt(place) || data[row][col] == '_'){
			    place += 1;
			    row += dy;
			    col += dx;
			}else{
			    return false;
			}
		    }
		    place = 0 ;
		    row = origRow;
		    col = origCol;
		    while (col < cols && row < rows && place < word.length()){
			data[row][col] = word.charAt(place);
			place += 1;
			row += dy;
			col += dx;
		    }
		    wordsPuzzle.add(word);
		    return true;
		}
		place += 1;
	    }
	}
	return false;
    }
    
    public void fillUp(){
	int placeRow = 0;
	int placeCol = 0;
	Random rand = new Random();
	while (placeRow < rows){
	    while (placeCol < cols){
		int chara = rand.nextInt(26);
		if (data[placeRow][placeCol] == '_' || data[placeRow][placeCol] == ' '){
		    data[placeRow][placeCol] = (char)('a' + chara);
		}
		placeCol += 1;
	    }
	    placeCol = 0;
	    placeRow += 1;
	}
    }






    public void loadWordsFromFiles(String fileName, boolean fillRandomLetters) throws FileNotFoundException{
	try{
	    ArrayList<String> wordList = new ArrayList<String>();
	    Random r1 = new Random();
	    Random c1 = new Random();
	    Random d1 = new Random();
	    Random dy2 = new Random();
	    Random dx2 = new Random();
	    int count = 0;
	    File text = new File(fileName);
	    Scanner sc = new Scanner(text);
	    while (sc.hasNextLine()){
		wordList.add(sc.nextLine());
	    }
	    int place = 0;
	    while (place < wordList.size()){
		boolean goOn = false;
		String line = wordList.get(place);	
		count = 0;
		while (goOn == false && count < 5){
		    if (addWord(line , r1.nextInt(getRows()) , c1.nextInt(getCols()) , dy2.nextInt(3) - 1 , dx2.nextInt(3) - 1) == false){
			count += 1;
		    }else{
			goOn = true;
		    }
		}
		count = 0;
		place += 1;
	    }
	    if (fillRandomLetters == true){
		fillUp();
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File cannot be found...");
	}
    }

    public String wordsInPuzzle(){
	int place = 0;
	String wordss = "";
	int countPerRow = 0;
	while (place < wordsPuzzle.size()){
	    while (place < wordsPuzzle.size() && countPerRow < 3){
		wordss += wordsPuzzle.get(place) + "\t\t";
		place += 1;
		countPerRow += 1;
	    }
	    countPerRow = 0;
	    wordss += "\n";
	}
	return wordss;
    }


	












	  


    public static void main (String[]args) throws FileNotFoundException{
	Random seed = new Random();
	int row = 0;
	int col = 0;
	int RandomSeed = seed.nextInt();
	int AnswerKey = 0;
	int place = 0;
	Random rng = new Random();
	if (args.length > 0){
	    row = Integer.parseInt(args[0]);
	    col = Integer.parseInt(args[1]);
	    if (args.length >= 3){
		RandomSeed = Integer.parseInt(args[2]);
	    }
	    if (args.length == 4){
		AnswerKey = Integer.parseInt(args[3]);
	    }
	}
	rng.setSeed(RandomSeed);
	WordGrid test1 = new WordGrid(row, col);
	if (AnswerKey == 1){
	    test1.loadWordsFromFiles("words.txt", false);
	    System.out.println(test1);
	}else{
	    test1.loadWordsFromFiles("words.txt", true);
	    System.out.println("Find these words:\n" + test1.wordsInPuzzle());
	    System.out.println(test1);
    
	}
    }
}
