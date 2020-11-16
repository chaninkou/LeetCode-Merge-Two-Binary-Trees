package leetcode617;


public class MergeTwoBinaryTree {
	TreeNode root;
	
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        } else if (t1 == null){
            return t2;            
        } else if (t2 == null){
            return t1;
        }
        
        TreeNode node = new TreeNode(t1.val + t2.val);
        
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        
        return node;
    }
    
	public void addTreeNode(int[] values) {
		TreeNode nodeToAdd;
		
		for(int value : values){
			nodeToAdd= new TreeNode(value);
			
			if(root == null){
				root = nodeToAdd;
			}
			
			traverseAndAddNode(root, nodeToAdd);
		}

	}
	
	public void traverseAndAddNode(TreeNode root, TreeNode nodeToAdd){		
		if(nodeToAdd.val < root.val){
			if(root.left == null){
				root.left = nodeToAdd;
			} else {
				traverseAndAddNode(root.left,nodeToAdd);
			}
		} else if (nodeToAdd.val > root.val){
			if(root.right == null){
				root.right = nodeToAdd;
			} else {
				traverseAndAddNode(root.right, nodeToAdd);
			}
		}
	}
}
