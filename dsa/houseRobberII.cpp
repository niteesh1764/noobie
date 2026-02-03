class Solution {
public:

    int ans(vector<int>& nums){
        int n = nums.size();
        int twoBack = nums[0];
        int oneBack = max(nums[0] , nums[1]);
        for(int i=2;i<n;i++){
            int current = max(oneBack, twoBack + nums[i]);
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
    int rob(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        if(nums.size() == 2) return max(nums[0] , nums[1]);
        int n = nums.size();
        vector<int> v1,v2;
        
        for(int i=0; i<n;i++){
            if(i != 0) v1.push_back(nums[i]);
            if(i != n-1) v2.push_back(nums[i]);
        }
        return max(ans(v1), ans(v2));
    }
};
