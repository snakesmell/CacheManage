import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Test1 {

	
	
	public static void main(String[] args) {
		
		Map map = new HashMap();
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		map.put("a", list);
		map.put("b", list);
		
		Set set = map.keySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			System.out.println(list.size());
		}
	}
}
