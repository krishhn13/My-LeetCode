class Solution(object):
    def generate(self, ans, temp, idx, nums) :
        if idx == len(nums) :
            ans.append(list(temp))
            return
        temp.append(nums[idx])
        self.generate(ans, temp, idx+1, nums)
        temp.pop()
        self.generate(ans, temp, idx+1, nums)

    def subsets(self, nums):
        ans, temp = [],[]
        self.generate(ans,temp,0,nums)
        return ans