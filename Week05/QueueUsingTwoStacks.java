
import java.util.*;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int q = scanner.nextInt();
        while (q-- > 0) {
            int type = scanner.nextInt();
            if (type == 1) { // enQueue to the back
                int num = scanner.nextInt();
                stack1.push(num);
            }
            if (type == 2) { // dequeue at the front
                if(!stack2.isEmpty()) {
                    stack2.pop();
                } else
                if (!stack1.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    stack2.pop();
                }

            }
            if (type == 3) { // print first element
                if (!stack2.isEmpty()) {
                    System.out.println(stack2.peek());
                } else
                if (!stack1.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    System.out.println(stack2.peek());
                }

            }
        }
    }
}
