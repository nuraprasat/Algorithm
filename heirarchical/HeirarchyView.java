package alg.heirarchical;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HeirarchyView {
	static Node root;
	static Map<Integer, Node> valueMap = new LinkedHashMap<>();
	
	public void heirarchyView(List<Node> nodeList) {
		createMap(nodeList);
		buildHierarchyTree(root);
		printHierarchyTree(0, root);
	}

	public static void  createMap(List<Node> valueList) {
		for (Node value : valueList) {
			
			if (root == null) {
				root = value;
			} 
			
			valueMap.put(value.category, value);
		}
	}
	
	private static List<Node> getChildNode(int category) {
		List<Node> childNode = new ArrayList<>();
		for(Node n : valueMap.values()) {
			if(category == n.getParentId()) {
				childNode.add(n);
			}
		}
		return childNode;
	}
	
	public static void buildHierarchyTree(Node root) {
		Node current = root;
		
		List<Node> childList = getChildNode(current.category);
		current.setChild(childList);
		if(childList.isEmpty())
			return;
		for(Node n : childList) {
			buildHierarchyTree(n);
		}
	}
	
	public static void printHierarchyTree(int level, Node root) {
		for(int i=0;i<level;i++) {
			System.out.print("\t");
		}
		
		System.out.println("-"+root.name);
		List<Node> childList = root.getChild();
		
		for(Node n : childList) {
			printHierarchyTree(level+1, n);
		}
	}
	
} 
