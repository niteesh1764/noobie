class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        int n = nums.size();
        vector<int> dp(n,0);
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            int skipCurrent = dp[i-1];
            int robCurrent = dp[i-2] + nums[i];
            dp[i] = max(skipCurrent,robCurrent);
        }
        return dp[n-1];
    }
};


class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        int n = nums.size();
        int twoBack = nums[0];
        int oneBack = max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            int skipCurrent = oneBack;
            int robCurrent = twoBack + nums[i];
            int curr = max(skipCurrent,robCurrent);
            twoBack = oneBack;
            oneBack = curr;
        }
        return oneBack;
    }
};
