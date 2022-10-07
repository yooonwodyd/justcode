import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int r;
        r = scanner.nextInt();
        System.out.printf("%.6f \n", (double)Math.PI * r * r);
        System.out.printf("%.6f", (double)(4*r*r)/2);
    }
}
