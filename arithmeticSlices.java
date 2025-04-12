// Problem1 Arithmetic Slices (https://leetcode.com/problems/arithmetic-slices/)

// Time Complexity : O(n) 
// Space Complexity : O(n), optimized o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, start from last 2nd element and check if difference between last 1st element and last 2nd element and last -last first is same or not
 * if yes make dp at that position as right position+ 1 and continue till 0th index. Finally return count of all elements of dp. 
 */
// 1
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        int count = 0;
        for(int i = n-3; i>=0; i--){
            if(nums[i+2]-nums[i+1] == nums[i+1] - nums[i]){
                dp[i] = dp[i + 1] + 1;
            }
            else{
                dp[i] = 0;
            }
            count += dp[i];
        }
        return count;
    }
}
// 2
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        int curr = 0;
        int right = 0;
        for(int i = n-3; i>=0; i--){
            if(nums[i+2]-nums[i+1] == nums[i+1] - nums[i]){
                curr = right + 1;
            }
            else{
                curr = 0;
            }
            count += curr;
            right = curr;
        }
        return count;
    }
}