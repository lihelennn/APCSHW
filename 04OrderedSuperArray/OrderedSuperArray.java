public class OrderedSuperArray extends SuperArray{

    String[]data;

    public void add(String element){
	if (size() == 0){
	    super.add(element);
	}else{
	    int place = 0;
	    String old = "";
	    while (place < this.size()){
		System.out.println(data);
		System.out.println(element.compareTo(get(place)));
		if ((place == 0 && element.compareTo(get(place)) <= 0) || (place != 0 && element.compareTo(get(place - 1)) >= 0 && get(place).compareTo(get(place)) <= 0)){
		    System.out.println("yay");
		    super.add(place, element);
		}
		place += 1;
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

    public static void main(String[]args){
	OrderedSuperArray test1 = new OrderedSuperArray();
	test1.add("bbb");
	test1.add("aaa");
	test1.add("mmm");
	test1.add("hhh");
	System.out.println(test1);
    }
	    
}
