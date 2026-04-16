class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int ans = 0;
        int indx = 0;
        while(indx<boxTypes.length && truckSize>0){
            if(boxTypes[indx][0]<=truckSize) {
                truckSize-=boxTypes[indx][0];
                ans+=(boxTypes[indx][1] * boxTypes[indx][0]); 
            } else {
                ans+=(boxTypes[indx][1] * truckSize);
                truckSize=0;
            }
            indx++;
        }
        return ans;
    }
}