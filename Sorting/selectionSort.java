//Selection Sort

import java.util.Random;

public class Problem {
    
    public static void selectionSort( int a[] )
    {
        int i, j, min, pos, temp;
        for( i = 0; i < a.length; i++ )
        {
            min = a[i];
            pos = i;
            for( j = i+1; j < a.length; j++ )
            {
                if( a[j] < min )
                {
                    min = a[j];
                    pos = j;
                }
            }
            if( pos != i )
            {
                temp = a[i];
                a[i] = a[pos];
                a[pos] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int i, n = 100;
        int[] a = new int[n];
        
        Random rand = new Random();
        for( i = 0; i < n; i++ )
            a[i] = rand.nextInt( 1000 );
        
        selectionSort( a );
        
        for( i = 0; i < n-1; i++ )
            System.out.print( a[i] + " " );
        System.out.println( a[i] );
    }
}