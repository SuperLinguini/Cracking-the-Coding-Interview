/**
 * Created by SuperLinguini on 5/30/2017.
 */
public class Question1_4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Tact Coa"));

        String pali = "Rats live on no evil star";
        System.out.println(isPalindrome(pali));
    }

    /*
     * Checks whether a permutation of a String is a palindrome in O(n) time
     */
    public static boolean isPalindrome(String original) {
        String str = original.toLowerCase();
        boolean[] bitVector = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            char index = str.charAt(i);
            if (index != ' ') {
                bitVector[index] = !bitVector[index];
            }
        }

        int numTrue = 0;
        for (int j = 0; j < bitVector.length; j++) {
            if (bitVector[j]) {
                numTrue++;
                if (numTrue > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
