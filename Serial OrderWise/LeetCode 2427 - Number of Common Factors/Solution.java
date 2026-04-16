class Solution {
    public int commonFactors(int a, int b) {
        //because 1 is a common factor in every case
        int count = 1; 
        int min = (a<b)?a:b;
        for(int i =2 ; i<=min;i++)
        {
            if((a%i==0) && (b%i==0))
            {
                count++;
            }
        }
        return count;
    }
}