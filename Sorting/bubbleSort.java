//Bubble Sort

import java.util.Random;

public class Problem {
    
    public static void bubbleSort( int a[] )
    {
        int i, j, temp;
        for( i = 0; i < a.length; i++ )
        {
            for( j = 1; j < a.length-i; j++ )
            {
                if( a[j] < a[j-1] )
                {
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int i, n = 100;
        int[] a = new int[n];
        
        Random rand = new Random();
        for( i = 0; i < n; i++ )
            a[i] = rand.nextInt( 1000 );
        
        bubbleSort( a );
        
        for( i = 0; i < n-1; i++ )
            System.out.print( a[i] + " " );
        System.out.println( a[i] );
    }
}