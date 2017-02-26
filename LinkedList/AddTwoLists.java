//Arithmetic add of two linked list whose sum is bound by the number of digits
//i.e sum of two 3 digit number is also a 3 digit number

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
        return head;
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
        head1.next = new Node( 9 );
        head1.next.next = new Node( 3 );
        
        head2 = new Node( 1 );
        head2.next = new Node( 3 );
        head2.next.next = new Node( 5 );
        
        list.printList( head1 );
        list.printList( head2 );
        
        head = list.addList( head1, head2 );
        list.printList( head );
    }
}