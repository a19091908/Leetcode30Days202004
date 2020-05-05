package leetCode30Day;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastRecentlyUsed24 {
	int cumulateOrder;
	int capacity;
	PriorityQueue<Obj> q;
	Map<Integer, Obj> map;

	public static void main(String[] args) {
		LeastRecentlyUsed24 cache = new LeastRecentlyUsed24(2 /* capacity */ );
		
	}

	public LeastRecentlyUsed24(int capacity) {
		this.cumulateOrder = 0;
		this.capacity = capacity;
		this.q = new PriorityQueue<Obj>(new Comparator<Obj>() {
			@Override
			public int compare(Obj o1, Obj o2) {
				return o1.order - o2.order;
			}
		});
		this.map = new HashMap<Integer, Obj>();
	}

	public int get(int key) {
		Obj obj = map.get(key);
		if(obj == null)
			return -1;
		else {
			obj.order = cumulateOrder++;
			q.remove(obj);
			q.add(obj);
			return obj.value;
		}
			
		
	}

	public void put(int key, int value) {
		Obj obj = map.get(key);
		if(obj != null) {
			if(map.get(key).value != value) { 
				obj.value = value;
				obj.order = cumulateOrder++;
				q.remove(obj);
				q.add(obj);
			}
		}else {
			if (map.size() == capacity) {
				obj = q.remove();
				map.remove(obj.key);
			}
			obj = new Obj(cumulateOrder++, key, value);
			map.put(key, obj);
			q.add(obj);
		}
	}

}

class Obj{
	int order;
	int key;
	int value;
	Obj(int order, int key, int value){
		this.order = order;
		this.key = key;
		this.value = value;
	}
}
