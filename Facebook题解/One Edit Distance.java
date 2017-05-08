public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {//only check till min cuz we don't care if last char diff
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));//means try to replace 1 char from either one
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));//means try to add 1 char to s, or delete 1 char from t
                } else {
                    return s.substring(i + 1).equals(t.substring(i));//means try to add 1 char to t, or delete 1 char from s
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;//""and"" should return false,cuz it have to be exactly 1 edit distance!
    }
}