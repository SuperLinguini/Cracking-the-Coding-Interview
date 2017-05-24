/**
 * Created by SuperLinguini on 5/23/2017.
 */
public class Question1_3 {
    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        System.out.println(getLastCharIndex(arr));
        System.out.println("\"" +  urlify(arr) + "\"");
    }

    public static String urlify(char[] charArr) {
        int lastValidChar = getLastCharIndex(charArr);
        int j = charArr.length - 1;
        for (int i = lastValidChar; i >= 0; i--) {
            if (charArr[i] == ' ') {
                charArr[j] = '0';
                charArr[j - 1] = '2';
                charArr[j - 2] = '%';
                j -= 3;
            } else {
                charArr[j] = charArr[i];
                j--;
            }
        }
        return new String(charArr);
    }

    public static int getLastCharIndex(char[] charArr) {
        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
}
