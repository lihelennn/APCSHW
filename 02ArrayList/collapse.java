import java.util.*;

public class collapse{

    public static void collapseDuplicates(ArrayList<Integer>() L){
	int place = 1;
	while (place < L.length){
	    if (L[place] == L[place - 1]){
		L.remove(place);
	    }
	    place += 1;
	}
    }

    public static String toString(ArrayList()<Integer>() L){
	int place = 0;
	String ans = "[ ";
	while (place < L.length){
	    ans += ("" + L[place] + " ");
	    place += 1;
	}
	ans += " ]";
	return ans;
    }


    public static void main (String[]args){
	Object[]data = new Object[10];
	data[0] = 1;
	data[1] = 1;
	data[2] = 2;
	data[3] = 1;
	data[4] = 1;
	data[5] = 2;
	data[6] = 2;
	data[7] = 4;
	data[8] = 4;
	data[9] = 4;
	collapseDuplicates(data);
	System.out.println(toString());
    }
}
