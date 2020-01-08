package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bertking
 * @date 2020/1/3
 * 回溯法(暂时没掌握)
 * https://leetcode-cn.com/problems/permutations/comments/
 */
public class Leecode46 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leecode46 leecode46 = new Leecode46();
        int[] arr = {1,2,3};
        System.out.println(leecode46.permute(arr));
    }
}


