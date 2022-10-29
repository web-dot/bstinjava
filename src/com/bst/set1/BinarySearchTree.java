package com.bst.set1;

/*
 * Java program to demonstrate insert operation in binary search tree 
 * */
public class BinarySearchTree {
	
	/*
	 * Class containing left and right child of current node and key value.
	 * */
	class Node{
		int key;
		Node left, right;
		
		public Node(int item) {
			this.key = item;
			left = right = null;
		}
	}
	
	//Root of BST
	Node root;
	
	//Constructor
	public BinarySearchTree() {
		this.root = null;
	}
	
	public BinarySearchTree(int value) {
		this.root = new Node(value);
	}
	
	//this method mainly calls insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}
	
	/*a recursive function to insert a new key in bst*/
	Node insertRec(Node root, int key) {
		
		/*if the tree is empty return a new node*/
		if(root == null) {
			root = new Node(key);
			return root;
		}
		
		/*Otherwise recur down the tree*/
		else if(key < root.key)
			root.left = insertRec(root.left, key);
		else if(key > root.key)
			root.right = insertRec(root.right, key);
		
		/*return the (unchanged) node pointer*/
		return root;
	}
	
	/*this method mainly calls inorderRec()*/
	void inorder() {
		inorderRec(root);
	}
	
	
	void inorderRec(Node root) {
		if(root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		
		/* Let us create following BST
		        50
		     /     \
		    30      70
		   /  \    /  \
		 20   40  60   80 */
		
		
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		tree.inorder();
	}
	
}
