//Merge Sort

import java.util.Random;

public class Problem {
    
    public static void mergeSort( int a[], int p, int r )
    {
        if( p < r )
        {
            int q = ( p + r ) / 2;
            mergeSort( a, p, q );
            mergeSort( a, q+1, r );
            merge( a, p, q, r );
        }
    }
    
    public static void merge( int a[], int p, int q, int r )
    {
        int i, j, k;
        int s1 = q-p+1;
        int s2 = r-q;
        int[] a1 = new int[s1+1];
        int[] a2 = new int[s2+1];
        for( i = 0; i < s1; i++ )
            a1[i] = a[p+i];
        for( i = 0; i < s2; i++ )
            a2[i] = a[q+i+1];
        a1[s1] = a2[s2] = Integer.MAX_VALUE;
        
        i = j = 0;
        for( k = p; k <=r; k++ )
        {
            if( a1[i] < a2[j] )
                a[k] = a1[i++];
            else
                a[k] = a2[j++];
        }
    }
    
    public static void main(String[] args) {
        int i, n = 100;
        int[] a = new int[n];
        
        Random rand = new Random();
        for( i = 0; i < n; i++ )
            a[i] = rand.nextInt( 1000 );
        
        mergeSort( a, 0, a.length-1 );
        
        for( i = 0; i < n-1; i++ )
            System.out.print( a[i] + " " );
        System.out.println( a[i] );
    }
}