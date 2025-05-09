import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Connect to the server on port 2000
            String url = "rmi://localhost:2000/Server";
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(url);

            System.out.print("Enter num1: ");
            int a = sc.nextInt();

            System.out.print("Enter num2: ");
            int b = sc.nextInt();
            sc.nextLine();  // Consume the newline character

            System.out.println("Addition: " + serverIntf.addition(a, b));
            System.out.println("Subtraction: " + serverIntf.subtraction(a, b));
            System.out.println("Multiplication: " + serverIntf.multiplication(a, b));
            System.out.println("Division: " + (b == 0 ? "Error: Division by zero!" : serverIntf.division(a, b)));
            System.out.println("Square of num1: " + serverIntf.square(a));
            System.out.println("Square root of num2: " + serverIntf.squareroot(b));

            System.out.print("Enter a string to check palindrome: ");
            String str = sc.nextLine();
            System.out.println("Is Palindrome? " + serverIntf.isPalindrome(str));

            System.out.print("Enter first string to compare: ");
            String str1 = sc.nextLine();

            System.out.print("Enter second string to compare: ");
            String str2 = sc.nextLine();

            System.out.println("Are both strings equal? " + serverIntf.isEqualString(str1, str2));

            System.out.print("Enter n for Fibonacci series: ");
            int n = sc.nextInt();
            System.out.println("Fibonacci series: " + serverIntf.fibonacci(n));


        } catch (Exception e) {
            System.out.println("Exception at Client: " + e);
        }
        sc.close();
    }
}
