import java.util.Scanner;

public class Exp1 {

    public static int fibRec(int n){
        if (n < 0)
            return -1;
        if (n == 0 || n == 1)
            return n;
        else
            return fibRec(n - 1) + fibRec(n - 2);
    }

    public static int fibIter(int n){
        if (n < 0)
            return -1;
        if (n == 0 || n == 1)
            return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void printFibSeries(int n){
        if (n < 0){
            System.out.println("Enter positive number");
            return;
        }
        if (n == 0){
            System.out.println("0");
            return;
        }
        int a = 0, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++){
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // ← move scanner outside loop
        while (true) {
            System.out.println("\nEnter 1 to print nth Fibonacci number using recursion");
            System.out.println("Enter 2 to print nth Fibonacci number using iteration");
            System.out.println("Enter 3 to print Fibonacci series");
            System.out.println("Enter 0 to exit");

            int op = sc.nextInt();

            if (op == 0) {
                System.out.println("Exiting...");
                break;
            } else if (op == 1) {
                System.out.println("Enter the value of n:");
                int n1 = sc.nextInt();
                System.out.println("Result is: " + fibRec(n1));
            } else if (op == 2) {
                System.out.println("Enter the value of n:");
                int n2 = sc.nextInt();
                System.out.println("Result is: " + fibIter(n2));
            } else if (op == 3) {
                System.out.println("Enter the value of n:");
                int n3 = sc.nextInt();
                printFibSeries(n3);
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
        sc.close();
    }
}
