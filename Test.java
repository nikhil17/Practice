import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Test{
	
	public static void main (String[]args){
		// HashSet<Integer> numbers = new HashSet<Integer>();

		// numbers.add(6);
		// numbers.add(10);
		// numbers.add(11);
		// numbers.add(5);
		// numbers.add(12);
		// numbers.add(99);

		// Iterator i = numbers.iterator();

		// while(i.hasNext()){
		// 	System.out.println(i.next());
		// }

		Node leaf1 = new Node(4);
		Node leaf2 = new Node(5);
		Node l1 = new Node(10, leaf1, leaf2);

		Node leaf3 = new Node(99);
		Node leaf4 = new Node(2);
		Node l2 = new Node(101, leaf3, leaf4);

		Node parent = new Node(777, l1, l2);

		System.out.println();
		System.out.println("Inorder traversal");
		inOrder(parent);

		System.out.println();
		System.out.println("Preorder traversal");
		preOrder(parent);

		System.out.println();
		System.out.println("postorder traversal");
		postOrder(parent);

		System.out.println();

		Node n = dfs(parent, 5);
		System.out.println();
		System.out.println("BFS");
		n = bfs (parent, 2);
	}

	public static void inOrder(Node root){
		if(root.getLeft() != null)
			inOrder(root.getLeft());

		root.printValue();

		if(root.getRight()!= null){
			inOrder(root.getRight());
		}
	}

	public static void preOrder(Node root){

		root.printValue();

		if(root.getLeft()!= null)
			preOrder(root.getLeft());

		if(root.getRight()!= null)
			preOrder(root.getRight());
	}

	public static void postOrder(Node root){

		if(root.getLeft()!= null)
			preOrder(root.getLeft());

		if(root.getRight()!= null)
			preOrder(root.getRight());

		root.printValue();

	}

	public static Node dfs(Node root, int value){
		HashSet<Node> visited = new HashSet<Node>();
		Stack<Node> stack = new Stack<Node>();
		ArrayList<Node> successors;
		Iterator i;
		Node temp;

		stack.push(root);
		Node current;
		while(stack.peek() != null){
			current = stack.pop();
			if(current.getValue() == value){
				System.out.println("found the node!");
				System.out.println(current.getValue());
				return current;
			}
			if (!visited.contains(current)){
				System.out.println("visited " + current.getValue());
				visited.add(current);
				successors = current.getSuccessors();
				i = successors.iterator();
				while(i.hasNext()){
					temp = (Node)i.next();
					stack.push(temp);
					System.out.println("pushing to stack - "+ temp.getValue());
				}
			}
		}

		return null;
	}

	public static Node bfs(Node root, int value){
		HashSet<Node> visited = new HashSet<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		ArrayList<Node> successors;
		Iterator i;
		Node temp;

		queue.add(root);
		Node current;
		while(queue.peek() != null){
			current = queue.remove();
			if(current.getValue() == value){
				System.out.println("found the node!");
				return current;
			}
			if (!visited.contains(current)){
				System.out.println("visited " + current.getValue());
				visited.add(current);
				successors = current.getSuccessors();
				i = successors.iterator();
				while(i.hasNext()){
					temp = (Node)i.next();
					queue.add(temp);
					System.out.println("pushing to stack - "+ temp.getValue());
				}
			}
		}

		return null;
	}

}