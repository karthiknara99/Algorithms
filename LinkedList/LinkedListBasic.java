/*Linked List
1. Insert
2. Delete
3. Search
4. Reverse
5. Reverse List from i to j
6. Remove nth node from the end
7. Check Cycle
8. Delete Duplicates in a sorted list
9. Delete Duplicates in an unsorted list
10. Swap pairs
11. Print
*/

import java.util.HashSet;

class Node
{
    int data;
    Node next;

    Node( int data ){
        this.data = data;
        this.next = null;
    }
}

public class Problem {
    
    static Node head;
    
    public boolean insertList( int data, int pos )
    {
        if( pos == 1 )
        {
            Node newNode = new Node( data );
            newNode.next = head;
            head = newNode;
        }
        else
        {
            int i;
            Node newNode, temp = head;
            for( i = 1; i < pos - 1; i++ )
            {
                if( temp.next == null )
                    return false;
                temp = temp.next;
            }
            newNode = new Node( data );
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return true;
    }
    
    public boolean deleteList( int data )
    {
        if( head == null )
            return false;
        if( head.data == data )
        {
            head = head.next;
            return true;
        }
        Node temp, delNode;
        for( temp = head; temp.next != null; temp = temp.next )
        {
            if( temp.next.data == data )
            {
                temp.next = temp.next.next;
                return true;
            }
        }
        return false;
    }
    
    public int searchList( int data )
    {
        if( head == null )
            return -1;
        Node temp;
        int i;
        for( temp = head, i = 1; temp != null; temp = temp.next, i++ )
        {
            if( temp.data == data )
                return i;
        }
        return -1;
    }
    
    public Node reverseList( Node head )
    {
        Node prev = null, next = null;
        Node curr = head;
        while( curr != null )
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    
    public Node reverseListPos( Node head, int start, int end )
    {
        Node next;
        Node curr = head;
        for( int i = 1; i < start-1; i++ )
            curr = curr.next;
        Node super_prev = curr;
        if( start != 1 )
            curr = curr.next;
        Node super_curr = curr;
        Node prev = null;
        for( int i = start; i <= end; i++ ) 
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        super_curr.next = curr;
        if( head == super_prev )
            head = prev;
        else
            super_prev.next = prev;
        return head;
    }
    
    public Node removeNthNode( Node head, int n )
    {
        Node slow, fast = head;
        for( int i = 0; i < n; i++ )
            fast = fast.next;
        for( slow = head; fast.next != null; fast = fast.next, slow = slow.next );
        slow.next = slow.next.next;
        return head;
    } 
    
    public boolean checkCycle( Node head )
    {
        Node fast, slow;
        try
        {
            for( fast = head.next, slow = head; fast != null; fast = fast.next.next, slow = slow.next )
            {
                if( fast == slow )
                    return true;
            }
        }
        catch( NullPointerException e )
        {
            return false;
        }
        return false;
    }
    
    public Node deleteDuplicates( Node head )
    {
        Node temp = head;
        while( temp.next != null )
        {
            if( temp.data == temp.next.data )
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }
    
    public Node deleteDuplicatesUnordered( Node head )
    {
        HashSet<Integer> set = new HashSet<>();
        Node curr = head, prev = null;
        while( curr != null )
        {
            if( set.add(curr.data) == false )
            {
                curr = curr.next;
                prev.next = curr;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
    
    public Node swapPairs( Node head )
    {
        Node curr = head, prev = null;
        Node next;
        while( curr != null && curr.next != null )
        {
            next = curr.next;
            if( curr == head )
                head = next;
            curr.next = next.next;
            next.next = curr;
            if( prev != null )
                prev.next = next;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
    
    public void printList()
    {
        Node temp;
        for( temp = head; temp.next != null; temp = temp.next )
            System.out.print( temp.data + " " );
        System.out.println( temp.data );
    }
    
    public static void main(String[] args) {
        Problem list = new Problem();
        boolean check = false;
        
        //Insert Check
        check = list.insertList( 11 , 1 );
        check = list.insertList( 22 , 2 );
        check = list.insertList( 44 , 3 );
        check = list.insertList( 33 , 3 );
        check = list.insertList( 55 , 5 );
        check = list.insertList( 66 , 6 );
        check = list.insertList( 77 , 7 );
        check = list.insertList( 22 , 8 );
        check = list.insertList( 22 , 4 );
        check = list.insertList( 44 , 2 );
        if( check == false )
            System.out.println("Position invalid!! Can't Insert!!");
        list.printList();
        
        /*//Check Cycle
        head = new Node( 11 );
        head.next = new Node( 22 );
        head.next.next = new Node( 33 );
        Node temp = head.next.next.next = new Node( 44 );
        head.next.next.next.next = new Node( 55 );
        head.next.next.next.next.next = temp;
        check = list.checkCycle(head);
        System.out.println( check );
        */
        
        //Search Check
        int searchPos;
        searchPos = list.searchList( 44 );
        System.out.println("Element 44 Found at Position: " + searchPos );

        //Delete Duplicates
        head = list.deleteDuplicatesUnordered(head);
        System.out.println("Deleted duplicates: ");
        list.printList();
        
        //Remove nth node from the end
        head = list.removeNthNode(head,3);
        System.out.println("Removed 3rd node from last: ");
        list.printList();
        
        //Swap Pairs
        System.out.println("Swap Pairs: ");
        head = list.swapPairs(head);
        list.printList();
        
        //Reverse Check
        System.out.println("Reverse List: ");
        head = list.reverseList(head);
        list.printList();
        
        //Reverse Specific Position
        System.out.println("Reverse List between positions: ");
        head = list.reverseListPos(head,1,5);
        list.printList();
        
        //Delete Check
        check = list.deleteList( 22 );
        check = list.deleteList( 44 );
        check = list.deleteList( 11 );
        if( check == false )
            System.out.println("Position invalid!! Can't Delete!!");
        list.printList();
    }
}