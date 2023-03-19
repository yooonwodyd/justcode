import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // 개행 문자 처리를 위해서
        int[] arr = new int[n];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        System.out.println(fourStack(arr));
    }

    public static String fourStack(int[] n) {
        Stack<Integer>[] fourStacks = new Stack[] { new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>() };
        for (int number : n) {
            int count = 0;
            while (count < 4) {
                if (fourStacks[count].isEmpty() || fourStacks[count].peek() < number) {
                    fourStacks[count].push(number);
                    break;
                } else {
                    count++;
                }
            }
            if (count == 4) {
                return "NO";
            }
        }
        return "YES";
    }
}