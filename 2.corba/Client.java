import PallindromeStringApp.PallindromeString;
import PallindromeStringApp.PallindromeStringHelper;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // Get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            // Use NamingContextExt which is part of the Interoperable Naming Service (INS) specification
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve the object reference in naming
            String name = "Palindrome";
            PallindromeString palindromeObj = PallindromeStringHelper.narrow(ncRef.resolve_str(name));

            // Input from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string to check for palindrome: ");
            String input = scanner.nextLine();

            // Invoke the remote method
            String result = palindromeObj.checkPalindrome(input);
            System.out.println("Result from server: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}