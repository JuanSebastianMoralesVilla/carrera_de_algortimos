package model;

public class NodeTree {

	private long num;
	
	private NodeTree parent;
	private NodeTree right;
	private NodeTree left;
	
	public NodeTree(long num) {
		this.num = num;
	}
	public NodeTree getParent() {
		return parent;
	}
	public void setParent(NodeTree parent) {
		this.parent = parent;
	}
	public NodeTree getRight() {
		return right;
	}
	public void setRight(NodeTree right) {
		this.right = right;
	}
	public NodeTree getLeft() {
		return left;
	}
	public void setLeft(NodeTree left) {
		this.left = left;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	
}
