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
    }

    public static boolean isPermutation(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        return getSortedCharArr(first).equals(getSortedCharArr(second));
    }

    private static String getSortedCharArr(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);

    }
}
