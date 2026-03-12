class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        sum, mini = 0, 0
        for i in nums:
            sum += i
            mini = min(sum,mini)
        return 1 - mini