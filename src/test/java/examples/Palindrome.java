package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Palindrome {

    public boolean isPalindrome(String s) {

        boolean isPalindrome = false;

        if (s != null && s.length() > 0) {

            isPalindrome = true;

            for (int idxStart=0, idxEnd = s.length() - 1; idxStart <= idxEnd; idxStart++, idxEnd--) {
                if (s.charAt(idxStart) != s.charAt(idxEnd)) {
                    isPalindrome = false;
                    break;
                }
            }

        }

        return isPalindrome;
    }

    @Test
    public void testPalindrome() {

        Assertions.assertTrue(isPalindrome("kayak"));

        Assertions.assertTrue(isPalindrome("a"));

        Assertions.assertFalse(isPalindrome("kayAk"));

        Assertions.assertFalse(isPalindrome("hello"));

        Assertions.assertFalse(isPalindrome(null));

    }
}
