int minStartValue(int *nums, int numsSize)
{
        int sum = 0, mini = 0;
        for (int i = 0; i < numsSize; i++)
        {
                sum = sum + nums[i];
                mini = mini > sum ? sum : mini;
        }
        return 1 - mini;
}