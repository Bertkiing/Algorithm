/**
 * Created by king on 2017/12/30.
 * 欧几里徳算法
 * In other word ,辗转相除法
 */
public class Gcd {
    public static void main(String[] args) {
        System.out.println("求解最大公约数徳欧几里徳算法");
        System.out.println("8，4的最大公约数是："+gcd(4,8));
    }

    public static int gcd(int p,int q){
        if(q == 0) return p;
        int r = p % q;
        return gcd(q,r);
    }
}
