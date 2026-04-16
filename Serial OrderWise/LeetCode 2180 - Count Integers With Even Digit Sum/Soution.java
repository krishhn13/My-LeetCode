class Solution {
    private boolean checkSum(int num)
    {
        int sum = 0;
        while(num > 0)
        {
            sum+=num%10;
            num/=10;
        }
        return sum%2==0;
    }

    public int countEven(int num) {
        int count = 0;
        for(int i = 2 ; i <= num ; i++)
        {
            if(checkSum(i))
            {
                count++;
            }
        }
        return count;
    }
}