import PallindromeStringApp.PallindromeStringPOA;

public class PallindromeImpl extends PallindromeStringPOA {
    @Override
    public String checkPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equalsIgnoreCase(reversed)) {
            return input + " is a Palindrome.";
        } else {
            return input + " is NOT a Palindrome.";
        }
    }
}