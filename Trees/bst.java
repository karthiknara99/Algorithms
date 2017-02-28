/* Trees
1. Insert with and without recursion
2. Delete
3. Find minimum element
4. Search with and without recursion
5. Height of a tree
6. Print - preorder, inorder and postorder
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
        
        //Level Order of a tree
        ArrayList<ArrayList<Integer>> list = tree.levelOrderTree(root);
        System.out.println("Level Order: ");
        System.out.println(list);
        
        //Equality of two trees
        System.out.println("Tree Equality: ");
        System.out.println( tree.treeEquality(root, root) );
        System.out.println("Tree Equality: ");
        System.out.println( tree.treeEquality(root, root.left) );
        
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