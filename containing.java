public class containing{

    public static boolean contains(int value, int []c){
	int place = 0;
	while (place < c.length){
	    if (c[place] == value){
		return true;
	    }
	    place += 1;
	}
	return false;
    }

    public static boolean contains(int value, int [][]c){
	int place = 0;
	while (place < c.length){
	    if (contains(value, c[place])){
		return true;
	    }else{
		place += 1;
	    }
	}
	return false;
    }


    public static void main(String[]args){
	int[][]data = new int[][]{
	    {1, 2, 3, 4},
	    {5, 6, 7, 8},
	};
	System.out.println(contains(2, data)); // true
	System.out.println(contains(10, data)); // false
	System.out.println(contains(0, data)); // false
	System.out.println(contains('a', data)); // false
    }
}





