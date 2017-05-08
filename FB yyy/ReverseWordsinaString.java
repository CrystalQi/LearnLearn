package Facebook;

public class ReverseWordsinaString {
    public static String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) != ' ') {
                break;
            }
            ++idx;
        }
        start = idx;
        int i = 0;
        for (; idx < s.length(); ++idx) {
            if (s.charAt(idx) == ' ') {
            	if (idx - start > 0) {
	                sb.append(' ');
	                i = idx - 1;
	                while (i >= start) {
	                    sb.append(s.charAt(i));
	                    --i;
	                }
            	}
                start = idx + 1;
            }
        }
        if (s.charAt(idx - 1) != ' ') {
        	if (idx - start + 1 > 0) { 
	        	sb.append(' ');
	            i = idx - 1;
	            while (i >= start) {
	                sb.append(s.charAt(i));
	                --i;
	            }
        	}
        }
        if (sb.length() == 0) {
        	return "";
        }
        return sb.reverse().toString().substring(0, sb.length() - 1);
    }
    
    public static void main(String [] args) {
    	System.out.print("-");
		System.out.print(reverseWords("a  b  "));
    	System.out.print("-");
	}
}
