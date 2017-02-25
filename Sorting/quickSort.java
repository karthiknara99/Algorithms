//Quick Sort

import java.util.Random;

public class Problem {
    
    public static void quickSort( int a[], int p, int r )
    {
        int q = 0;
        if( p < r )
        {
            q = partition( a, p, r );
            quickSort( a, p, q-1 );
            quickSort( a, q+1, r );
        }
    }
    
    public static int partition( int a[], int p, int r )
    {
        int temp, j;
        int i = p-1;
        int pivot = a[r];
        for( j = p; j <= r-1; j++ )
        {
            if( a[j] <= pivot )
            {
                i++;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        temp = a[i+1];
        a[i+1] = a[r];
        a[r] = temp;
        return i+1;
    }
    
    public static void main(String[] args) {
        int i, n = 100;
        int[] a = new int[n];
        
        Random rand = new Random();
        for( i = 0; i < n; i++ )
            a[i] = rand.nextInt( 1000 );
        
        quickSort( a, 0, a.length-1 );
        
        for( i = 0; i < n-1; i++ )
            System.out.print( a[i] + " " );
        System.out.println( a[i] );
    }
}