package easy;

/**
 * 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * eg:
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * limit:
 * 0 <= s 的长度 <= 10000
 *
 * @author chenjianglin
 * @date 2021/2/20
 * @since 1.0.0
 **/
public class ReplaceSpace {

    //method2
    public static String replaceSpace2(String input) {
        if (null == input || input.length() >= 10000) {
            return "";
        }
        int length = input.length();
        char[] chars = new char[length*3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = c;
            }
        }
        return new String(chars,0,size);
    }

    //自己的方法
    public static String replaceSpace(String input,String patten){
        if (null == input || input.length() >= 10000 || null == patten) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        for (char ch : input.toCharArray()){
            if (ch == ' ') {
                str.append(patten);
                continue;
            }
            str.append(ch);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String input = "We are happy.";
        System.out.println(replaceSpace(input,"%20"));
        System.out.println(replaceSpace2(input));
    }
}
