class Solution{
public:
	int climbStairs(int n){
		if(n==0 || n==1) return 1;
		return climbStairs(n-1) + climbStairs(n-2);
	}
};

class Solution{
public:
	int climbStairs(int n , unordered_map<int,int>& memo){
		if(n==0 || n==1) return 1;

		if(memo.find(n) == memo.end()){
			memo[n] = climbStairs(n-1,memo) + climbStairs(n-2,memo);
		}
		return memo[n];
	}

	int climbStairs(int n){
		unordered_map<int,int> memo;
		return climbStairs(n,memo);
	}
};

class Solution{
public:
	int climbStairs(int n){
		vector<int> dp(n+1);
		dp[0] = dp[1] = 1;

		for(int i=2;i<=n;i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
};

class Solution{
public: 
	int climbStairs(int n){
		int prev = 1;
		int curr = 1;
		for(int i=2;i<=n;i++){
			int temp = curr;
			curr = prev + curr;
			prev = temp;
		}
		return curr;
	}
};
