class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> output = new ArrayList<>();
        
        if ( root == null)
            return output;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add( root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level= new ArrayList<>();
            
            for( int i = 0; i < size; i++) {
                TreeNode current= queue.poll();
                level.add( current.val);
                
                if( current.left != null)
                    queue.add( current.left);
                    
                if( current.right != null)
                    queue.add( current.right);
            
            }
            
            output.add( level);
        
        
        }
        
        return output;
        
    }
}
