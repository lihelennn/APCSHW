import java.util.*;

public class ArrayListMethods{

    public static void collapseDuplicates(ArrayList<Integer> L){
	int place = 1;
	while (place < L.size()){
	    if (L.get(place) == L.get(place - 1)){
		L.remove(place);
	    }else{
		place += 1;
	    }
	}
    }

    public static void randomize(ArrayList<Integer> L){
	int place = 0;
	Random randPlace = new Random();
	while (place < L.size()){
	    L.add(L.remove(randPlace.nextInt(L.size())));
	    place += 1;
	}
    }

 
    public static void main (String[]args){
	ArrayList<Integer>data = new ArrayList <Integer> ();
	data.add(new Integer(9));
	data.add(1);
	data.add(9);
	data.add(3);
	data.add(3);
	data.add(4);
	data.add(2);
	data.add(2);
	data.add(2);
	data.add(7);
	data.add(8);
	data.add(8);
	data.add(8);
	data.add(8);
	data.add(9);
	collapseDuplicates(data);
	System.out.println(data);
	randomize(data);
	System.out.println(data);
	randomize(data);
	System.out.println(data);
    }
}
