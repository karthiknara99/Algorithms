/*Linked List
1. Insert
2. Delete
3. Search
4. Reverse
5. Print
*/

public class Problem {
    
    static Node head;
    static int length;
    
    static class Node
    {
        int data;
        Node next;
        
        Node( int data ){
            this.data = data;
            this.next = null;
        }
    }
    
    public void insertList( int data, int pos )
    {
        if( pos > length + 1 )
        {
            System.out.println("Position invalid!! Can't Insert!!");
            return;
        }
        if( pos == 1 )
        {
            Node newNode = new Node( data );
            newNode.next = head;
            head = newNode;
            length++;
        }
        else
        {
            int i;
            Node newNode, temp = head;
            for( i = 1; i < pos - 1; i++ )
                temp = temp.next;
            newNode = new Node( data );
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }
    }
    
    public void deleteList( int data )
    {
        if( head == null )
        {
            System.out.println("Linked List Empty!! Can't Delete!!");
            return;
        }
        if( head.data == data )
        {
            head = head.next;
            return;
        }
        Node temp, delNode;
        for( temp = head; temp.next != null; temp = temp.next )
        {
            if( temp.next.data == data )
            {
                temp.next = temp.next.next;
                return;
            }
        }
        System.out.println("Element Not Found!!");
    }
    
    public Node searchList( int data )
    {
        if( head == null )
        {
            System.out.println("List Empty!!");
            return null;
        }
        Node temp;
        int i;
        for( temp = head, i = 1; temp != null; temp = temp.next, i++ )
        {
            if( temp.data == data )
            {
                System.out.println("Element " + data + " Found at Position: " + i );
                return temp;
            }
        }
        System.out.println("Element Not Found!!");
        return null;
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
    
    public void printList()
    {
        Node temp;
        for( temp = head; temp.next != null; temp = temp.next )
            System.out.print( temp.data + " " );
        System.out.println( temp.data );
    }
    
    public static void main(String[] args) {
        Problem list = new Problem();
        
        //Insert Check
        list.insertList( 11 , 1 );
        list.insertList( 22 , 2 );
        list.insertList( 44 , 3 );
        list.insertList( 33 , 3 );
        list.insertList( 55 , 5 );
        list.insertList( 66 , 6 );
        list.insertList( 77 , 7 );
        list.printList();
        
        //Delete Check
        list.deleteList( 77 );
        list.deleteList( 33 );
        list.deleteList( 11 );
        list.printList();
        
        //Search Check
        Node searchNode;
        searchNode = list.searchList( 44 );
        
        //Reverse Check
        head = list.reverseList(head);
        list.printList();
    }
}