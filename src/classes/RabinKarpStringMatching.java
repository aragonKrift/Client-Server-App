package classes;

import classes.IAlgoStringMatching;

public class RabinKarpStringMatching implements IAlgoStringMatching {
    @Override
    public int search(String text, String pattern) {
        if (text.isEmpty() || pattern.isEmpty()) {
            return -1;
        }

        int n = text.length();
        int m = pattern.length();
        int prime = 101; // a prime number

        long patternHash = 0;
        long textHash = 0;
        long h = 1;

        // Calculate hash for the pattern and first window of text
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash + pattern.charAt(i) * h) % prime;
            textHash = (textHash + text.charAt(i) * h) % prime;
            if (i < m - 1)
                h = (h * 256) % prime;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            // Check the hash values of current window of text and pattern
            if (patternHash == textHash) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == m)
                    return i; // pattern found at index i
            }

            // Calculate hash value for next window of text: Remove leading digit,
            // add trailing digit
            if (i < n - m) {
                textHash = (256 * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % prime;
                // Convert negative hash value to positive
                if (textHash < 0)
                    textHash += prime;
            }
        }
        return -1; // pattern not found
    }
}
