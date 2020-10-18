//put imports you need here

import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> guests = new Stack<>();
        while(scanner.hasNext()){
            guests.push(scanner.next());
        }
        while (!guests.isEmpty()){
            System.out.println(guests.pop());
        }
    }
}