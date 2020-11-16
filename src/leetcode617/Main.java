package leetcode617;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {
	public static void main(String[] args) {
		MergeTwoBinaryTree tree = new MergeTwoBinaryTree();
		MergeTwoBinaryTree tree2 = new MergeTwoBinaryTree();
		
		int[] input = {1,2,3,4,5,6};
		int[] input2 = {1,2,3,4,5,6};
		
		System.out.println("tree 1: " + Arrays.toString(input));
		
		System.out.println("tree 2: " + Arrays.toString(input));
		
		tree.addTreeNode(input);
		tree2.addTreeNode(input2);
		
		TreeNode treeFinal = tree.mergeTrees(tree.root, tree2.root);
		
		System.out.println(levelOrder1(treeFinal));
	}
	
	// Recursive without queue
	public static List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		
		bfs(result, root, 0);
		
		return result;
	}
	
	public static void bfs(List<List<Integer>> result, TreeNode root, int height){
		// If we reach to the null children
		if(root == null){
			// Do nothing
			return;
		}
		
		// We will only create space of the proper level, won't create extra
		if(height == result.size()){
			result.add(new ArrayList<Integer>());
		}
		
		// get.(height) will get the level of index, then add the node
		result.get(height).add(root.val);
		
		// Get the left children first, increase the height by 1 every time
		bfs(result, root.left, height + 1);
		
		bfs(result, root.right, height + 1);
		
	}
	
}
