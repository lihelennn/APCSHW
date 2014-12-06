import java.util.*;

public class OrderedSuperArray extends SuperArray{
    String[]data;

    public void add(String element){
    	if (size() == 0){
    	    super.add(element);
    	}else{

    	    int place = size() ;
	    while (place > 0){
    		if (element.compareTo(get(place - 1)) >= 0){
    		    super.add(place, element);
		    place = -1;
		}
    		place -= 1;
    	    }
	    if (place == 0){
		super.add(0, element);
	    }
	}
    }


    public String set(int index, String e){
	String str = remove(index);
	add(e);
	return str;
    }

    public void add(int index, String element){
	add(element);
    }

    public void badInsertionSort(){
	OrderedSuperArray c = new OrderedSuperArray();
	while( this.size() > 0){ 
	    c.add(this.remove(0));
	}
	while(c.size() > 0){
	    this.add(c.remove(0));
	}
    }

    public int find(String target){
	int place = (size() / 2) - 1;
	int ans = -1;
	int toEnd;
	int toStart;
	while (place < size() && place >= 0){
	    toEnd = size() - place - 1;
	    toStart = place; // - 0 (not necessary; used to show)
	    if (target.compareTo(get(place)) == 0){
		ans = place;
	    }
	    if (place == 1){
		if (target.compareTo(get(0)) == 0){
		    ans = 0;
		}
		break;
	    }else{
		if (place == size() - 2){
		    if (target.compareTo(get(place + 1)) == 0){
			ans = place + 1;
		    }
		    break;
		}
	    }
	    if (target.compareTo(get(place)) > 0){
		if (toEnd > toStart){
		    place = place + (toStart / 2);
		}else{
		    place = place + (toEnd / 2);
		}
	    }else{
		if (toEnd > toStart){
		    place = place - (toStart / 2);
		}else{
		    place = place - (toEnd / 2);
		}
	    }
	}
	if (ans == -1){
	    System.out.println("That target does not exist:");
	}
	return ans;
    }


  
   
    public static void main(String[]args){
      	long startTime = System.currentTimeMillis();
	OrderedSuperArray final1 = new OrderedSuperArray();
	Random rand = new Random();
	String tester = "aaa";

	int count = 0;
	while (count < 1000){
	    tester = Character.toString((char)('a' + rand.nextInt(25))) + "aa";
	    final1.add(tester);
	    count += 1;
	}
	final1.badInsertionSort();
	long stopTime = System.currentTimeMillis();
	long elapsedTime = stopTime - startTime;
	System.out.println(final1);
	System.out.println("BadInsertionSort Done. It took : " + elapsedTime + " milliseconds.");


	OrderedSuperArray test1 = new OrderedSuperArray();
	test1.add("bbb");
	test1.add("aaa");
	test1.add("mmm");
	test1.add("hhh");
	test1.add("ccc");
	test1.add("helen");
	test1.set(2, "thiswasoriginallysomething");
	System.out.println(test1);
	//	test1.badInsertionSort();
	//	System.out.println(test1);
	System.out.println(test1.find("bbb")); // expect 1
	System.out.println(test1.find("aaa")); // expect 0
	System.out.println(test1.find("thiswasoriginallysomething")); //expect 5;
	System.out.println(test1.find("ddd")); // expect -1 : does not exist
	System.out.println(test1.find("mmm")); // expect 4	OrderedSuperArray test1 = new OrderedSuperArray();


    }
}
