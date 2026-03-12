#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minStartValue(vector<int>& nums) {
        int sum = 0, mini = 0;
        for(int num : nums) {
            sum += num;
            mini = mini > sum ? sum : mini;
        }
        return 1 - mini;
    }
};