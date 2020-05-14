package model;

public class LinkedList {

	private long time;
	private int progress;
	
	private NodeLinkedList first;

	public LinkedList() {

	}

	public LinkedList(long time, int progress) {
		this.time = time;
		this.progress = progress;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}


	public NodeLinkedList getFirst() {
		return first;
	}

	public void setFirst(NodeLinkedList first) {
		this.first = first;
	}

	public void add(NodeLinkedList nodeLinkedList) {
		NodeLinkedList node = nodeLinkedList;
		if (first == null) {
			first = node;
		} else {
			NodeLinkedList aux = first;
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			node.setPrevious(aux);
			aux.setNext(node);
		}
	}

	public void addRecursive(long data) {
		if (first == null) {
			first = new NodeLinkedList(data);
		} else {
			addRec(first, data);
		}
	}

	public void addRec(NodeLinkedList aux, long data) {
		try {
			if (aux.getNext() != null) {
				addRec(aux.getNext(), data);
			} else {
				NodeLinkedList node = new NodeLinkedList(data);
				aux.setNext(node);
				node.setPrevious(aux);
			}
		} catch (StackOverflowError e) {

		}
	}

	public boolean delete(long num) {
		boolean deleted = false;
		NodeLinkedList aux = first;
		if (aux != null) {
			while (!deleted && aux.getNext() != null) {
				if (aux.getNum() == num) {
					if (aux.getPrevious() != null && aux.getNext() != null) {
						aux.getPrevious().setNext(aux.getNext());
						aux.getNext().setPrevious(aux.getPrevious());
					}
					deleted = true;
				}
				aux = aux.getNext();
			}
		}
		return deleted;
	}

	public boolean deleteRec(NodeLinkedList node, long num) {
		boolean deleted = false;
		try {
			if (node == null) {
				deleted = false;
				return false;
			}
			if (node.getNum() == num) {
				if (node.getNext() != null && node.getPrevious() != null) {
					node.getPrevious().setNext(node.getNext());
					node.getNext().setPrevious(node.getPrevious());
				}
				deleted = true;
				return true;
			}
			return deleteRec(node.getNext(), num);
		} catch (StackOverflowError e) {

		}
		return deleted;
	}

	public boolean search(long num) {
		boolean found = false;
		NodeLinkedList aux = first;
		if (aux != null) {
			while (!found && aux.getNext() != null) {
				if (aux.getNum() == num) {
					found = true;
				}
				aux = aux.getNext();
			}
		}
		return found;
	}

	public boolean searchRec(NodeLinkedList node, long num) {
		boolean found = false;
		try {
			if (node == null) {
				found = false;
				return false;
			}
			if (node.getNum() == num) {
				found = true;
				return true;
			}
			return searchRec(node.getNext(), num);
		} catch (Exception e) {

		}
		return found;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

}
