/**
 * Created by Milind Lingineni on 5/21/2017.
 */
public class Question1_1 {
    public static void main(String[] args) {
        System.out.println(isUniqueBruteForce("Helo"));
        System.out.println(isUniqueHints("Helo"));

        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueBruteForce(word) + " " + isUniqueHints(word));
        }
    }

    /*
     * Brute force O(n^2) solution. First attempt.
     */
    public static boolean isUniqueBruteForce(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * Assume only ASCII characters and use a bit vectors
     */
    public static boolean isUniqueHints(String str) {
        if (str.length() > 128) return false;

        boolean[] bitVector = new boolean[128]; // assume ASCII characters
        for (int i = 0; i < str.length(); i++) {
            char index = str.charAt(i);
            if (bitVector[index]) return false;
            else bitVector[index] = true;
        }
        return true;
    }
}
