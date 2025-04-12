// Problem 2 Triangle (https://leetcode.com/problems/triangle/)

// Time Complexity : O(n*n) 
// Space Complexity : O(n*n), optimized o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, start from last but one row and for each element in row add min(j,j+1) element of next row. Finally return traingle.get(0).get(0) which 
 * is the 1st element of triangle.
 */
// 1
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size()-2; i>=0;i--){
            List<Integer> currList = triangle.get(i);
            List<Integer> nextList = triangle.get(i+1);

            for(int j = 0; j<currList.size();j++){
                int min = Math.min(nextList.get(j),nextList.get(j+1));
                currList.set(j, currList.get(j)+min);
            }
        }
        return triangle.get(0).get(0);
    }
}
// 2
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][]memo = new int[n][n];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return helper(triangle, 0, 0, memo);
    }
    private int helper(List<List<Integer>> triangle, int i, int j, int [][]memo){
        //base
        if(i == triangle.size()) return 0;
        if(memo[i][j] != Integer.MIN_VALUE) return memo[i][j];
        //logic
        int case1 = helper(triangle, i+1, j, memo);
        int case2 = helper(triangle, i+1, j+1, memo);
        int result = triangle.get(i).get(j) + Math.min(case1, case2);
        memo[i][j] = result;
        return result;
    }
}
// 3
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][]dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2; i>=0;i--){
            for(int j = 0; j<=i;j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
// 4
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i = n-2; i>=0;i--){
            for(int j = 0; j<=i;j++){
                int re = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, re);
            }
        }
        return triangle.get(0).get(0);
    }
}