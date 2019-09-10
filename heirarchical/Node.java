package alg.heirarchical;

import java.util.List;

public class Node {
	
	List<Node> child;
	public int category;
	public String name;
	public int parentId;
	
	
	public Node(int category, String name, int parent) {
		this.category = category;
		this.name = name;
		this.parentId = parent;
	}


	public List<Node> getChild() {
		return child;
	}


	public void setChild(List<Node> child) {
		this.child = child;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}
