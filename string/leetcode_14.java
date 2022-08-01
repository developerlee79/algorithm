package string;

public class leetcode_14 {
    public static void main(String[] args) {
        leetcode_14 lc = new leetcode_14();
        String[] str = {"flower", "flow", "flight"};
        System.out.println(lc.longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
        return pre;
    }
}
