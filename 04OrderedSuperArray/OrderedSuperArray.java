public class OrderedSuperArray extends SuperArray{

    String[]data;

    public void add(String element){
    	System.out.println(element);
    	if (size() == 0){
    	    super.add(element);
    	    System.out.println(this + "first element woohoo!");
    	}else{

    	    int place = size() ;
	    while (place > 0){
    		System.out.println(this);
    		if (element.compareTo(get(place - 1)) >= 0){
    		    System.out.println("yay");
    		    super.add(place, element);
		    place = -1;
		}
    		place -= 1;
    		System.out.println(data);
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
   
    // public void add(String o){
    // 	int index = size();
    // 	System.out.println(data);
    // 	System.out.println(o);
    // 	while( index >0 && get(index-1).compareTo(o) > 0 ){
    // 	    index--;
    // 	}
    // 	super.add(index, o);
    // }

	
		


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



    public static void main(String[]args){
	OrderedSuperArray test1 = new OrderedSuperArray();
	test1.add("bbb");
	test1.add("aaa");
	test1.add("mmm");
	test1.add("hhh");
	test1.add("ccc");
	System.out.println(test1);
    }
	    
}
