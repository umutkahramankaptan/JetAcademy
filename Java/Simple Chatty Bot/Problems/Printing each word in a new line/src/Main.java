import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5 && scanner.hasNext(); i++) {
            System.out.println(scanner.next());
        }
    }
}