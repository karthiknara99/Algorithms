//Longest Palindromic Substring

public class Problem {
    
    public static void main(String[] args) {       
        int j, k, maxLen = 0, starti = 0, endi = 0;
        String s = "aacfefcyuyoppo";
        
        //Appending space in between characters
        /*
        s = s.replace(""," ").trim();
        for( int i = 0; i < s.length(); i++ )
        {
            j = k = i;
            int len = 0;
            if( s.charAt(i) != ' ' )
                len++;
            while( --j >= 0 && ++k < s.length() )
            {
                if( s.charAt(j) != s.charAt(k) )
                    break;
                if( s.charAt(j) != ' ' && s.charAt(k) != ' ' )
                    len += 2;
            }
            if( len > maxLen )
            {
                maxLen = len;
                starti = j+1;
                endi = k-1;
            }
        }
        System.out.println(maxLen + " " + s.substring(starti,endi+1).replace(" ", ""));
        */
        
        //Not space in between characters
        for( float i = 0; i < s.length(); i += 0.5 )
        {
            int len = 0;
            if( i % 1 == 0 )
                len = 1;
            j = (int)Math.floor( i - 0.5 );
            k = (int)Math.ceil( i + 0.5 );
            
            while( j >= 0 && k < s.length() )
            {
                if( s.charAt(j) != s.charAt(k) )
                    break;
                len += 2;
                j--;
                k++;
            }
            if( len > maxLen )
            {
                maxLen = len;
                starti = j+1;
                endi = k-1;
            }
        }
        System.out.println(maxLen + " " + s.substring(starti,endi+1));
    }
}