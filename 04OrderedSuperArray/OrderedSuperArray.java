public class OrderedSuperArray extends SuperArray implements Comparable<OrderedSuperArray>{

    String[]data;

    // public String compareTo(String str, String other){
    //	if ((int)(str.charAt(0)) > (int)(other.charAt(0))){
    //	    return str;
    //	}else{
    //	    return other;
    //	}
    //}

    public void add(String element){
	int place = 0;
	String old = "";
	while (place < size()){
	    if (compareTo(get(place) , element).equals(element) && compareTo(element ,get(place + 1)).equals(get(place + 1))){
		old = set(place + 1 , element);
     		while (place < size()){
		    old = set(place + 1, old);
		    place += 1;
		}
	    }
	    place += 1;
	}
    }
	
		


    public void add(int index, String element){
	add(element);
    }
	    
}
