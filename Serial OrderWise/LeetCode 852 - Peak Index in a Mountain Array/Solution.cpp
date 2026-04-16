#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
        int peakIndexInMountainArray(vector<int> &arr)
        {
                int s = 0, e = arr.size() - 1;
                int m = (s + e) / 2;
                while (s <= e)
                {
                        if (arr[m - 1] < arr[m] && arr[m] > arr[m + 1])
                        {
                                return m;
                        }
                        else if (arr[m - 1] < arr[m])
                        {
                                s = m + 1;
                        }
                        else
                        {
                                e = m;
                        }
                        m = (s + e) / 2;
                }
                return -1;
        }
};