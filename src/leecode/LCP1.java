package leecode;

/**
 * @author bertking
 * @date 2020/1/7
 */
public class LCP1 {
    public static void main(String[] args) {
    int[] guess = {1,2,3};
    int[] answer = {1,2,3};
        System.out.println("Result:"+ game(guess,answer));
    }

    public static int game(int[] guess, int[] answer) {
        int result = 0;
        for (int i = 0; i < guess.length; i++) {
            if(guess[i] ==answer[i]){
                result +=1;
            }
        }
        return result;
    }
}
