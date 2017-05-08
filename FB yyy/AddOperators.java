package Facebook;

import java.util.ArrayList;
import java.util.List;


public class AddOperators {
	static int total = 0;
	public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        String path = "";
        helper(res, path, num, (long)0, (long)target);
        return res;
    }
    
    private static void helper(List<String> res, String path, String num, long lastDiff, long target) {
        if (target == 0 && num.length() == 0) {
            res.add(path);
        }
        for (int i = 1; i <= num.length(); ++i) {
            String tmpNumStr = num.substring(0, i);
            if (tmpNumStr.charAt(0) == '0' && tmpNumStr.length() > 1) {
                return;
            }
            long tmpNum = Long.parseLong(tmpNumStr);
            if (path.length() == 0) {
                helper(res, path + tmpNumStr, num.substring(i), tmpNum, target - tmpNum);
            } else {
                helper(res, path + "+" + tmpNumStr, num.substring(i), tmpNum, target - tmpNum);
                helper(res, path + "-" + tmpNumStr, num.substring(i), -tmpNum, target + tmpNum);
              //  helper(res, path + "*" + tmpNumStr, num.substring(i), lastDiff * tmpNum, target + lastDiff - lastDiff * tmpNum);
            }
        }
    }
    
	public static int addOperatorsII(String num, int target) {
        helper(num, (long)target, true);
        return total;
    }
	
	private static void helper(String num, long target, boolean start) {
		if (num.length() == 0 && target == 0) {
			++total;
			return;
		}
		
		for (int i = 1; i <= num.length(); ++i) {
			if (num.charAt(0) == '0' && i > 1) {
				return;
			}
			String tmpNum = num.substring(0, i);
			long number = Long.parseLong(tmpNum);
			if (start) {
				helper(num.substring(i), target - number, false);
            } else {
				helper(num.substring(i), target - number, false);
				helper(num.substring(i), target + number, false);
            }
		}
	}
	
	public static void main(String [] args) {
		String s = "12345678";
		System.out.println(addOperators(s, 5));
		System.out.println(addOperatorsII(s, 5));
	}
}
