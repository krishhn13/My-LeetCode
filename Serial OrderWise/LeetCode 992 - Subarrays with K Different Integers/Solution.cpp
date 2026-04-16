#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int solve(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        int l = 0, r = 0, n = nums.size();
        map[nums[0]] = 1;
        long ans = 0;
        while(l<=r) {
            if(map.size()<=k) {
                ans += r - l + 1;
                if(r < n-1) {
                    r++;
                    map[nums[r]]++;
                } else {
                    break;
                }
            } else {
                map[nums[l]]--;
                if(map[nums[l]] <= 0) {
                    map.erase(nums[l]);
                }
                l++;
            }
        }
        return ans;
    }
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        return solve(nums, k) - solve(nums, k-1);
    }
};