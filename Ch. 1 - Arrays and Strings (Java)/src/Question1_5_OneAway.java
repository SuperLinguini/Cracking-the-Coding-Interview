/**
 * Created by SuperLinguini on 5/31/2017.
 */
public class Question1_5_OneAway {
    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }
    }

    public static void test(String a, String b, boolean expected) {
        boolean resultA = isOneAway(a, b);
        boolean resultB = isOneAway(a, b);

        if (resultA == expected && resultB == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }

    public static boolean isOneAway(String first, String second) {
        if (first.length() == second.length())
            return isOneReplaced(first, second);
        else if (Math.abs(first.length() - second.length()) <= 1)
            return isOneOff(first, second);
        return false;
    }

    private static boolean isOneReplaced(String first, String second) {
        boolean different = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (different) {
                    return false;
                }
                different = true;
            }
        }
        return true;
    }

    private static boolean isOneOff(String one, String two) {
        String first, second;
        if (one.length() < two.length()) {
            first = two;
            second = one;
        } else {
            first = one;
            second = two;
        }
        int f = 0, s = 0;
        while (f < first.length() && s < second.length()) {
            if (first.charAt(f) != second.charAt(s)) {
                if (f != s) {
                    return false;
                }
                f++;
            } else {
                f++;
                s++;
            }
        }
        return true;
    }


    /**
     * Attempted to use indexes like in quick sort to match strings.
     * Almost worked but too many edge cases.
     * So close to the provided answer!
     */
    public static boolean isOneAwayIndex(String first, String second) {
        int f = 0, s = 0;
        int max = first.length() >= second.length() ? first.length() - 1: second.length() - 1;
        int diffs = 0;
        while (diffs < 2 && f < max && s < max) {
            char firstChar = first.charAt(f);
            char secondChar = second.charAt(s);
            if (firstChar == secondChar) {
                f++;
                s++;
            } else if (s + 1 < max && f + 1 < max && first.charAt(f + 1) == second.charAt(s + 1)){
                diffs++;
                f++;
                s++;
            } else {
                diffs++;
                if (first.length() >= second.length()) {
                    f++;
                } else {
                    s++;
                }
            }
            if (f >= first.length()) {
                f = first.length();
            }
            if (s >= second.length()) {
                s = second.length();
            }
        }
        return diffs < 2;
    }


    /**
     * Attempted to use hashes to solve problem. Works on all
     * pairs of words that are actually one apart but not those that aren't.
     */
    public static boolean isOneAwayHash(String first, String second) {
        int a = hash(first);
        int b = hash(second);
        return Math.abs(hash(first) - hash(second)) <= 26;
    }

    public static int hash(String str) {
        return str.toLowerCase().chars().reduce(0,
                (total, cur) -> total + (cur - 'a'));
    }
}
