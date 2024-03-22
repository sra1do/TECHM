package Data;
import java.util.*;
public class Test6 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(10);
		list.add(10);
		list.add(7.5);
		list.add("Presidency");
		System.out.println(list);
		for(Object o:list) {
			System.out.println(o);
		}
		ListIterator itr = list.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		list.stream().forEach(x->System.out.println(x));
		list.add(0,100);
		System.out.println(list);
		list.add(2,50);
		System.out.println(list);
		list.contains(50);
		System.out.println(list);
	}

}
