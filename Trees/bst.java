/* Trees
1. Insert with and without recursion
2. Delete
3. Find minimum element
4. Search with and without recursion
5. Max and Min Height of a tree
6. Count number of nodes in a tree
7. Level Order of a tree
8. Sum of Level Order of a tree 
9. Check equality of two trees
10. Lowest Common Ancestor with and without recursion
11. Depth of a node from a given node
12. Shortest path length between two nodes
13. Print - preorder, inorder and postorder
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int data;
    Node left, right;

    Node( int data ){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Problem {
    
    static Node root;
    
    public Node insertTreeRec( Node ptr, int data )
    {
        if( ptr == null )
            ptr = new Node(data);
        else if( data >= ptr.data )
            ptr.right = insertTreeRec( ptr.right, data );
        else
            ptr.left = insertTreeRec( ptr.left, data );
        return ptr;
    }
    
    public void insertTreeIt( Node ptr, int data )
    {
        Node newNode = new Node(data);
        if( ptr == null )
        {
            root = newNode;
            return;
        }
        Node prev = null;
        while( ptr != null )
        {
            prev = ptr;
            if( data >= ptr.data )
                ptr = ptr.right;
            else
                ptr = ptr.left;
        }
        if( data >= prev.data )
            prev.right = newNode;
        else
            prev.left = newNode;
    }
    
    public Node deleteTree( Node ptr, int data )
    {
        if( ptr == null )
            return ptr;
        if( data < ptr.data )
            ptr.left = deleteTree( ptr.left, data );
        else if( data > ptr.data )
            ptr.right = deleteTree( ptr.right, data );
        else
        {
            if( ptr.left == null )
                return ptr.right;
            if( ptr.right == null )
                return ptr.left;
            ptr.data = findMin( ptr.right );
            ptr.right = deleteTree( ptr.right, ptr.data );
        }
        return ptr;
    }
    
    public int findMin( Node ptr )
    {
        while( ptr.left != null )
            ptr = ptr.left;
        return ptr.data;
    }
    
    public Node searchTreeRec( Node ptr, int data )
    {
        if( ptr == null )
            return null;
        if( ptr.data == data )
            return ptr;
        else if( data >= ptr.data )
            return searchTreeRec( ptr.right, data );
        else
            return searchTreeRec( ptr.left, data );
    }
    
    public Node searchTreeIt( Node ptr, int data )
    {
        if( ptr == null )
            return null;
        while( ptr != null )
        {
            if( ptr.data == data )
                return ptr;
            if( data >= ptr.data )
                ptr = ptr.right;
            else
                ptr = ptr.left;
        }
        return null;
    }
    
    public int MaxHeightTree( Node ptr )
    {
        if( ptr == null )
            return -1;
        return 1 + Math.max( MaxHeightTree(ptr.left), MaxHeightTree(ptr.right) );
    }
    
    public int MinHeightTree( Node ptr )
    {
        if( ptr == null )
            return -1;
        return 1 + Math.min( MinHeightTree(ptr.left), MinHeightTree(ptr.right) );
    }
    
    public int numNodes( Node ptr )
    {
        if( ptr == null )
            return 0;
        return ( 1 + numNodes( ptr.left ) + numNodes( ptr.right ) );
    }
    
    public ArrayList<ArrayList<Integer>> levelOrderTree( Node ptr )
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if( ptr == null )
            return list;
        Queue<Node> q = new LinkedList<>();
        q.add(ptr);
        while( !q.isEmpty() )
        {
            int loopsize = q.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for( int i = 0; i < loopsize; i++ )
            {
                Node curr = q.poll();
                tempList.add(curr.data);
                if( curr.left != null )
                    q.add( curr.left );
                if( curr.right != null )
                    q.add( curr.right );
            }
            list.add( tempList );
        }
        return list;
    }
    
    public ArrayList<Integer> sumLevelOrderTree( Node ptr )
    {
        ArrayList<Integer> list = new ArrayList<>();
        if( ptr == null )
            return list;
        Queue<Node> q = new LinkedList<>();
        q.add(ptr);
        while( !q.isEmpty() )
        {
            int loopsize = q.size();
            int loopsum = 0;
            for( int i = 0; i < loopsize; i++ )
            {
                Node curr = q.poll();
                loopsum += curr.data;
                if( curr.left != null )
                    q.add( curr.left );
                if( curr.right != null )
                    q.add( curr.right );
            }
            list.add( loopsum );
        }
        return list;
    }
    
    public boolean treeEquality( Node ptr1, Node ptr2 )
    {
        if( ptr1 == null && ptr2 == null )
            return true;
        if( ptr1 == null || ptr2 == null )
            return false;
        if( ptr1.data == ptr2.data )
            return treeEquality( ptr1.left, ptr2.left ) & treeEquality( ptr1.right, ptr2.right );
        return false;
    }
    
    public Node lowestCommonAncestorRec( Node ptr, int n1, int n2 )
    {
        if( ptr == null )
            return ptr;
        if( ptr.data == n1 || ptr.data == n2 )
            return ptr;
        
        Node left_lca = lowestCommonAncestorRec( ptr.left, n1, n2 );
        Node right_lca = lowestCommonAncestorRec( ptr.right, n1, n2 );
        
        if( left_lca != null && right_lca != null )
            return ptr;
        return ( left_lca != null ) ? left_lca : right_lca;
    }
    
    public Node lowestCommonAncestorIt( Node ptr, int n1, int n2 )
    {
        while( ptr != null )
        {
            if( ptr.data < n1 && ptr.data < n2 )
                ptr = ptr.right;
            else if( ptr.data > n1 && ptr.data > n2 )
                ptr = ptr.left;
            else
                return ptr;
        }
        return ptr;
    }
    
    //Assuming Both Nodes Exist
    public int depthOfNodeFromNode( Node ptr, int data )
    {
        if( ptr == null )
            return -999;
        if( ptr.data == data )
            return 0;
        else if( data >= ptr.data )
            return 1 + depthOfNodeFromNode( ptr.right, data );
        else
            return 1 + depthOfNodeFromNode( ptr.left, data );
    }
    
    //Assuming Both Nodes Exist
    public int shortestPathLengthBetweenNodes( Node ptr, int n1, int n2 )
    {
        Node lca = lowestCommonAncestorRec(ptr, n1, n2);
        int d1 = depthOfNodeFromNode(lca, n1);
        int d2 = depthOfNodeFromNode(lca, n2);
        return d1 + d2;
    }
    
    public void printInOrderTree( Node ptr )
    {
        if( ptr == null )
            return;
        printInOrderTree( ptr.left );
        System.out.print( ptr.data + " " );
        printInOrderTree( ptr.right );
    }
    
    public void printPreOrderTree( Node ptr )
    {
        if( ptr == null )
            return;
        System.out.print( ptr.data + " " );
        printPreOrderTree( ptr.left );
        printPreOrderTree( ptr.right );
    }
    
    public void printPostOrderTree( Node ptr )
    {
        if( ptr == null )
            return;
        printPostOrderTree( ptr.left );
        printPostOrderTree( ptr.right );
        System.out.print( ptr.data + " " );
    }
    
     public static void main(String[] args) {
        Problem tree = new Problem();
        Node temp;
        
        //Insert
        root = tree.insertTreeRec( root, 50 );
        root = tree.insertTreeRec( root, 30 );
        root = tree.insertTreeRec( root, 70 );
        tree.insertTreeIt( root, 20 );
        tree.insertTreeIt( root, 40 );
        tree.insertTreeIt( root, 60 );
        tree.insertTreeIt( root, 80 );
        tree.printInOrderTree(root);
        System.out.println("");
        
        //Search
        temp = tree.searchTreeRec( root, 10 );
        if( temp != null )
            System.out.println( "Found: " + temp.data );
        else
            System.out.println("Not Found!!");
        temp = tree.searchTreeRec( root, 20 );
        if( temp != null )
            System.out.println( "Found: " + temp.data );
        else
            System.out.println("Not Found!!");
        temp = tree.searchTreeIt( root, 80 );
        if( temp != null )
            System.out.println( "Found: " + temp.data );
        else
            System.out.println("Not Found!!");
        temp = tree.searchTreeIt( root, 90 );
        if( temp != null )
            System.out.println( "Found: " + temp.data );
        else
            System.out.println("Not Found!!");
        
        //Number of Nodes in a tree
        System.out.println( "Number of Nodes in the tree : " + tree.numNodes(root) );
        
        //Level Order of a tree
        ArrayList<ArrayList<Integer>> list = tree.levelOrderTree(root);
        System.out.println("Level Order: ");
        System.out.println(list);
        
        //Sum Level Order of a tree
        ArrayList<Integer> sumList = tree.sumLevelOrderTree(root);
        System.out.println("Sum Level Order: ");
        System.out.println(sumList);
        
        //Equality of two trees
        System.out.println("Tree Equality: ");
        System.out.println( tree.treeEquality(root, root) );
        System.out.println("Tree Equality: ");
        System.out.println( tree.treeEquality(root, root.left) );
        
        //Lowest Common Ancestor
        System.out.println("Lowest Common Ancestor: ");
        System.out.println( tree.lowestCommonAncestorRec( root, 30, 40 ).data );
        System.out.println("Lowest Common Ancestor: ");
        System.out.println( tree.lowestCommonAncestorRec( root, 30, 70 ).data );
        
        //Shortest Path Length Between Nodes
        System.out.println("Shortest Path Length Between Nodes: ");
        System.out.println( tree.shortestPathLengthBetweenNodes(root, 30, 40 ) );
        System.out.println("Shortest Path Length Between Nodes: ");
        System.out.println( tree.shortestPathLengthBetweenNodes(root, 30, 70 ) );
        
        //Delete
        root = tree.deleteTree( root, 20 );
        tree.printInOrderTree(root);
        System.out.println("");
        root = tree.deleteTree( root, 30 );
        tree.printInOrderTree(root);
        System.out.println("");
        root = tree.deleteTree( root, 50 );
        tree.printInOrderTree(root);
        System.out.println("");
        
        //Height of a tree
        System.out.println( "Max Height : " + tree.MaxHeightTree(root) );
        System.out.println( "Min Height : " + tree.MinHeightTree(root) );
    }
}