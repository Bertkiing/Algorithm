package test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author bertking
 * @date 2019/11/5
 */
public class PrintS {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        System.out.println(a+b);

        System.out.println(Double.MAX_VALUE);
      boolean x =   Double.MAX_VALUE > 1247536894779635.5;
        BigDecimal bd = new BigDecimal(Double.MAX_VALUE);
        System.out.println(bd.toPlainString());
        System.out.println(x);
    }
}
