/*
1. Arithmetic add of two linked list
2. Intersection of two lists
*/

import java.util.Stack;

public class Problem {
    
    static Node head, head1, head2;
    
    static class Node
    {
        int data;
        Node next;
        
        Node( int data ){
            this.data = data;
            this.next = null;
        }
    }
    
    public Node addList( Node head1, Node head2 )
    {
        Node head = null;
        int count1 = 0;
        int count2 = 0;
        for( Node temp1 = head1; temp1 != null; temp1 = temp1.next)
                count1++;
        for( Node temp2 = head2; temp2 != null; temp2 = temp2.next)
                count2++;
        if( count1 > count2 )
        {
            for( int i = 0; i < count1 - count2; i++ )
            {
                Node newNode = new Node(0);
                newNode.next = head2;
                head2 = newNode;
            }
        }
        else
        {
            for( int i = 0; i < count2 - count1; i++ )
            {
                Node newNode = new Node(0);
                newNode.next = head1;
                head1 = newNode;
            }
        }
		
        Stack<Integer> s = new Stack<>();
        for( Node temp1 = head1, temp2 = head2; temp1 != null && temp2 != null; temp1 = temp1.next, temp2 = temp2.next )
        {
            s.push( temp1.data );
            s.push( temp2.data );
        }
        int carry = 0;
        while( !s.isEmpty() )
        {
            int a, b, sum, res;
            a = s.pop();
            b = s.pop();
            sum = a + b + carry;
            res = sum % 10;
            Node newNode = new Node( res );
            if( head == null )
            {
                head = newNode;
            }
            else
            {
                newNode.next = head;
                head = newNode;
            }
            carry = sum / 10;
        }
        if( carry > 0 )
        {
                Node newNode = new Node( carry );
                newNode.next = head;
                head = newNode;
        }
        return head;
    }
	
    public Node intersectionList( Node head1, Node head2 )
    {
        Node temp1 = head1, temp2 = head2;
        while( temp1 != null && temp2 != null )
        {
            if( temp1.data == temp2.data )
                return temp1;
            
            if( temp1.next == null )
                temp1 = head2;
            else
                temp1 = temp1.next;
            
            if( temp2.next == null )
                temp2 = head1;
            else
                temp2 = temp2.next;
        }
        return null;
    }
    
    public void printList( Node head )
    {
        Node temp;
        for( temp = head; temp.next != null; temp = temp.next )
            System.out.print( temp.data + " " );
        System.out.println( temp.data );
    }
    
    public static void main(String[] args) {
        
        Problem list = new Problem();
        
        head1 = new Node( 1 );
        head1.next = new Node( 2 );
        head1.next.next = new Node( 3 );
        head1.next.next.next = new Node( 4 );
        head1.next.next.next.next = new Node( 5 );
        
        head2 = new Node( 6 );
        head2.next = new Node( 7 );
        head2.next.next = new Node( 8 );
		head2.next.next.next = new Node( 9 );
		head2.next.next.next.next = new Node( 3 );
		head2.next.next.next.next.next = new Node( 4 );
		head2.next.next.next.next.next.next = new Node( 5 );
        
        list.printList( head1 );
        list.printList( head2 );
		
		Node temp = list.intersectionList( head1, head2 );
        if( temp != null )
            System.out.println( "Intersection point: " + temp.data );
        else
            System.out.println( "No intersection point" );
        
        head = list.addList( head1, head2 );
        list.printList( head );
    }
}