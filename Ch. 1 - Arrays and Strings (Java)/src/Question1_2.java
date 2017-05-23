import java.util.Arrays;

/**
 * Created by Milind Lingineni on 5/21/2017.
 */
public class Question1_2 {
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

    /*
     * Sorts the string by converting it to a char array and then back to
     * a string. O(n log n) solution
     */
    public static boolean isPermutation(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        return getSortedString(first).equals(getSortedString(second));
    }

    private static String getSortedString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    /*
     * O(f + s) solution where f,s are lengths of first and second respectively
     * using a counter for each character. Assumed to be ASCII
     */
    private static boolean isPermutation2(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int[] asciiLetterCount = new int[128];
        for (int i = 0; i < first.length(); i++) {
            asciiLetterCount[first.charAt(i)]++;
        }

        for (int j = 0; j < second.length(); j++) {
            if (--asciiLetterCount[second.charAt(j)] < 0) {
                return false;
            }
        }
        return true;
    }
}
