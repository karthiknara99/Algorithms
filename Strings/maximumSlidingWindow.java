//Maximum Sliding Window of size k

import java.util.ArrayDeque;

public class Problem {
    
    public static void main(String[] args) {       
        int i, k = 3;
        ArrayDeque<Integer> d = new ArrayDeque<>();
        int a[] = { 3, 1, -1, -3, 5, 3, 6, 7 };
        int[] o = new int[a.length-k+1];
        for( i = 0; i < k-1; i++ )
        {
            while( !d.isEmpty() && a[i] > d.peekLast() )
                d.removeLast();
            d.addLast( a[i] );
        }
        int j = 0;
        for( i = k-1; i < a.length; i++ )
        {
            while( !d.isEmpty() && a[i] > d.peekLast() )
                d.removeLast();
            d.addLast( a[i] );
            
            if( d.size() > k )
                d.removeFirst();
            
            o[j++] = d.peekFirst();
        }
        for( i = 0; i < o.length; i++ )
            System.out.println( o[i] + " " );
    }
}