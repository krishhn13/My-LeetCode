#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans ;
        vector<int> temp;
        generate(ans, temp, 0, nums);
        return ans;
    }
    void generate(vector<vector<int>>& ans, vector<int>&temp, int idx, vector<int>&nums) {
        if(idx == nums.size()) {
            ans.push_back(temp);
            return ;
        }
        temp.push_back(nums[idx]);
        generate(ans, temp, idx+1, nums);
        temp.pop_back();
        generate(ans, temp, idx+1, nums);
    }
};