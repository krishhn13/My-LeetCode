#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static bool doesValidArrayExist(vector<int>& derived) {
        return accumulate(derived.begin(), derived.end(), 0, bit_xor<>())==0;
    }
};