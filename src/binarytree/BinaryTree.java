/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

	private Node root;

	public BinaryTree(String rootValue) {
		root = new Node(rootValue);
	}

	public BinaryTree() {
		root = null;
	}
	/*
	 * public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){ root
	 * = new Node(rootValue, left, right); }
	 */

	public void insert(String aData) {
		BinaryTree bTree;
		if (root == null) {
			Node node = new Node(aData);
			root = node;
		} else if (aData.compareTo(root.getData()) <= 0) {
			if (root.left() == null) {
				root.setLeft(new BinaryTree(aData));
			} else {
				bTree = root.left();
				bTree.insert(aData);
			}
		} else {
			if (root.right() == null) {
				root.setRight(new BinaryTree(aData));
			} else {
				bTree = root.right();
				bTree.insert(aData);
			}
		}

	}

	public BinaryTree find(String aData) {
		BinaryTree bTree;
		if (root == null) {
			return null;
		}
		if (aData.compareTo(root.getData()) == 0) {
			bTree = new BinaryTree(root.getData());
			return bTree;
		} else if (aData.compareTo(root.getData()) < 0) {
			bTree = root.left();
			if (bTree == null) {
				return null;
			}
			return bTree.find(aData);
		} else {
			bTree = root.right();
			if (bTree == null) {
				return null;
			}
			return bTree.find(aData);
		}
	}

	public void preOrder() {
		if (root != null) {
			System.out.println(root.getData() + ',');
			if (root.left() != null) // pääseeekö vasemmalle?
				root.left().preOrder();
			if (root.right() != null) // pääseekö oikealle?
				root.right().preOrder();
		}

	}

	public void setLeft(BinaryTree tree) {
		root.setLeft(tree);
	}

	public void setRight(BinaryTree tree) {
		root.setRight(tree);
	}

	public Node findMin() {
		if (root.left() == null) {
			return root;
		}else {
			return root.left().findMin();
		}
	}

	public Node delete(String aData) {
		if (root == null) {
			return null;
		}
		if (find(aData) == null) {
			return null;
		}

		if (aData.compareTo(root.getData()) < 0) {
			root.left().delete(aData);
		} else if (aData.compareTo(root.getData()) > 0) {
			root.right().delete(aData);
		} else {
			if (root.left() == null && root.right() == null) {
				root = null;
			} else if (root.right() == null) {
				root = root.left().root;
			} else if (root.left() == null) {
				root = root.right().root;
			} else {
				Node temp = root;
				Node min = temp.right().findMin();
				root = new Node(min.getData());
				root.setLeft(temp.left());
				root.setRight(temp.right());
				System.out.println(root.right().root);
				System.out.println(root);
				root.right().delete(root.getData());
			}

		}
		// Tarkistetaan jääkö viitteitä tyhiin binääripuihin, koska node mielenkiintoisesti koodattu.
		if (root != null) {
			if (root.left() != null) {
				if (root.left().root == null) {
					root.setLeft(null);
				}
			}
			if (root.right() != null) {
				if (root.right().root == null) {
					root.setRight(null);
				}
			}
		}
		return root;
	}
}
