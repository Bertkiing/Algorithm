package test;

public class TestString {

    public static void main(String[] args) {


        Float f = 1f;
        System.out.println(f.toString());//1.0
        System.out.println(subZeroAndDot("1"));
        ;  // 转换后为1
        System.out.println(subZeroAndDot("10"));
        ;  // 转换后为10
        System.out.println(subZeroAndDot("1.0"));
        ;  // 转换后为1
        System.out.println(subZeroAndDot("1.010"));
        ;  // 转换后为1.01
        System.out.println(subZeroAndDot("1.01"));
        ;  // 转换后为1.01
        System.out.println(subZeroAndDot("0.10000"));
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

}