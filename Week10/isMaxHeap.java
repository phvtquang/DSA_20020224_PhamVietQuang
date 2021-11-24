	

	boolean isHeap(Node tree) {
        return isMax(tree) && isComplete(tree);
    }
    
    
    boolean isMax(Node tree) {
        if (tree == null) return true;
        
        boolean isValid = (
        (tree.left != null && tree.right != null && tree.data > tree.left.data && tree.data > tree.right.data) || 
        (tree.left != null && tree.right == null && tree.data > tree.left.data) ||
        (tree.left == null && tree.right == null)); 
        
        return isValid && isHeap(tree.left) && isHeap(tree.right);
    }
    
    boolean isComplete(Node root) {
        Queue<Node> queue =  new LinkedList();
        queue.add(root);
        Node prev = root;
        
        while (!queue.isEmpty()) {
            Node popped = queue.remove();
            
            if (prev == null && popped != null) {
                return false;
            } 
            if (popped != null) {
                queue.add(popped.left);
                queue.add(popped.right);
            }
            prev = popped;
        }
        
        return true;
    }