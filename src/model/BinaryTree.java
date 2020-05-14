package model;

public class BinaryTree {

	private long time;
	private int progress;

	private NodeTree root;

	public BinaryTree() {

	}

	public BinaryTree(long time, int progress) {
		this.time = time;
		this.progress = progress;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public NodeTree getRoot() {
		return root;
	}

	public void setRoot(NodeTree root) {
		this.root = root;
	}

	public void add(NodeTree node) {
		NodeTree nodeAdd = node;
		if (root == null) {
			root = nodeAdd;
		} else {
			NodeTree aux = root;
			boolean added = false;
			while (!added) {

				if (nodeAdd.getNum() > aux.getNum()) {
					if (aux.getRight() == null) {
						aux.setRight(nodeAdd);
						added = true;
					} else {
						aux = aux.getRight();
					}
				} else {
					if (aux.getLeft() == null) {
						aux.setLeft(nodeAdd);
						added = true;
					} else {
						aux = aux.getLeft();
					}
				}
			}
		}
	}

	public void addRec(NodeTree node, long num) {
		try {
			if (node == null) {
				root = new NodeTree(num);
			} else {
				if (num < node.getNum()) {
					if (node.getLeft() != null) {
						addRec(node.getLeft(), num);
					} else {
						NodeTree n = new NodeTree(num);
						node.setLeft(n);
					}
				} else if (num > node.getNum()) {
					if (node.getRight() != null) {
						addRec(node.getRight(), num);
					} else {
						NodeTree n = new NodeTree(num);
						node.setRight(n);
					}
				}
			}
		} catch (StackOverflowError e) {

		}
	}

	public void delete(long data) {
		root = deleteNode(root, data);
	}

	public NodeTree deleteNode(NodeTree aux, long data) {

		if (aux == null) {
			// no se encontro el nodo
		} else if (data > aux.getNum()) {
			NodeTree der = deleteNode(aux.getRight(), data);
			aux.setRight(der);
		} else if (data < aux.getNum()) {
			NodeTree iz = deleteNode(aux.getLeft(), data);
			aux.setLeft(iz);
		} else {
			NodeTree p = aux;

			if (p.getRight() == null) {
				aux = p.getLeft();
			} else if (p.getLeft() == null) {
				aux = p.getRight();
			} else {
				p = cambiar(p);
			}
			p = null;
		}
		return aux;
	}

	public void deleteKey(long data) {
		root = deleteRec(root, data);
	}

	// borrar recursivo

	public NodeTree deleteRec(NodeTree aux, long data) {

		if (aux == null)
			return aux;

		if (data < aux.getNum())
			aux.setLeft(deleteRec(aux.getLeft(), data));
		else if (data > aux.getNum())
			aux.setRight(deleteRec(aux.getRight(), data));

		else {

			if (aux.getLeft() == null)
				return aux.getRight();
			else if (aux.getRight() == null)
				return aux.getLeft();

			aux.setNum(minValue(root.getRight()));

			aux.setRight(deleteRec(aux.getRight(), aux.getNum()));
		}

		return root;
	}

	long minValue(NodeTree aux) {
		long minv = aux.getNum();
		while (aux.getLeft() != null) {
			minv = aux.getLeft().getNum();
			aux = aux.getLeft();
		}
		return minv;
	}

	// buscar

	public boolean search(long num) {
		boolean search = false;
		NodeTree aux = root;
		boolean keep = true;
		if (root != null) {
			while (aux != null && keep) {
				if (aux.getNum() == num) {
					search = true;
					keep = false;
				} else if (aux.getNum() <= num) {
					aux = aux.getLeft();
				} else if (aux.getNum() >= num) {
					aux = aux.getRight();
				}
			}
		}
		return search;
	}

// buscar recursivo
	public boolean searchRec(NodeTree node, long num) {

		if (node == null)
			return false;
		if (node.getNum() == num)
			return true;
		if (num < node.getNum())
			return searchRec(node.getLeft(), num);
		else if (num > node.getNum())
			return searchRec(node.getRight(), num);

		return false;
	}

	public NodeTree cambiar(NodeTree aux) {
		NodeTree p = aux;
		NodeTree a = aux.getLeft();
		while (a.getRight() != null) {
			p = a;
			a = a.getRight();
		}
		aux.setNum(a.getNum());
		if (p == aux) {
			p.setLeft(a.getLeft());
		} else {
			p.setRight(a.getLeft());
		}
		return a;
	}

}
