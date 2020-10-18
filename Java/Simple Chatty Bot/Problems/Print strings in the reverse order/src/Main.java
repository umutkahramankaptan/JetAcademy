import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> words = new Stack<>();
        while(scanner.hasNext()){
            words.push(scanner.next());
        }
        while (!words.isEmpty()){
            System.out.println(words.pop());
        }
    }
}
