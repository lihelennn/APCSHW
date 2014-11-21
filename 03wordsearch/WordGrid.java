public class WordGrid{
    private char[][]data;
    private int rows;
    private int cols;
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
		data[placeR][placeC] = ' ';
		placeC += 1;
	    }
	    placeR += 1;
	    placeC = 0;
	}
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
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word, int row, int col){
	int place = 0;
	int origCol = col;
	int origCol2 = col;
	if (col + word.length() - 1 > cols){
	    return false;
	}else{
	    while (place < word.length() && col < cols){
		System.out.println(word.charAt(place));
		if (data[row][col] == word.charAt(place) || data[row][col] == ' '){
		    place = 0;
		    while (origCol < cols && place < word.length()){
			if (data[row][origCol] == word.charAt(place) || data[row][origCol] == ' '){
			    place += 1;
			    origCol += 1;
			}else{
			    return false;
			}
		    }
		    place = 0 ;
		    origCol = origCol2;
		    while (origCol < cols && place < word.length()){
			data[row][origCol] = word.charAt(place);
			place += 1;
			origCol += 1;
		    }
		    return true;
		}
		
		place += 1;
		col += 1;
	    }
	    return false;
	}
    }
    

    //vertical + diagonal should be implemented as well.




    public boolean addWordVertical(String word, int row, int col){
	int place = 0;
	int origRow = row;
	int origRow2 = row;
	if (row + word.length() - 1 > rows){
	    return false;
	}else{
	    while (place < word.length() && row < rows){
		System.out.println(word.charAt(place));
		if (data[row][col] == word.charAt(place) || data[row][col] == ' '){
		    place = 0;
		    while (origRow < rows && place < word.length()){
			if (data[origRow][col] == word.charAt(place) || data[origRow][col] == ' '){
			    place += 1;
			    origRow += 1;
			}else{
			    return false;
			}
		    }
		    place = 0 ;
		    origRow = origRow2;
		    while (origRow < rows && place < word.length()){
			data[origRow][col] = word.charAt(place);
			place += 1;
			origRow += 1;
		    }
		    return true;
		}
		
		place += 1;
		row += 1;
	    }
	    return false;
	}
    }
    








    public static void main (String[]args){



	WordGrid test1 = new WordGrid(10, 10);
	// this works test1.clear();
	System.out.println(test1);
	System.out.println(test1.addWordHorizontal("happy", 5, 5)); 
	System.out.println(test1.addWordHorizontal("hay", 0, 1)); 
	System.out.println(test1.addWordHorizontal("meet", 1, 1)); 
	System.out.println(test1.addWordHorizontal("hater", 2, 0)); 
	System.out.println(test1.addWordVertical("apcs", 1, 2)); 
	System.out.println(test1.addWordVertical("hello", 0, 0)); 
	System.out.println(test1.addWordVertical("helloooo", 3, 4)); 
	System.out.println(test1.addWordHorizontal("woof", 3, 1)); // expect false; cannot fit;
	System.out.println(test1.addWordHorizontal("woof", 3, 0)); // expect true; should fit
	System.out.println(test1);
    }
}
