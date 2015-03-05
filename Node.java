import java.util.ArrayList;
public class Node{

	private int myValue;
	private ArrayList<Node> successors = null;
	private Node left, right;

	public Node (int myValue, Node left, Node right){
		this.myValue = myValue;
		this.left = left;
		this.right = right;
	}

	public Node(int myValue){
		this.myValue = myValue;
		left = right = null;
	}

	public ArrayList<Node> getSuccessors(){
		successors = new ArrayList<Node>();
		if(left != null)
			successors.add(left);
		if(right != null)
			successors.add(right);
		return successors;
	}

	public int getValue(){
		return myValue;
	}

	public Node getLeft(){
		return left;
	}

	public Node getRight(){
		return right;
	}

	public void printValue(){
		System.out.println(myValue);
	}
}