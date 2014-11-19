public class WordGrid{

    private char[][]data;
    private int rows;
    private int cols;

    public WordGrid(int rows, int cols){
	data = new char[rows][cols];
	this.rows = rows;
	this.cols = cols;
    }

    private void clear(){
	int placeR = 0;
	int placeC = 0;
	while (placeR < rows){
	    while (placeC < cols){
		data[placeR][placeC] = " ";
		placeC += 1;
	    }
	    placeR += 1;
	}
    }