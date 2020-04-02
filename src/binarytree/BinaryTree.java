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
		if (aData.compareTo(root.getData()) == 0) {
			bTree = new BinaryTree(root.getData());
			return bTree;
		}else if (aData.compareTo(root.getData()) < 0) {
			bTree = root.left();
			if (bTree == null) {
				return null;
			}
			return bTree.find(aData);
		}else {
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
}
