//Heap Sort

import java.util.Random;

public class Problem {
    
    private static int heapSize;
    
    public static int parent( int i )
    {
        return i/2;
    }
    
    public static int left( int i )
    {
        return 2*i;
    }
    
    public static int right( int i )
    {
        return (2*i)+1;
    }
    
    public static void maxHeapify( int a[], int i )
    {
        int largest, temp;
        int l = left(i);
        int r = right(i);
        if( l <= heapSize && a[l] > a[i] )
            largest = l;
        else
            largest = i;
        if( r <= heapSize && a[r] > a[largest] )
            largest = r;
        if( largest != i )
        {
            temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeapify( a, largest );
        }
    }
    
    public static void buildMaxHeap( int a[] )
    {
        int i;
        heapSize = a.length-1;
        for( i = (a.length-1)/2; i >= 0; i-- )
            maxHeapify(a, i);
    }
    
    public static void heapSort( int a[] )
    {
        int i, temp;
        buildMaxHeap( a );
        
        for( i = a.length-1; i >= 1; i-- )
        {
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapSize--;
            maxHeapify( a, 0 );
        }
    }
    
    public static void main(String[] args) {
        int i, n = 100;
        int[] a = new int[n];
        
        Random rand = new Random();
        for( i = 0; i < n; i++ )
            a[i] = rand.nextInt( 1000 );
        
        heapSort( a );
        
        for( i = 0; i < n-1; i++ )
            System.out.print( a[i] + " " );
        System.out.println( a[i] );
    }
}