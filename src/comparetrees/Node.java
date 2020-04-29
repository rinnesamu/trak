/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comparetrees;

/**
 *
 * @author kamaj
 */
public class Node {
    private Integer data;
    private BinaryTree left;
    private BinaryTree right;
    private int height;

    public Node(Integer value) {
        data = new Integer(value);
        left = right = null;
        this.height = 0;
    }
    public  Node (Integer value, BinaryTree left, BinaryTree right) {
        data = new Integer(value);
        this.left = left;
        this.right = right;
    }
    public Integer getData() {
        return data;
    }
    public BinaryTree left() {
        return left;
    }
    public BinaryTree right() {
        return right;
    }
    public void setLeft(BinaryTree tree) {
        left = tree;
    }
    public void setRight(BinaryTree tree) {
        right = tree;
    }
    public Node getNode() {
    	return this;
    }
    
    public int getHeight() {
    	return this.height;
    }
    
    public void setHeight(int height) {
    	this.height = height;
    }


}
