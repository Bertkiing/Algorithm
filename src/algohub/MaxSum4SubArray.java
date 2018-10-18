package algohub;

public class MaxSum4SubArray {

    /**
     *  YouTube : https://www.youtube.com/watch?v=kekmCQXYwQ0
     * @param array
     * @return
     */
    private int maxValue(int[] array){
        int max_so_far = array[0];
        int max_ending_here = 0;

        for (int i = 0; i < array.length; i++) {
            max_ending_here = max_ending_here + array[i];

            if(max_so_far < max_ending_here){
                max_so_far = max_ending_here;
            }

            if(max_ending_here < 0){
                max_ending_here = 0;
            }
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        MaxSum4SubArray test = new MaxSum4SubArray();
        int[] array = {4,-3,-2,2,3,1,-2,-3,4,2,-6,-3,-1,3,1,2};
        System.out.println(test.maxValue(array));
    }


}
