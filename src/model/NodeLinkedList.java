package model;

public class NodeLinkedList {

	private long num;
	
	private NodeLinkedList next;
	private NodeLinkedList previous;
	
	public NodeLinkedList(long num) {
		this.num = num;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public NodeLinkedList getNext() {
		return next;
	}
	public void setNext(NodeLinkedList next) {
		this.next = next;
	}
	public NodeLinkedList getPrevious() {
		return previous;
	}
	public void setPrevious(NodeLinkedList previous) {
		this.previous = previous;
	}
}
