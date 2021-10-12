import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        Stack<String> stack = new Stack<>();
        String str = "";
        stack.push(str);
        for (int i=0; i<q; i++) {
            int t = scanner.nextInt();
            if (t == 1) {
                str += scanner.next();
                stack.push(str);
            } else
            if(t == 2) {
                str = str.substring(0, str.length() - scanner.nextInt());
                stack.push(str);
            } else
            if(t == 3) {
                System.out.println(str.charAt(scanner.nextInt()-1));
            } else {
                stack.pop();
                str = stack.peek();    
            }
            
        }
    }
}
