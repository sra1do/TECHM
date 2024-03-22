//Map
package Data;
import java.util.*;
public class Test10 {

	public static void main(String[] args) {
		//creating a map of id and name
		//table of entires -id and name
		Map<Integer,String> oldtable=new HashMap<Integer,String>();
		Map<Integer,String> table=new HashMap<Integer,String>();
			oldtable.put(101,"sunny");
			oldtable.put(101,"sunny");
			oldtable.put(101,"sunny");
			oldtable.put(101,"sunny");
			oldtable.put(101,"sunny");
			//displaying entries
			for(Map.Entry<Integer, String> e:oldtable.entrySet()) {
				System.out.println(e.getKey()+"->"+e.getValue());
			}
			table.putAll(oldtable);
		    table.put(102, "ronny");
		    table.putIfAbsent(103, "jonny");
		    table.putIfAbsent(102, "money");
		  //displaying entries
		  //insertion order is not preserved
			for(Map.Entry<Integer, String> e:table.entrySet()) {
				System.out.println(e.getKey()+"->"+e.getValue());
			}
		//displaying all keys
			//keys are stored in the form of set
			Set<Integer> keys=table.keySet();
			System.out.println("available Keys are :" +keys);
			///displaying all the values
			Collection<String> values=table.values();
			System.out.println("available values are :" +values);
			//finding a value for a key
			String v=table.get(101);
			System.out.println("Value for 101 is :"+v);
			v=table.getOrDefault(108,"Tonny");
			System.out.println("value for 108 is : "+v);
			//removeing the values
			table.remove(108);
			keys=table.keySet();
			//orser is not preserved
			System.out.println("available Keys are :" +keys);
			table.replace(101,"Kumar");
			v=table.get(101);
			System.out.println("Value for 101 is "+v);
			table.compute("Name", (key,val)
					-> val.concat("singh"));
			v=table.get(101);
			System.out.println("Value for 101 is "+v);
			table.computeIfPresent(102,(key,value)
					->value.concat("Sahoo"));
	}

}
