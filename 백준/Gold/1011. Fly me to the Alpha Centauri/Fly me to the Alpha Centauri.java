import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);
       
       int n = scanner.nextInt();
       
       for(int i = 0; i < n; i++)
       {
           int x = scanner.nextInt();
           int y = scanner.nextInt();
           
           long a = (int)Math.sqrt(y-x);
           
           if( y - x == a*a)
           {
               System.out.println(2*a-1);
           }
           else if(a*a < y-x && y-x <= a*a + a)
           {
               System.out.println(2*a);
           }
           else if(a*a+a<y-x && y-x < (a+1)*(a+1))
           {
               System.out.println(2*a+1);
           }
       }
       
       
    }
}
