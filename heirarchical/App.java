package alg.heirarchical;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Node> al = new ArrayList<>();
		al.add(new Node(1, "electronics", 0));
		al.add(new Node(2, "television", 1));
		al.add(new Node(3, "21 inch", 2));
		al.add(new Node(4, "23 inch", 2));
		al.add(new Node(5,                   "LCD display",          2));
		al.add(new Node(6,                   "player",               1));
		al.add(new Node(7,                   "mp3player",            6));
		al.add(new Node(8,                   "vcd player",           6));
		al.add(new Node(9,                   "dvd player",           6));
		al.add(new Node(10,                  "hd quality",           8));
		
		HeirarchyView hv = new HeirarchyView();
		
		hv.heirarchyView(al);
		
	}

}
