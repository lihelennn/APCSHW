public class demo{

    public static void main(String[]args){


	SuperArray tester = new SuperArray(50);
	int place = 0;
	while (place < tester.size()){
	    tester.add(place);
	    place += 1;
	}
	System.out.println(tester);
	tester.selectionSort();
	System.out.println(tester);
    }
}
