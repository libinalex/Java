public class ManachersAlgorithm {

    // Function to preprocess the input string and add special characters
    private static String preProcess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }
        return sb.toString();
    }

    public static String findLongestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String processedString = preProcess(s);
        int n = processedString.length();
        int[] p = new int[n]; // Array to store the lengths of palindromic substrings centered at each character
        int center = 0; // Center of the current longest palindromic substring
        int right = 0; // Right boundary of the current longest palindromic substring

        for (int i = 0; i < n; i++) {
            // Find the mirror index of i
            int mirror = 2 * center - i;

            // If i is within the right boundary of the current longest palindromic substring,
            // then we can use the mirror value to optimize the palindrome length calculation
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around the current center to find the palindrome length
            int leftIndex = i - (p[i] + 1);
            int rightIndex = i + (p[i] + 1);

            while (leftIndex >= 0 && rightIndex < n && processedString.charAt(leftIndex) == processedString.charAt(rightIndex)) {
                p[i]++;
                leftIndex--;
                rightIndex++;
            }

            // Update the right boundary and center if the palindrome expands past the current right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Find the maximum palindrome length and its center
        int maxLength = 0;
        int maxCenter = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] > maxLength) {
                maxLength = p[i];
                maxCenter = i;
            }
        }

        // Extract the longest palindromic substring from the processed string
        int start = (maxCenter - maxLength) / 2;
        int end = start + maxLength;
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        String input = "malayalam";
        String longestPalindrome = findLongestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }
}
