package otp.tournament_tracker.view.util.tournamentview.bracket_model;

import java.util.ArrayList;
import java.util.Collections;

import otp.tournament_tracker.model.Team;

/*
 * A class representing a binary tree, that is built into a one dimensional array,
 * where child nodes are places at 2i+1 and 2i+2 indexes. Each nodes has knowledge
 * of its right and left descendants plus its parent and depth in the tree.
 */
public class BinaryTree {
	private static BinaryTree instance;
	private ArrayList<Node> storage;

	/*
	 * Binary tree instance constructor that initializes the storage array. Is
	 * called by getTree().
	 */
	private BinaryTree() {
		this.storage = new ArrayList<Node>();
	}

	/*
	 * Add a node to the tree. If there is no root node at index 0, the exception is
	 * caught and a root node is placed. When the root node is placed, the rest of
	 * the nodes will be children to that node and each other. Each left child node
	 * will be stored at index 2i + 1 of a node and right child at index 2i + 2.
	 * 
	 * The depth of a node is a measurement of how many parents a node has. A node
	 * always has parent.getDepth() + 1 of parent nodes.
	 */
	public void add() {
		int i = 0;
		Node parent = null;
		Node toAdd = null;
		while (true) {
			try {
				parent = storage.get(i);
			} catch (IndexOutOfBoundsException e) {
				storage.add(i, new Node(0, null));
				break;
			}
			toAdd = new Node(parent.getDepth() + 1, parent);
			if (parent.left == null) {
				parent.left = toAdd;
				storage.add(2 * i + 1, toAdd);
				break;
			} else if (parent.right == null){
				parent.right = toAdd;
				storage.add(2 * i + 2, toAdd);
				break;
			}	
			i++;
		}
	}

	/*
	 * Add teams to leaf nodes. This is done by reversing the array, adding the
	 * teams to the nodes, and reversing it again.
	 */
	public void addTeam(Team team) {
		Collections.reverse(storage);
		int i = 0;
		while (!this.storage.get(i++).setTeam(team) && i < this.storage.size());
		Collections.reverse(storage);
	}

	/*
	 * Return the BinaryTree instance of this singleton object.
	 */
	public static BinaryTree getTree() {
		if (instance == null) {
			BinaryTree.instance = new BinaryTree();
		}
		return BinaryTree.instance;
	}

	/*
	 * Get the last node in the tree. It will have the highest depth;
	 */
	public Node getLast() {
		return this.storage.get(this.storage.size() - 1);
	}

	/*
	 * Get all nodes in this tree.
	 */
	public ArrayList<Node> getNodes() {
		return this.storage;
	}
}
