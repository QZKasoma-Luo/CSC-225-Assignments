// Name: QingZe Luo
// Student number: V00953873

public class WordFrequencyBST {
	private TreeNode root;
	private int numElements;
	
	public WordFrequencyBST() {
		root = null;
		numElements = 0;
	}

	public int find_frequency(TreeNode T, String word){

		int L_freq = 0;
		int R_freq = 0;

		if(T == null){
			return 0;
		}else if(T.getData().getWord().compareTo(word) == 0){
			return T.getData().getFrequency();
		}
		L_freq = find_frequency(T.left,word);
		if(L_freq != 0){
			return L_freq;
		}
		R_freq = find_frequency(T.right,word);
		if(R_freq != 0){
			return R_freq;
		}
		return 0;
	}
	
	public TreeNode visit_all_node_and_insert(TreeNode T, String word){
		if(T == null){
			Entry element = new Entry(word);
			TreeNode newElement = new TreeNode(element);
			T = newElement;
			numElements++;
			return T;
		}else if(T.compareTo(word) == 0){
			T.addToFrequency();
		}else{
			if(T.compareTo(word) > 0){
				T.left = visit_all_node_and_insert(T.left, word);
			}else if(T.compareTo(word) < 0){
				T.right = visit_all_node_and_insert(T.right, word);
			}
		}
		return T;
	}
	/*
	 * Purpose: Update the BST by handling input word 
	 * Parameters: String word - The new word to handle
	 * Returns: Nothing
	 * Explanation: If there is no entry in the tree 
	 *   representing the word, then the a new entry 
	 *   should be created and placed into the correct 
	 *   location of the BST. Otherwise, the existing
	 *   entry for the word should have its frequency
	 *   value incremented. 
	 */	
	public void handleWord(String word) {
		// TODO: Complete this method
		Entry element = new Entry(word, 1);
		if(numElements == 0){
			TreeNode newElement = new TreeNode(element);
			root = newElement;
			numElements++;
		}else{
			visit_all_node_and_insert(root, word);
		}
	}

	
	
	/*
	 * Purpose: Get the frequency value of the given word
	 * Parameters: String word - the word to find
	 * Returns: int - the word's associated frequency
	 */	
	public int getFrequency(String word) {
		// TODO: Complete this method
		if(root == null){
			return 0;
		}else{
			return find_frequency(root, word);
		}
		// so it compiles
	}

	/****************************************************
	* Helper functions for Insertion and Search testing *
	****************************************************/
	
	public String inOrder() {
		if (root == null) {
			return "empty";
		}
		return "{" + inOrderRecursive(root) + "}";
	}
	
	public String inOrderRecursive(TreeNode cur) {
		String result = "";
		if (cur.left != null) {
			result = inOrderRecursive(cur.left) + ",";
		} 
		result += cur.getData().getWord();
		if (cur.right != null) {
			result += "," + inOrderRecursive(cur.right);
		}
		return result;
	}
	
	public String preOrder() {
		if (root == null) {
			return "empty";
		}
		return "{" + preOrderRecursive(root) + "}";
	}
	
	public String preOrderRecursive(TreeNode cur) {
		String result = cur.getData().getWord();
		if (cur.left != null) {
			result += "," + preOrderRecursive(cur.left);
		} 
		if (cur.right != null) {
			result += "," + preOrderRecursive(cur.right);
		}
		return result;
	}
	
	/****************************************************
	* Helper functions to populate a Heap from this BST *
	****************************************************/
	
	public MaxFrequencyHeap createHeapFromTree() {
		MaxFrequencyHeap maxHeap = new MaxFrequencyHeap(numElements+1);
		addToHeap(maxHeap, root);
		return maxHeap;
	}
	
	public void addToHeap(MaxFrequencyHeap h, TreeNode n) {
		if (n != null) {
			addToHeap(h, n.left);
			h.insert(n.getData());
			addToHeap(h, n.right);
		}
	}		
}